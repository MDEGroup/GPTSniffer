import java.util.Scanner;

public class FlippedCellFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        System.out.println("Enter a 6-by-6 matrix row by row:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int row = -1;
        int col = -1;

        for (int i = 0; i < 6; i++) {
            int rowCount = 0;
            int colCount = 0;

            for (int j = 0; j < 6; j++) {
                rowCount += matrix[i][j];
                colCount += matrix[j][i];
            }

            if (rowCount % 2 != 0) {
                row = i;
            }
            if (colCount % 2 != 0) {
                col = i;
            }
        }

        System.out.println("The flipped cell is at (" + row + ", " + col + ")");
    }
}