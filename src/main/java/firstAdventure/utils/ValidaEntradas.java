package firstAdventure.utils;

import java.util.Scanner;

public class ValidaEntradas {

    private ValidaEntradas() {}

    public static String validaEscolhaSimOuNao(String entry, Scanner scan) {
        while (!"S".equalsIgnoreCase(entry) && !"N".equalsIgnoreCase(entry)) {
            System.out.println("Entrada inválida! Por favor, insira 'S' para sim ou 'N' para não.");
            entry = scan.nextLine().trim();
        }
        return entry;
    }

    public static int validaEntradaNumerico(int min, int max, int value, Scanner scan) {
        while (value < min || value > max) {
            System.out.printf("Entrada inválida! O valor deve estar entre %d e %d: %n", min, max);
            value = scan.nextInt();
            scan.nextLine();
        }
        return value;
    }
}
