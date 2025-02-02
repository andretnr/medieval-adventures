package firstAdventure.personagem;

import firstAdventure.models.Personagem;
import firstAdventure.utils.PrintMapTable;
import firstAdventure.utils.ValidaEntradas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistribuirPontos {


    public static void execute(Personagem person, Scanner entrada) {
        boolean melhorarAtribs = true;
        System.out.println("Você possui " + person.getPontos() + " pontos para distribuir!");
        while (melhorarAtribs) {

        System.out.println("\nEscolha o atributo que deseja melhorar:");

        Map<Integer, String> atribs = atribMap();
        PrintMapTable.execute(atribs);
        int atribId = entrada.nextInt();
        ValidaEntradas.validaEntradaNumerico(1,7, atribId, entrada);
        String atribSelec = atribs.get(atribId);
        System.out.println("Você optou por melhorar " + atribSelec);
        int pontos = person.getPontos();
        System.out.printf("\nDigite quantos pontos você deseja adicionar a %s, você ainda possui %d pontos!%n", atribSelec, pontos);
        int valorEscolhido = entrada.nextInt();
        ValidaEntradas.validaEntradaNumerico(1, pontos, valorEscolhido, entrada);
            switch (atribId) {
                case 1:
                    person.setForca(person.getForca() + valorEscolhido);
                    System.out.println("Força aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                case 2:
                    person.setDestreza(person.getDestreza() + valorEscolhido);
                    System.out.println("Destreza aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                case 3:
                    person.setConstituicao(person.getConstituicao() + valorEscolhido);
                    System.out.println("Constituicao aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                case 4:
                    person.setInteligencia(person.getInteligencia() + valorEscolhido);
                    System.out.println("Inteligência aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                case 5:
                    person.setSabedoria(person.getSabedoria() + valorEscolhido);
                    System.out.println("Sabedoria aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                case 6:
                    person.setCarisma(person.getCarisma() + valorEscolhido);
                    System.out.println("Carisma aumentado em: "+ valorEscolhido + " pontos!");
                    break;
                case 7:
                    person.setSorte(person.getSorte() + valorEscolhido);
                    System.out.println("Sorte aumentada em: "+ valorEscolhido + " pontos!");
                    break;
                default:
                    System.out.println("Algum erro ocorreu, pontos não foram adicionados");
                    break;
            }
            person.setPontos(pontos - valorEscolhido);
            person.calculaEvo();
            if(person.getPontos() == 0){
                System.out.println("Você não tem mais pontos para distribuir!");
                return;
            }
            System.out.println("Você ainda possui "+ person.getPontos() + " pontos! \n Deseja continuar a melhoria de atributos? (S/N)");
            String decisao = entrada.next();
            ValidaEntradas.validaEscolhaSimOuNao(decisao, entrada);
            if("N".equalsIgnoreCase(decisao)){
                melhorarAtribs = false;
            }

        }



    }


    private static Map<Integer, String> atribMap() {
        Map<Integer, String> atribs = new HashMap<>();
        atribs.put(1, "Força");
        atribs.put(2, "Destreza");
        atribs.put(3, "Constituição");
        atribs.put(4, "Inteligência");
        atribs.put(5, "Sabedoria");
        atribs.put(6, "Carisma");
        atribs.put(7, "Sorte");
        return atribs;
    }

}
