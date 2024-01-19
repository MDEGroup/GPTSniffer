public class EightQueensSolver {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Eight Queens Problem Solver!");

        // Initialize the chessboard
        int[][] chessboard = new int[8][8];

        // Solve and display the solution
        solveEightQueens(chessboard, 0);

        // Display the solved chessboard
        displayChessboard(chessboard);
    }

    // Recursive method to solve the Eight Queens problem
    public static boolean solveEightQueens(int[][] chessboard, int row) {
        if (row == 8) {
            // All queens are placed successfully
            return true;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < 8; col++) {
            if (isSafe(chessboard, row, col)) {
                // Place the queen
                chessboard[row][col] = 1;

                // Recur to place queens in the next rows
                if (solveEightQueens(chessboard, row + 1)) {
                    return true;
                }

                // Backtrack if placing the queen in this column doesn't lead to a solution
                chessboard[row][col] = 0;
            }
        }

        // No safe placement found in any column for the current row
        return false;
    }

    // Method to check if a queen can be placed at a specific position
    public static boolean isSafe(int[][] chessboard, int row, int col) {
        // Check the left side of the row
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        // The position is safe
        return true;
    }

    // Method to display the solved chessboard
    public static void displayChessboard(int[][] chessboard) {
  