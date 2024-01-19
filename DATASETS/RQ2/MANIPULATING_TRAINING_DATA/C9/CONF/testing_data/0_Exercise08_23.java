import java.util.Scanner;

public class FindFlippedCell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        System.out.println("Please enter a 6x6 matrix, row by row (use 0s and 1s):");

        // Read the input matrix
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int flippedRow = -1;
        int flippedColumn = -1;

        // Check rows for an odd number of 1s
        for (int row = 0; row < 6; row++) {
            int rowSum = 0;
            for (int col = 0; col < 6; col++) {
                rowSum += matrix[row][col];
            }
            if (rowSum % 2 != 0) {
                flippedRow = row;
                break;
            }
        }

        // Check columns for an odd number of 1s
        for (int col = 0; col < 6; col++) {
            int colSum = 0;
            for (int row = 0; row < 6; row++) {
                colSum += matrix[row][col];
            }
            if (colSum % 2 != 0) {
                flippedColumn = col;
                break;
            }
        }

        if (flippedRow != -1 && flippedColumn != -1) {
            System.out.println("The flipped cell is at (" + flippedRow + ", " + flippedColumn + ")");
        } else {
            System.out.println("No cell appears to be flipped in the input matrix.");
        }
    }
}