import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a 4x4 matrix
        double[][] matrix = new double[4][4];
        System.out.println("Please enter a 4x4 matrix, row by row:");

        // Read the matrix from user input
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                matrix[row][col] = input.nextDouble();
            }
        }

        // Calculate and display the sum of the major diagonal
        double diagonalSum = sumMajorDiagonal(matrix);
        System.out.println("The sum of the major diagonal is: " + diagonalSum);

        // Close the input scanner
        input.close();
    }

    // Method to calculate the sum of the major diagonal of a matrix
    public static double sumMajorDiagonal(double[][] matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}