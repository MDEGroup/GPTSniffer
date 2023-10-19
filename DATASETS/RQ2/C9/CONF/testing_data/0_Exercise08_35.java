import java.util.Scanner;

/**
 * This program finds the largest square submatrix of 1s in a given square matrix.
 */
public class LargestBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input the matrix size
        System.out.print("Enter the number of rows in the matrix: ");
        int n = input.nextInt();

        int[][] matrix = new int[n][n];
        
        // Input matrix elements
        System.out.println("Enter the elements of the matrix (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Find the largest square submatrix
        int[] result = findLargestBlock(matrix);

        // Display the result
        System.out.println("The largest square submatrix of 1s starts at (" + result[0] + ", " + result[1] + ")");
        System.out.println("It has a size of " + result[2] + "x" + result[2]);
    }

    /**
     * Finds and returns the largest square submatrix of 1s.
     *
     * @param matrix The input square matrix.
     * @return An array containing [row, column, size] of the largest square submatrix.
     */
    public static int[] findLargestBlock(int[][] matrix) {
        int maxSize = 0; // Initialize the size of the largest block to 0
        int[] result = new int[3]; // Array to store the result [row, column, size]

        // Create a table to store the maximum square size ending at each position in the matrix
        int[][] sizeTable = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    // If the current cell is 1, calculate the size of the square ending at (i, j)
                    if (i == 0 || j == 0) {
                        sizeTable[i][j] = 1;
                    } else {
                        sizeTable[i][j] = Math.min(sizeTable[i - 1][j - 1], Math.min(sizeTable[i - 1][j], sizeTable[i][j - 1])) + 1;
                    }

                    // Update the result if a larger square is found
                    if (sizeTable[i][j] > maxSize) {
                        maxSize = sizeTable[i][j];
                        result[0] = i - maxSize + 1; // Row index of the top-left corner
                        result[1] = j - maxSize + 1; // Column index of the top-left corner
                        result[2] = maxSize; // Size of the square
                    }
                }
            }
        }

        return result;
    }
}