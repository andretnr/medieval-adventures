package firstAdventure;

import firstAdventure.base.Inicio;

import java.util.Scanner;

public class start {

    private static final Inicio inicio = new Inicio();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        inicio.executar(entrada);
        entrada.close();
    }
}
