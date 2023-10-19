import java.util.Arrays;
import java.util.Random;

public class MatrixChecker {
    
    public static void main(String[] args) {
        // Generate the matrix
        int[][] matrix = generateMatrix(6);
        
        // Print the matrix
        printMatrix(matrix);
        
        // Check if every row and column has an even number of 1s
        if (checkMatrix(matrix)) {
            System.out.println("Every row and column has an even number of 1s.");
        } else {
            System.out.println("Not every row and column has an even number of 1s.");
        }
    }
    
    public static int[][] generateMatrix(int size) {
        Random random = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        return matrix;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean checkMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
        
        // Count the number of 1s in each row and column
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        // Check if every row and column has an even number of 1s
        for (int i = 0; i < numRows; i++) {
            if (rowCount[i] % 2 != 0) {
                return false;
            }
        }
        for (int j = 0; j < numCols; j++) {
            if (colCount[j] % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}