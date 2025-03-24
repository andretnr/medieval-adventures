package firstAdventure.base;

import java.util.Scanner;


public class Inicio {
    public void executar(Scanner scan) {
        AudioPlayer.tocarMusicaInicio();
        executarOptions(scan);
        scan.close();
    }

    private void executarOptions(Scanner scan) {
        TelaInicial.execute();
        System.out.println("\nPressione Enter para continuar...");
    //    loadingAnimado();
        scan.nextLine();
        Options.execute(scan);
    }

//    private void loadingAnimado() {
//        String[] animacao = {".", "..", "..."};
//        int i = 0;
//        while (!hasPressedEnter()) {
//            System.out.print("\rLoading" + animacao[i % 3]);
//            i++;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private boolean hasPressedEnter() {
        return new Scanner(System.in).nextLine().isEmpty();
    }

}
