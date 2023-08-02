import java.util.Scanner;

public class FindFlippedCell {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a 6-by-6 matrix
        System.out.println("Enter a 6-by-6 matrix row by row:");
        int[][] matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Find the first row r and first column c where the even number of 1s property is violated
        int row = -1, col = -1;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum % 2 != 0) {
                row = i;
            }
            if (colSum % 2 != 0) {
                col = i;
            }
        }

        // Display the result
        System.out.println("The flipped cell is at (" + row + ", " + col + ")");
    }
}