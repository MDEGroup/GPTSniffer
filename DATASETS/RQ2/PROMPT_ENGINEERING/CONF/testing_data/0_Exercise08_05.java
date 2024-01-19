import java.util.Scanner;

public class MatrixAddition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter matrix A (3x3):");
        double[][] matrixA = enterMatrix(input);

        System.out.println("Enter matrix B (3x3):");
        double[][] matrixB = enterMatrix(input);

        double[][] sumMatrix = addMatrix(matrixA, matrixB);

        System.out.println("The sum of the matrices is:");
        displayMatrix(sumMatrix);
    }

    public static double[][] enterMatrix(Scanner input) {
        double[][] matrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}