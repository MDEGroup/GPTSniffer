import java.util.Scanner;

public class MatrixMultiplier {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Matrix A (3x3) Input:");
        double[][] matrixA = readMatrix(input, 3, 3);

        System.out.println("Matrix B (3x3) Input:");
        double[][] matrixB = readMatrix(input, 3, 3);

        double[][] result = multiplyMatrices(matrixA, matrixB);

        System.out.println("Result of Matrix Multiplication:");
        printMatrix(result);
    }

    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int numRowsA = a.length;
        int numColsA = a[0].length;
        int numRowsB = b.length;
        int numColsB = b[0].length;

        if (numColsA != numRowsB) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication.");
        }

        double[][] result = new double[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                double sum = 0.0;
                for (int k = 0; k < numColsA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static double[][] readMatrix(Scanner input, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}