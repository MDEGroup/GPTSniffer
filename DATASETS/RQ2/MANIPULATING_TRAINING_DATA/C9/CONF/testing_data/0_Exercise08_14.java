import java.util.Scanner;

public class ExploreMatrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the size of the matrix
        System.out.print("Enter the size for the matrix: ");
        int size = input.nextInt();

        // Create and populate the matrix with random 0s and 1s
        int[][] matrix = generateRandomMatrix(size);

        // Print the matrix
        printMatrix(matrix);

        // Check and display rows with all 0s or all 1s
        checkAndPrintRows(matrix);

        // Check and display columns with all 0s or all 1s
        checkAndPrintColumns(matrix);

        // Check and display the major diagonal (top-left to bottom-right)
        checkAndPrintMajorDiagonal(matrix);

        // Check and display the sub-diagonal (bottom-left to top-right)
        checkAndPrintSubDiagonal(matrix);
    }

    // Generates a square matrix of the specified size with random 0s and 1s
    private static int[][] generateRandomMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }

    // Prints the matrix to the console
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    // Checks and prints rows with all 0s or all 1s
    private static void checkAndPrintRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on row " + (i + 1));
            }
            if (allOnes) {
                System.out.println("All 1s on row " + (i + 1));
            }
        }
    }

    // Checks and prints columns with all 0s or all 1s
    private static void checkAndPrintColumns(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on column " + (j + 1));
            }
            if (allOnes) {
                System.out.println("All 1s on column " + (j + 1));
            }
        }
    }

    // Checks and prints the major diagonal (top-left to bottom-right)
    private static void checkAndPrintMajorDiagonal(int[][] matrix) {
        boolean allZeros = true;
        boolean allOnes = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the major diagonal");
        }
        if (allOnes) {
            System.out.println("All 1s on the major diagonal");
        }
    }

    // Checks and prints the sub-diagonal (bottom-left to top-right)
    private static void checkAndPrintSubDiagonal(int[][] matrix) {
        boolean allZeros = true;
        boolean allOnes = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - 1 - i] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the sub-diagonal");
        }
        if (allOnes) {
            System.out.println("All 1s on the sub-diagonal");
        }
    }
}