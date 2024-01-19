import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        char[][] board = new char[6][7]; // Initializing the game board
        initializeBoard(board); // Setting up the initial empty board
        boolean gameOver = false; // Flag to track game end
        char currentPlayer = 'R'; // Starting player with red disk

        while (!gameOver) {
            displayBoard(board); // Displaying the current board

            int column = getColumn(currentPlayer); // Asking for player input

            dropDisk(board, column, currentPlayer); // Dropping the disk

            if (isWinner(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("The " + currentPlayer + " player won!");
                gameOver = true; // Game ends if a player wins
            } else if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("It's a draw!");
                gameOver = true; // Game ends if the board is full
            } else {
                currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R'; // Switching players
            }
        }
    }

    // Initialize the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current board state
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
    }

    // Get the column where the player wants to drop the disk
    public static int getColumn(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int column;
        do {
            System.out.print("Drop a " + currentPlayer + " disk at column (0–6): ");
            column = scanner.nextInt();
        } while (column < 0 || column > 6);
        return column;
    }

    // Drop the disk into the specified column
    public static void dropDisk(char[][] board, int column, char currentPlayer) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = currentPlayer;
                break;
            }
        }
    }

    // Check if the current player has connected four disks
    public static boolean isWinner(char[][] board, char currentPlayer) {
        // TODO: Implement the logic to check for a winner
        return false; // Placeholder return
    }

    // Check if the board is full (resulting in a draw)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == ' ') {
                    return false; // If there's an empty space, the board is not full
                }
            }
        }
        return true; // Board is full
    }
}