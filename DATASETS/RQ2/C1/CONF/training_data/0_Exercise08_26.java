import java.util.Arrays;
import java.util.Scanner;

public class SortRowsDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a 3-by-3 matrix of double values
        System.out.println("Enter a 3-by-3 matrix row by row:");
        double[][] m = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = input.nextDouble();
            }
        }

        // Sort the rows of the matrix
        double[][] sorted = sortRows(m);

        // Display the sorted matrix
        System.out.println("The row-sorted array is");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sorted[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] sortRows(double[][] m) {
        // Create a new array to hold the sorted matrix
        double[][] sorted = new double[3][3];
        // Copy the elements of the original matrix to the new array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sorted[i][j] = m[i][j];
            }
        }
        // Sort each row of the new array
        for (int i = 0; i < 3; i++) {
            Arrays.sort(sorted[i]);
        }
        // Return the sorted matrix
        return sorted;
    }

}