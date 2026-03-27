package firstAdventure.historia.motor;

import firstAdventure.historia.Inimigo;
import firstAdventure.models.Personagem;
import firstAdventure.utils.ValidaEntradas;

import java.util.Scanner;

/**
 * Combate turn-based entre o personagem e um inimigo.
 *
 * Mecânica:
 *  - Atacar: rola D20 para acerto/crítico/falha; dano = Força + D8.
 *  - Fugir:  chance = Destreza × 5 % (máx 70 %). Fuga reduz vida à metade.
 *
 * @return true se venceu; false se foi derrotado ou fugiu.
 */
public class CombateHandler {

    public boolean executar(Inimigo inimigo, Personagem personagem, Scanner scan) {

        double vidaInimigo = inimigo.getVidaMaxima();
        double vidaInicial = personagem.getVida();

        System.out.println();
        linha('╔', '╗', '═', 46);
        System.out.println("║       ⚔   COMBATE INICIADO   ⚔          ║");
        linha('╚', '╝', '═', 46);
        System.out.printf("  Você (Vida: %.0f)  vs  %s (Vida: %.0f)%n%n",
                personagem.getVida(), inimigo.getNome(), vidaInimigo);

        int turno = 1;
        while (personagem.getVida() > 0 && vidaInimigo > 0) {

            System.out.printf("─── Turno %d ─────────────────────────────────%n", turno++);
            System.out.printf("  Sua vida: %.0f  |  %s: %.0f%n%n",
                    personagem.getVida(), inimigo.getNome(), vidaInimigo);
            System.out.println("  1 - Atacar");
            System.out.println("  2 - Tentar fugir");
            System.out.print("  > ");

            int acao = scan.nextInt();
            scan.nextLine();
            acao = ValidaEntradas.validaEntradaNumerico(1, 2, acao, scan);

            if (acao == 2) {
                int chance = Math.min(personagem.getDestreza() * 5, 70);
                if ((int) (Math.random() * 100) + 1 <= chance) {
                    System.out.println("\n  Você conseguiu escapar!");
                    personagem.setVida(vidaInicial * 0.5);
                    return false;
                }
                System.out.println("\n  Fuga falhou! O inimigo te ataca!");
                atacarJogador(inimigo, personagem);
                continue;
            }

            // ── Ataque do jogador ──────────────────────────────────────────
            int d20      = rolar(20);
            int danoBase = personagem.getForca() + rolar(8);
            int dano;

            if (d20 == 20) {
                dano = danoBase * 2;
                System.out.printf("%n  🌟 CRÍTICO! (D20=%d) Golpe devastador!%n", d20);
            } else if (d20 == 1) {
                dano = 0;
                System.out.printf("%n  💨 Falha crítica! (D20=%d) Você errou!%n", d20);
            } else if (d20 >= 10) {
                dano = danoBase;
                System.out.printf("%n  💥 Acerto! (D20=%d) %d de dano.%n", d20, dano);
            } else {
                dano = Math.max(1, danoBase / 2);
                System.out.printf("%n  🔸 Golpe fraco! (D20=%d) %d de dano.%n", d20, dano);
            }

            vidaInimigo -= dano;
            System.out.printf("  %s: %.0f de vida restante.%n",
                    inimigo.getNome(), Math.max(0, vidaInimigo));

            if (vidaInimigo <= 0) {
                System.out.printf("%n  ✅ %s foi derrotado!%n", inimigo.getNome());
                double vidaMax = personagem.getConstituicao() * 5.0 + personagem.getForca() * 2.0 + personagem.getNivel() * 10.0;
                double rec     = vidaMax * 0.15;
                personagem.setVida(Math.min(personagem.getVida() + rec, vidaMax));
                System.out.printf("  ❤  Você recuperou %.0f de vida (%.0f total).%n", rec, personagem.getVida());
                break;
            }

            // ── Ataque do inimigo ──────────────────────────────────────────
            atacarJogador(inimigo, personagem);
        }

        return personagem.getVida() > 0;
    }

    private void atacarJogador(Inimigo inimigo, Personagem personagem) {
        int dano    = inimigo.getForca() + rolar(6);
        double nova = Math.max(0, personagem.getVida() - dano);
        personagem.setVida(nova);
        System.out.printf("  🗡  %s causou %d de dano! Sua vida: %.0f%n",
                inimigo.getNome(), dano, nova);
        if (nova <= 0) System.out.println("\n  💀 Você foi derrotado...");
    }

    private int rolar(int faces) {
        return (int) (Math.random() * faces) + 1;
    }

    private void linha(char esq, char dir, char meio, int total) {
        System.out.println(esq + String.valueOf(meio).repeat(total) + dir);
    }
}

