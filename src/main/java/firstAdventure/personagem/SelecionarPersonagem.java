package firstAdventure.personagem;

import firstAdventure.base.Options;
import firstAdventure.data.read.BuscarPersonagensDAO;
import firstAdventure.models.GameContext;
import firstAdventure.models.Personagem;


import java.util.List;
import java.util.Scanner;

public class SelecionarPersonagem {

    public static void execute(Scanner scan) {
        List<Personagem> personagens = BuscarPersonagensDAO.execute();
        System.out.println("PERSONAGENS SALVOS:");
        exibirPersonagens(personagens);
        System.out.println(" ");
        Personagem selecionado = selecionarPersonagem(personagens, scan);
        System.out.println(selecionado.detalhadoPersonagem());
        GameContext.getInstance().setPersonagemSelecionado(selecionado);
    }

    public static Personagem selecionarPersonagem(List<Personagem> personagens, Scanner scan) {

        Personagem selecionado = null;
        while (selecionado == null) {
            System.out.println("Digite o ID do personagem que deseja selecionar:");
            int selected = scan.nextInt();

            for (Personagem p : personagens) {
                if (p.getId() == selected) {
                    selecionado = p;
                    break;
                }
            }

            if (selecionado == null) {
                System.out.println("Personagem com ID " + selected + " não encontrado.");
                System.out.println("Deseja tentar novamente? (1 - Sim, 2 - Sair)");
                int opcao = scan.nextInt();
                if (opcao == 2) {
                    System.out.println("Saindo da seleção de personagem.");
                    System.out.println(" ");
                    Options.execute(scan);
                }
            }
        }

        System.out.println("Personagem selecionado: " + selecionado.getNome());
        return selecionado;
    }

    public static void exibirPersonagens(List<Personagem> personagens) {
        System.out.printf("%s\n", "=".repeat(200));
        System.out.printf("| %-5s | %-20s | %-8s | %-10s | %-8s | %-8s | %-10s | %-12s | %-12s | %-12s | %-10s | %-8s | %-10s | %-10s | %-10s |\n",
                "ID", "NOME", "IDADE", "CLASSE", "NÍVEL", "FORÇA", "DESTREZA", "CONSTITUIÇÃO", "INTELIGÊNCIA", "SABEDORIA", "CARISMA", "VIDA", "ENERGIA", "SORTE", "PONTOS");
        System.out.printf("%s\n", "=".repeat(200));

        for (Personagem p : personagens) {
            System.out.printf("| %-5d | %-20s | %-8d | %-10s | %-8d | %-8d | %-10d | %-12d | %-12d | %-12d | %-10d | %-8.1f | %-10.1f | %-10d | %-10d |\n",
                    p.getId(), p.getNome(), p.getIdade(), p.getClasse().toString(), p.getNivel(), p.getForca(),
                    p.getDestreza(), p.getConstituicao(), p.getInteligencia(), p.getSabedoria(),
                    p.getCarisma(), p.getVida(), p.getEnergia(), p.getSorte(), p.getPontos());
        }
        System.out.printf("%s\n", "=".repeat(200));

    }

}
