package firstAdventure.utils;

import firstAdventure.models.Personagem;

import java.util.Scanner;

public class ValidaPontos {

    public static boolean execute(Personagem person, Scanner scan) {
        if (hasPontos(person)) {
            System.out.println("\nVocê tem pontos para distribuir. Deseja distribuir os pontos do seu personagem? (S/N)");
            String entry = scan.next();
            entry = ValidaEntradas.validaEscolhaSimOuNao(entry, scan);
            if ("S".equalsIgnoreCase(entry)) {
                return true;
            } else {
                System.out.println("Os pontos não foram distribuídos.");
                return false;
            }
        } else {
            System.out.println("Seu personagem não tem pontos disponíveis para distribuir.");
            return false;
        }
    }

    public static Boolean hasPontos(Personagem person) {
        return person.getPontos() > 0;
    }
}
