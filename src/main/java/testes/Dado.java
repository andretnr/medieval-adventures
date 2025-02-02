package testes;

import java.util.Random;

public class Dado {

    public static void main(String[] args) {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;


        for(int i = 0; i < 100; i++ ){
            int dado = dado();

            switch (dado) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
            }
        }
        System.out.println("Numeros Gerados:");
        System.out.println("Numeros 1: " + one);
        System.out.println("Numeros 2: " + two);
        System.out.println("Numeros 3: " + three);
        System.out.println("Numeros 4: " + four);
        System.out.println("Numeros 5: " + five);
        System.out.println("Numeros 6: " + six);

    }

    private static int dado() {
        Random random = new Random();
        int numero = random.nextInt(6) + 1;
      //  System.out.println("Número gerado: " + numero);
        return numero;
    }
}
