import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        char[][] board = new char[3][3]; // Initialize the game board
        Scanner input = new Scanner(System.in); // Create Scanner object for input
        
        initializeBoard(board); // Initialize the board with empty spaces
        printBoard(board); // Display the initial empty board
        
        char currentPlayer = 'X'; // Player X starts the game
        boolean gameWon = false; // Track if the game is won
        boolean boardFull = false; // Track if the board is full (draw)
        
        while (!gameWon && !boardFull) {
            System.out.print("Enter a row (0, 1, or 2) for player " + currentPlayer + ": ");
            int row = input.nextInt(); // Get row input from player
            System.out.print("Enter a column (0, 1, or 2) for player " + currentPlayer + ": ");
            int col = input.nextInt(); // Get column input from player
            
            if (isValidMove(board, row, col)) { // Check if the move is valid
                board[row][col] = currentPlayer; // Update the board with the player's move
                printBoard(board); // Display the updated board
                
                if (checkWinner(board, currentPlayer)) { // Check if the current player has won
                    System.out.println(currentPlayer + " player won!");
                    gameWon = true;
                } else if (isBoardFull(board)) { // Check if the board is full (draw)
                    System.out.println("It's a draw!");
                    boardFull = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player turns
                }
            } else {
                System.out.println("Invalid move. Try again."); // Prompt for a valid move
            }
        }
        
        input.close(); // Close the Scanner object
    }
    
    // Method to initialize the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' '; // Set each cell to empty space
            }
        }
    }
    
    // Method to print the current state of the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("—");
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n——————-——————");
        }
    }
    
    // Method to check if a move is valid
    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
    
    // Method to check if a player has won
    public static boolean checkWinner(char[][] board, char currentPlayer) {
        // Check rows, columns, and diagonals for a winning combination
        return (board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) ||
               (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) ||
               (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) ||
               (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
    
    // Method to check if the board is full (draw)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false; // If any cell is empty, the board is not full
                }
            }
        }
        return true; // If no empty cells are found, the board is full
    }
}