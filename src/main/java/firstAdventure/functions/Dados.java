package firstAdventure.functions;

import firstAdventure.utils.PrintMapTable;
import firstAdventure.utils.ValidaEntradas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dados {

    public static void execute(Scanner scan){
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n\nDigite o numero do dado que deseja jogar: ");
            Map<Integer, String> optionsMap = dadosMap();
            PrintMapTable.execute(optionsMap);
            int dadoSelecionado = scan.nextInt();
            ValidaEntradas.validaEntradaNumerico(1, optionsMap.size(), dadoSelecionado, scan);
            continuar = executaAcao(dadoSelecionado);
        }
    }

    private static boolean executaAcao(int dadoSelecionado) {
        switch (dadoSelecionado) {
            case 1:
                dadoMultiFaces(3);
                break;
            case 2:
                dadoMultiFaces(6);
                break;
            case 3:
                dadoMultiFaces(10);
                break;
            case 4:
                dadoMultiFaces(20);
                break;
            case 5:
                dadoMultiFaces(50);
                break;
            case 6:
                dadoMultiFaces(100);
                break;
            case 7:
                dadoMultiFaces(999);
                break;
            case 8:
                dadoMultiFaces(80);
                break;
            case 9:
                System.out.println("Saindo...");
                return false;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
        return true;
    }

    private static Map<Integer, String> dadosMap() {
        Map<Integer, String> faces = new HashMap<>();
        faces.put(1, "Jogar D3");
        faces.put(2, "Jogar D6 (Padrão)");
        faces.put(3, "Jogar D10");
        faces.put(4, "Jogar D20");
        faces.put(5, "Jogar D50");
        faces.put(6, "Jogar D100");
        faces.put(7, "Jogar D999");
        faces.put(8, "Jogar D80");
        faces.put(9, "Sair!");
        return faces;
    }

//    private static Integer dadoMultiFaces(Integer faces) {
//        Random random = new Random();
//        return random.nextInt(faces) + 1;
//    }

    private static void dadoMultiFaces(int faces) {
        int resultado = (int) (Math.random() * faces) + 1;
        System.out.println("\nVocê rolou um D" + faces + " e obteve: " + resultado);
        if (resultado == faces) {
            System.out.println("Quanta sorte! Você conseguiu um acerto crítico! =)");
        } else if (resultado == 1) {
            System.out.println("Que azar! Você obteve uma falha crítica! =(");
        } else if (resultado <= faces * 0.25) {
            System.out.println("Que pena! Você ficou um pouco abaixo da média. Boa sorte da próxima vez!");
        } else if (resultado >= faces * 0.75) {
            System.out.println("Parabéns! Você obteve um resultado impressionante! Continue assim!");
        } else {
            System.out.println("Você obteve um resultado razoável. Não foi tão bom, mas também não foi ruim.");
        }
    }

}
