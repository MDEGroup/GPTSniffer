import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        displayBoard(board);

        char currentPlayer = 'X';
        boolean gameEnded = false;
        int row, col;

        while (!gameEnded) {
            System.out.printf("Enter a row (0, 1, or 2) for player %s: ", currentPlayer);
            row = getPlayerInput();
            System.out.printf("Enter a column (0, 1, or 2) for player %s: ", currentPlayer);
            col = getPlayerInput();

            if (board[row][col] == '\u0000') { // check if cell is available
                board[row][col] = currentPlayer;
                displayBoard(board);

                if (hasPlayerWon(board, currentPlayer)) {
                    System.out.printf("%s player won\n", currentPlayer);
                    gameEnded = true;
                } else if (isBoardFull(board)) {
                    System.out.println("The game is a draw");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // switch player
                }
            } else {
                System.out.println("This cell is already occupied. Please try again.");
            }
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '\u0000'; // empty cell
            }
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int getPlayerInput() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n < 0 || n > 2) {
            System.out.println("Invalid input. Please enter a number between 0 and 2.");
            n = input.nextInt();
        }
        return n;
    }

    private static boolean hasPlayerWon(char[][] board, char player) {
        // check rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0