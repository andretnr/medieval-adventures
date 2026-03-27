package firstAdventure.base;

import firstAdventure.data.geraTabelas.CriarTabelas;

import java.util.Scanner;

public class Inicio {

    public void executar(Scanner scan) {
        inicializarBancoDados();
        AudioPlayer.tocarMusicaInicio();
        executarOptions(scan);
        scan.close();
    }

    /** Garante que as tabelas existam antes de qualquer operação. */
    private void inicializarBancoDados() {
        CriarTabelas.criarTabelaPersonagem();
        CriarTabelas.criarTabelaEstadoJogo();
    }

    private void executarOptions(Scanner scan) {
        TelaInicial.execute();
        System.out.println("\nPressione Enter para continuar...");
        scan.nextLine();
        Options.execute(scan);
    }
}
