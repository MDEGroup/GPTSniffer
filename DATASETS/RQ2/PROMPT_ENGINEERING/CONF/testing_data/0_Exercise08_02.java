import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[4][4];

        System.out.println("Enter a 4x4 matrix of double values:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter value for row " + (i + 1) + " and column " + (j + 1) + ": ");
                matrix[i][j] = input.nextDouble();
            }
        }

        double sum = calculateDiagonalSum(matrix);
        System.out.println("The sum of the numbers in the major diagonal is: " + sum);
    }

    public static double calculateDiagonalSum(double[][] matrix) {
        double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}