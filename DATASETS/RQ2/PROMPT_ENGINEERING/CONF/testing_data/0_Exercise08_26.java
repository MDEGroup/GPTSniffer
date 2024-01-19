import java.util.Arrays;
import java.util.Scanner;

public class RowSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row:");
        double[][] matrix = new double[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        
        double[][] sortedMatrix = sortRows(matrix);
        System.out.println("The row-sorted array is:");
        printMatrix(sortedMatrix);
    }

    public static double[][] sortRows(double[][] m) {
        double[][] sorted = new double[m.length][m[0].length];
        
        for (int i = 0; i < m.length; i++) {
            sorted[i] = Arrays.copyOf(m[i], m[i].length);
            Arrays.sort(sorted[i]);
        }
        
        return sorted;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}