package firstAdventure.utils;

import java.util.Map;
import java.util.Scanner;

public class ValidaEntradas {

    public static String validaEscolhaSimOuNao(String entry, Scanner scan) {
        while (!"S".equalsIgnoreCase(entry) && !"N".equalsIgnoreCase(entry)) {
            System.out.println("Entrada inválida! Por favor, insira 'S' para sim ou 'N' para não.");
            entry = scan.next();
            scan.nextLine();
        }
        scan.nextLine();
        return entry;
    }


    public static int validaEntradaNumerico(int min, int max, int value, Scanner scan) {
        while (value < min || value > max) {
            System.out.println("Entrada inválida! O valor deve estar entre " + min + " e " + max + ".");
            value = scan.nextInt();
            scan.nextLine();
        }
        scan.nextLine();
        return value;
    }

}
