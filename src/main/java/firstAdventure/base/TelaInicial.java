package firstAdventure.base;

public class TelaInicial {

    public static void execute() {
        int resultado = (int) (Math.random() * 4) + 1;
        switch (resultado) {
            case 2:
                exibirTelaInicialTwo();
                break;
            case 3:
                exibirTelaInicialThree();
                break;
            case 4:
                exibirTelaInicialFour();
                break;
            default:
                exibirTelaInicialOne();
                break;
        }
    }

    private static void exibirTelaInicialOne() {
        StringBuilder apresentacao = new StringBuilder();

        apresentacao.append("\n");
        apresentacao.append("########################################################\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("#                AVENTURA EM RPG - O JOGO              #\n");
        apresentacao.append("#             (Explore, lute e vença desafios!)        #\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("########################################################\n");
        apresentacao.append("\n");

        // Arte ASCII simples
        apresentacao.append("         __    __       __           __                \n");
        apresentacao.append("        /  \\  /  \\     /  \\         /  \\               \n");
        apresentacao.append("       /    \\/    \\   /    \\       /    \\              \n");
        apresentacao.append("      |     ||     |  |     |      |     |             \n");
        apresentacao.append("      |     ||     |  |     |      |     |             \n");
        apresentacao.append("      |     ||     |  |     |      |     |             \n");
        apresentacao.append("       \\   /  \\   /    \\   /       \\   /              \n");
        apresentacao.append("        \\_/    \\_/      \\_/         \\_/                \n");

        apresentacao.append("\n");
        apresentacao.append("                Jogo Criado por: AndCranio            \n");
        apresentacao.append("\n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("    Bem-vindo ao mundo das aventuras e batalhas!      \n");
        apresentacao.append("    Aqui você pode construir seu personagem, lutar    \n");
        apresentacao.append("    contra monstros e explorar um mundo repleto de   \n");
        apresentacao.append("    mistérios!                                        \n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("\n");
        apresentacao.append("           ~ Que a sorte esteja com você! ~       \n");
        apresentacao.append("\n");
        apresentacao.append("########################################################\n");

        // Exibe a apresentação no console
        animacao(apresentacao.toString());
        //System.out.println(apresentacao.toString());
    }

    private static void exibirTelaInicialTwo() {
        StringBuilder apresentacao = new StringBuilder();

        // Cabeçalho com bordas e título do jogo
        apresentacao.append("########################################################\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("#          AVENTURA EM RPG - O JOGO                    #\n");
        apresentacao.append("#        (Explore, lute, vença e se aventure!)         #\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("########################################################\n");
        apresentacao.append("\n");

        // Arte ASCII mais detalhada
        apresentacao.append("                ___====-_  _-====___                 \n");
        apresentacao.append("           _--^^^#####//      \\\\#####^^^--_          \n");
        apresentacao.append("        _-^##########// (    ) \\\\##########^-_       \n");
        apresentacao.append("       -############//  |\\^^/|  \\\\############-      \n");
        apresentacao.append("     _/############//   (@::@)   \\\\############\\_     \n");
        apresentacao.append("    /#############((     \\/     ))#############\\    \n");
        apresentacao.append("   -###############\\    (\\/)    /###############-   \n");
        apresentacao.append("    \\###############\\   (oo)   /###############/    \n");
        apresentacao.append("     -###############\\  / U \\  /###############-     \n");
        apresentacao.append("      -###############\\/  |  \\/###############-      \n");
        apresentacao.append("       _/##############/  |  \\##############\\_       \n");
        apresentacao.append("      /###############/   |   \\###############\\      \n");
        apresentacao.append("     -###############/    |    \\###############-     \n");
        apresentacao.append("      \\##############/     |     \\##############/    \n");
        apresentacao.append("       ^^^^######^^^^      |      ^^^^######^^^^      \n");
        apresentacao.append("\n");

        // Informações sobre o jogo
        apresentacao.append("              Jogo Criado por: AndCranio            \n");
        apresentacao.append("\n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("    Bem-vindo ao mundo das aventuras, monstros e magia! \n");
        apresentacao.append("    Aqui, você criará um herói, enfrentará desafios    \n");
        apresentacao.append("    e fará escolhas que definirão o destino do mundo.   \n");
        apresentacao.append("    Prepare-se para um mundo repleto de mistérios,     \n");
        apresentacao.append("    batalhas e muita exploração!                       \n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("\n");

        // Mensagem de boas-vindas
        apresentacao.append("       ~ Que a sorte esteja com você, aventureiro! ~  \n");
        apresentacao.append("\n");

        // Rodapé com borda
        apresentacao.append("########################################################\n");

        // Exibindo a apresentação no console
        animacao(apresentacao.toString());
       // System.out.println(apresentacao.toString());
    }

    private static void exibirTelaInicialThree() {
        StringBuilder apresentacao = new StringBuilder();

        // Cabeçalho com bordas e título do jogo
        apresentacao.append("########################################################\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("#         AVENTURA NO REINO ENCANTADO - O JOGO         #\n");
        apresentacao.append("#   (Desafios, magia e mistérios aguardam você!)       #\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("########################################################\n");
        apresentacao.append("\n");

        // Arte ASCII de castelo
        apresentacao.append("              T    T          T    T                 \n");
        apresentacao.append("              |    |          |    |                 \n");
        apresentacao.append("            __|    |__________|    |__               \n");
        apresentacao.append("           /  |    |    ______    |    |\\            \n");
        apresentacao.append("          /   |    |   |      |   |    | \\           \n");
        apresentacao.append("         /____|    |___|______|___|    |  \\_________ \n");
        apresentacao.append("        (______________________________)               \n");
        apresentacao.append("\n");

        // Informações sobre o jogo
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("    Bem-vindo ao Reino Encantado, onde aventuras       \n");
        apresentacao.append("    épicas aguardam! Explore masmorras, enfrente       \n");
        apresentacao.append("    dragões e tome decisões que mudarão seu destino!   \n");
        apresentacao.append("    O que você está esperando? Vamos começar sua       \n");
        apresentacao.append("    jornada!                                          \n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("\n");

        // Mensagem de boas-vindas
        apresentacao.append("       ~ Prepare-se para enfrentar o desconhecido! ~   \n");
        apresentacao.append("\n");

        // Rodapé com borda
        apresentacao.append("########################################################\n");

        // Exibindo a apresentação no console
        animacao(apresentacao.toString());
       // System.out.println(apresentacao.toString());
    }

    private static void exibirTelaInicialFour() {
        StringBuilder apresentacao = new StringBuilder();

        // Cabeçalho com bordas e título do jogo
        apresentacao.append("########################################################\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("#            AVENTURA NA FLORESTA MÁGICA               #\n");
        apresentacao.append("#  (Mistérios antigos, criaturas mágicas e magia!)     #\n");
        apresentacao.append("#                                                      #\n");
        apresentacao.append("########################################################\n");
        apresentacao.append("\n");

        // Arte ASCII de árvore ou floresta
        apresentacao.append("                &&&&&&&&&&&&&&&&&&&                  \n");
        apresentacao.append("             &&&&&&&&&&&&&&&&&&&&&&&&&                \n");
        apresentacao.append("           &&&&&&&&&&&&&&&&&&&&&&&&&&&&&              \n");
        apresentacao.append("        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&           \n");
        apresentacao.append("      &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&         \n");
        apresentacao.append("    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&     \n");
        apresentacao.append("    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&     \n");
        apresentacao.append("   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    \n");
        apresentacao.append("    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&     \n");
        apresentacao.append("              ~MYSTIC FOREST~                        \n");
        apresentacao.append("\n");

        // Informações sobre o jogo
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("    Você entrou na Floresta Mágica, onde segredos      \n");
        apresentacao.append("    e criaturas místicas habitam as sombras. Prepare-   \n");
        apresentacao.append("    se para desvendar mistérios antigos e enfrentar     \n");
        apresentacao.append("    poderosos inimigos. Aventura e magia o aguardam!    \n");
        apresentacao.append("    ===============================================     \n");
        apresentacao.append("\n");

        // Mensagem de boas-vindas
        apresentacao.append("     ~ Entre e desvende o que está oculto nas sombras ~ \n");
        apresentacao.append("\n");

        // Rodapé com borda
        apresentacao.append("########################################################\n");

        // Exibindo a apresentação no console
        animacao(apresentacao.toString());
        //System.out.println(apresentacao.toString());
    }

    private static void animacao(String s) {
        for (char c : s.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
