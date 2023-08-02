

import java.util.*;


public class CheckFlippedMatrix {
    public static void main(String[] args) {
        int[][] test = new int[6][6];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a 6 x 6 matrix row by row: ");

        int invalidRow = -1; 

        for (int i = 0; i < 6; i++) {
            int rowCountOnes = 0;
            for (int j = 0; j < 6; j++) {
                int n = in.nextInt();
                if (n == 1) {
                    rowCountOnes++;
                }
                test[i][j] = n;
            }
            if (rowCountOnes % 2 != 0) {
                invalidRow = i;
            }
        }
        int invalidCol = evalColumns(test);
        System.out.println("The flipped cell is at (" + invalidRow + ", " + invalidCol + ")");
        in.close();
    }

    static int evalColumns(int[][] array) {
        int invalidColumn = -1;
        for (int i = 0; i < 6; i++) {
            int colCount = 0;
            for (int j = 0; j < 6; j++) {
                if (array[j][i] == 1) {
                    colCount++;
                }

            }
            if (colCount % 2 != 0) {
                invalidColumn = i;
            }
        }
        return invalidColumn;
    }

}