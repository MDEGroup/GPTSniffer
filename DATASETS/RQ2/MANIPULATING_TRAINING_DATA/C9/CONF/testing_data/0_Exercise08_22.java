import java.util.Random;

public class EvenOnesMatrixChecker {
    public static void main(String[] args) {
        // Define the matrix dimensions
        int numRows = 6;
        int numCols = 6;

        // Create a 6x6 matrix and fill it with random 0s and 1s
        int[][] matrix = generateRandomBinaryMatrix(numRows, numCols);

        // Display the generated matrix
        displayMatrix(matrix);

        // Check if every row and column has an even number of 1s
        boolean isEvenOnes = checkEvenOnes(matrix);

        if (isEvenOnes) {
            System.out.println("Every row and every column have an even number of 1s.");
        } else {
            System.out.println("Not every row and every column have an even number of 1s.");
        }
    }

    // Function to generate a random binary matrix
    public static int[][] generateRandomBinaryMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(2); // Randomly assigns 0 or 1
            }
        }
        return matrix;
    }

    // Function to display a matrix
    public static void displayMatrix(int[][] matrix) {
        System.out.println("Generated Matrix:");

        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Function to check if every row and column has an even number of 1s
    public static boolean checkEvenOnes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Check rows
        for (int i = 0; i < numRows; i++) {
            int onesCount = 0;
            for (int j = 0; j < numCols; j++) {
                onesCount += matrix[i][j];
            }
            if (onesCount % 2 != 0) {
                return false; // Row has an odd number of 1s
            }
        }

        // Check columns
        for (int j = 0; j < numCols; j++) {
            int onesCount = 0;
            for (int i = 0; i < numRows; i++) {
                onesCount += matrix[i][j];
            }
            if (onesCount % 2 != 0) {
                return false; // Column has an odd number of 1s
            }
        }

        return true; // All rows and columns have an even number of 1s
    }
}