import java.util.Random;

public class EvenOnesChecker {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        Random random = new Random();

        // Filling the matrix with 0s and 1s
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2); // Randomly choosing 0 or 1
            }
        }

        // Displaying the matrix
        System.out.println("Generated Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Checking if every row and column has an even number of 1s
        boolean allRowsEvenOnes = true;
        boolean allColsEvenOnes = true;

        for (int i = 0; i < matrix.length; i++) {
            int rowOnesCount = 0;
            int colOnesCount = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                rowOnesCount += matrix[i][j];
                colOnesCount += matrix[j][i];
            }

            if (rowOnesCount % 2 != 0) {
                allRowsEvenOnes = false;
                break;
            }

            if (colOnesCount % 2 != 0) {
                allColsEvenOnes = false;
                break;
            }
        }

        // Displaying the result
        if (allRowsEvenOnes && allColsEvenOnes) {
            System.out.println("Every row and column has an even number of 1s.");
        } else {
            System.out.println("Not every row and column has an even number of 1s.");
        }
    }
}