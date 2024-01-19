import java.util.Scanner;

public class MatrixMultiplier {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] matrixA = new double[3][3];
        double[][] matrixB = new double[3][3];

        System.out.println("Enter the elements of the first 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Enter element (%d, %d): ", i + 1, j + 1);
                matrixA[i][j] = input.nextDouble();
            }
        }

        System.out.println("Enter the elements of the second 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Enter element (%d, %d): ", i + 1, j + 1);
                matrixB[i][j] = input.nextDouble();
            }
        }

        double[][] product = multiplyMatrix(matrixA, matrixB);

        System.out.println("The product of the matrices is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }
}