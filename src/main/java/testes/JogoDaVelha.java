package testes;

import java.util.Scanner;

public class JogoDaVelha {

    private static final char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private static final char JOGADOR_X = 'X';
    private static final char JOGADOR_O = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char jogadorAtual = JOGADOR_X;
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            imprimirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", escolha a linha e a coluna (0-2):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (movimentoValido(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificarVencedor(jogadorAtual)) {
                    imprimirTabuleiro();
                    System.out.println("Parabéns! O jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (tabuleiroCheio()) {
                    imprimirTabuleiro();
                    System.out.println("Empate! O jogo terminou sem vencedor.");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == JOGADOR_X) ? JOGADOR_O : JOGADOR_X;
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void imprimirTabuleiro() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    private static boolean movimentoValido(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificarVencedor(char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                    (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        return (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador);
    }

    private static boolean tabuleiroCheio() {
        for (char[] linha : tabuleiro) {
            for (char celula : linha) {
                if (celula == ' ') return false;
            }
        }
        return true;
    }
}
