package firstAdventure.historia.motor;

import firstAdventure.data.read.BuscarEstadoJogoDAO;
import firstAdventure.data.save.SalvarEstadoJogoDAO;
import firstAdventure.data.update.AtualizarPersonagemDAO;
import firstAdventure.historia.*;
import firstAdventure.models.EstadoJogo;
import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;
import firstAdventure.personagem.AplicarNivel;
import firstAdventure.utils.ValidaEntradas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Motor genérico que executa qualquer {@link Historia}.
 *
 * Fluxo por cena:
 *  NORMAL   → exibe texto, filtra escolhas visíveis, aplica efeito e avança.
 *  COMBATE  → delega ao {@link CombateHandler}; roteia vitória/derrota.
 *  FIM_*    → exibe texto final, persiste progresso e retorna ao menu.
 */
public class MotorHistoria {

    private static final CombateHandler combate = new CombateHandler();

    public static void executar(Historia historia, Scanner scan) {

        Personagem personagem = GameContext.getInstance().getPersonagemSelecionado();
        if (personagem == null) {
            System.out.println("\n⚠  Nenhum personagem selecionado!");
            System.out.println("   Crie ou selecione um personagem antes de iniciar uma aventura.\n");
            return;
        }

        // ── Verificar save existente ──────────────────────────────────────────
        EstadoJogo estado = BuscarEstadoJogoDAO.buscarAtivo(personagem.getId(), historia.getId());

        if (estado != null) {
            System.out.printf("%n💾 Aventura salva encontrada em '%s'.%n", historia.getTitulo());
            System.out.print("   Deseja continuar de onde parou? (S/N): ");
            String resp = scan.nextLine().trim();
            resp = ValidaEntradas.validaEscolhaSimOuNao(resp, scan);
            if ("N".equalsIgnoreCase(resp)) {
                estado = null;
            }
        }

        if (estado == null) {
            estado = new EstadoJogo(personagem.getId(), historia.getId(), historia.getCenaInicialId());
            if (personagem.getId() != null) {
                SalvarEstadoJogoDAO.salvar(estado);
            }
        }

        // ── Cabeçalho ─────────────────────────────────────────────────────────
        System.out.println();
        separador('═', 58);
        System.out.println("  " + historia.getTitulo().toUpperCase());
        System.out.println("  " + historia.getDescricao());
        separador('═', 58);
        System.out.println();

        // ── Loop principal ────────────────────────────────────────────────────
        while (!estado.isConcluido()) {

            Cena cena = historia.getCena(estado.getCenaAtualId());
            if (cena == null) {
                System.err.println("Erro: cena '" + estado.getCenaAtualId() + "' não encontrada.");
                break;
            }

            exibirCabecalhoCena(cena);
            narrar(cena.getTexto());

            switch (cena.getTipo()) {

                case COMBATE -> {
                    boolean venceu = combate.executar(cena.getInimigo(), personagem, scan);
                    if (venceu) {
                        int xp = cena.getInimigo().getXpRecompensa();
                        personagem.setExperiencia(personagem.getExperiencia() + xp);
                        GameContext.getInstance().setPersonagemSelecionado(personagem);
                        System.out.printf("%n  ✨ Você ganhou %d XP!%n", xp);
                        AplicarNivel.verificarEvolucao();
                        aplicarEfeito(cena.getEfeitoAposVitoria(), personagem, estado);
                        estado.setCenaAtualId(cena.getCenaAposVitoria());
                    } else {
                        estado.setCenaAtualId(cena.getCenaSeDerrota());
                    }
                    persistirEstado(estado, personagem);
                }

                case FIM_VITORIA, FIM_DERROTA -> {
                    estado.setConcluido(true);
                    persistirEstado(estado, personagem);
                    AtualizarPersonagemDAO.execute(personagem);
                    System.out.println();
                    separador('═', 58);
                    System.out.printf("  %s%n", cena.getTipo() == TipoCena.FIM_VITORIA
                            ? "🏆  FIM — VITÓRIA!" : "💀  FIM — DERROTA");
                    separador('═', 58);
                    System.out.printf("  Personagem: %s  |  Vida: %.0f  |  Nível: %d%n%n",
                            personagem.getNome(), personagem.getVida(), personagem.getNivel());
                    return;
                }

                default -> {  // NORMAL
                    List<Escolha> visiveis = escolhasVisiveis(cena.getEscolhas(), estado);
                    if (visiveis.isEmpty()) {
                        System.out.println("(Sem escolhas disponíveis — fim imprevisto)");
                        break;
                    }
                    Escolha escolha = apresentarEscolhas(visiveis, scan);
                    aplicarEfeito(escolha.getEfeito(), personagem, estado);
                    String proxima = resolverProxima(escolha, estado);
                    estado.setCenaAtualId(proxima);
                    persistirEstado(estado, personagem);
                }
            }
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private static List<Escolha> escolhasVisiveis(List<Escolha> todas, EstadoJogo estado) {
        List<Escolha> visiveis = new ArrayList<>();
        for (Escolha e : todas) {
            if (!e.temRequisito() || estado.temFlag(e.getRequisitoFlag())) {
                visiveis.add(e);
            }
        }
        return visiveis;
    }

    private static Escolha apresentarEscolhas(List<Escolha> escolhas, Scanner scan) {
        System.out.println();
        for (int i = 0; i < escolhas.size(); i++) {
            System.out.printf("  %d - %s%n", i + 1, escolhas.get(i).getTexto());
        }
        System.out.print("\n  > ");
        int op = scan.nextInt();
        scan.nextLine();
        op = ValidaEntradas.validaEntradaNumerico(1, escolhas.size(), op, scan);
        return escolhas.get(op - 1);
    }

    private static String resolverProxima(Escolha escolha, EstadoJogo estado) {
        if (escolha.temRedirecionamento() && estado.temFlag(escolha.getFlagParaRedirecionar())) {
            return escolha.getCenaIdAlternativa();
        }
        return escolha.getProximaCenaId();
    }

    private static void aplicarEfeito(EfeitoEscolha efeito, Personagem personagem, EstadoJogo estado) {
        if (efeito == null || efeito == EfeitoEscolha.VAZIO) return;

        if (efeito.getXpGanho() > 0) {
            personagem.setExperiencia(personagem.getExperiencia() + efeito.getXpGanho());
            System.out.printf("  ✨ +%d XP!%n", efeito.getXpGanho());
            GameContext.getInstance().setPersonagemSelecionado(personagem);
            AplicarNivel.verificarEvolucao();
        }
        if (efeito.getVidaRecuperada() > 0) {
            double nova = personagem.getVida() + efeito.getVidaRecuperada();
            personagem.setVida(nova);
            System.out.printf("  ❤  +%.0f de vida recuperada! (%.0f total)%n",
                    efeito.getVidaRecuperada(), nova);
        }
        if (efeito.temFlag()) {
            estado.adicionarFlag(efeito.getFlagAdicionar());
        }
    }

    private static void persistirEstado(EstadoJogo estado, Personagem personagem) {
        if (estado.getId() != null) {
            SalvarEstadoJogoDAO.atualizar(estado);
        }
        GameContext.getInstance().setPersonagemSelecionado(personagem);
    }

    private static void exibirCabecalhoCena(Cena cena) {
        System.out.println();
        separador('─', 58);
        if (!cena.getTitulo().isBlank()) {
            System.out.println("  📖  " + cena.getTitulo().toUpperCase());
            separador('─', 58);
        }
        System.out.println();
    }

    private static void narrar(String texto) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(c == '.' || c == '!' || c == '?' ? 60 : 18); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println();
    }

    private static void separador(char c, int largura) {
        System.out.println(String.valueOf(c).repeat(largura));
    }
}

