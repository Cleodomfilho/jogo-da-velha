import java.util.Scanner;

public class JogoDaVelha {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String jogador1 = obterNomeJogador("Primeiro");
        String jogador2 = obterNomeJogador("Segundo");

        inicializarTabuleiro();
        mostrarTabuleiro();

        while (true) {
            int linha, coluna;
            do {
                System.out.print(jogadorAtual + ", escolha a linha (1-3): ");
                linha = scanner.nextInt() - 1;
                System.out.print(jogadorAtual + ", escolha a coluna (1-3): ");
                coluna = scanner.nextInt() - 1;
            } while (!validarJogada(linha, coluna));

            fazerJogada(linha, coluna);
            mostrarTabuleiro();

            if (verificarVitoria(jogadorAtual)) {
                System.out.println("Parabéns, " + jogadorAtual + " (" + (jogadorAtual == 'X' ? jogador1 : jogador2) + ") venceu!");
                break;
            } else if (verificarEmpate()) {
                System.out.println("Empate!");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void mostrarTabuleiro() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean validarJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3) {
            System.out.println("Jogada Inválida, escolha a linha (1-3) ");
            return false;
        } else if (tabuleiro[linha][coluna] != ' ') {
            System.out.println("Posição Ocupada, escolha a linha (1-3)");
            return false;
        }
        return true;
    }




    private static void fazerJogada(int linha, int coluna) {
        tabuleiro[linha][coluna] = jogadorAtual;
    }

    private static boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;
            }
        }
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }
        return false;
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static String obterNomeJogador(String numero) {
        System.out.print("Digite o nome do " + numero + " jogador: ");
        return scanner.nextLine();
    }

}