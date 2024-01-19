import java.util.Scanner;

public class ConnectFourGame {
    public static void main(String[] args) {
        char[][] board = new char[6][7];
        initializeBoard(board);
        boolean isGameOver = false;
        char currentPlayer = 'R';

        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            printGameBoard(board);

            int selectedColumn;
            do {
                System.out.print("Player " + currentPlayer + ", drop your disk at column (0-6): ");
                selectedColumn = scanner.nextInt();
            } while (!isValidMove(board, selectedColumn));

            dropDisk(board, selectedColumn, currentPlayer);
            isGameOver = hasPlayerWon(board, currentPlayer) || isBoardFull(board);

            if (isGameOver) {
                printGameBoard(board);
                if (hasPlayerWon(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("It's a draw!");
                }
            }

            currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R'; // Switch players
        }

        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public static void printGameBoard(char[][] board) {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("|" + board[row][col]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    public static boolean isValidMove(char[][] board, int column) {
        return column >= 0 && column < 7 && board[0][column] == ' ';
    }

    public static void dropDisk(char[][] board, int column, char player) {
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = player;
                break;
            }
        }
    }

    public static boolean hasPlayerWon(char[][] board, char player) {
        // Implement logic to check for a win in rows, columns, and diagonals
        // Return true if the player has won, otherwise return false
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int col = 0; col < 7; col++) {
            if (board[0][col] == ' ') {
                return false;
            }
        }
        return true;
    }
}