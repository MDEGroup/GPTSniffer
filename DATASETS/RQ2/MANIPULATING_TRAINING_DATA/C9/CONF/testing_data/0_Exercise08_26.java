import java.util.Scanner;

public class MatrixRowSorter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3x3 matrix row by row:");

        double[][] matrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }

        double[][] sortedMatrix = sortRows(matrix);

        System.out.println("The row-sorted array is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sortedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] sortRows(double[][] inputMatrix) {
        int rows = inputMatrix.length;
        int columns = inputMatrix[0].length;
        double[][] sortedMatrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sortedMatrix[i][j] = inputMatrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++) {
                for (int k = 0; k < columns - j - 1; k++) {
                    if (sortedMatrix[i][k] > sortedMatrix[i][k + 1]) {
                        double temp = sortedMatrix[i][k];
                        sortedMatrix[i][k] = sortedMatrix[i][k + 1];
                        sortedMatrix[i][k + 1] = temp;
                    }
                }
            }
        }

        return sortedMatrix;
    }
}