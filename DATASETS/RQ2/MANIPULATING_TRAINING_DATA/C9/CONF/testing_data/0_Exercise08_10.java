import java.util.Random;

public class LargestRowAndColumnFinder {

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(4, 4);
        printMatrix(matrix);

        int largestRowIndex = findRowWithMostOnes(matrix);
        int largestColumnIndex = findColumnWithMostOnes(matrix);

        System.out.println("The row with the most ones is at index: " + largestRowIndex);
        System.out.println("The column with the most ones is at index: " + largestColumnIndex);
    }

    public static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(2); // Generate a random 0 or 1
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int findRowWithMostOnes(int[][] matrix) {
        int largestCount = 0;
        int largestRowIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > largestCount) {
                largestCount = count;
                largestRowIndex = i;
            }
        }

        return largestRowIndex;
    }

    public static int findColumnWithMostOnes(int[][] matrix) {
        int largestCount = 0;
        int largestColumnIndex = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > largestCount) {
                largestCount = count;
                largestColumnIndex = j;
            }
        }

        return largestColumnIndex;
    }
}