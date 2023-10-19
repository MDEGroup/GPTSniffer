import java.util.Random;

public class MatrixRowShuffler {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {3, 4},
            {5, 6},
            {7, 8},
            {9, 10}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        shuffleRows(matrix);

        System.out.println("\nShuffled Matrix:");
        printMatrix(matrix);
    }

    public static void shuffleRows(int[][] matrix) {
        Random random = new Random();

        for (int i = matrix.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap rows matrix[i] and matrix[j]
            int[] tempRow = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tempRow;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}