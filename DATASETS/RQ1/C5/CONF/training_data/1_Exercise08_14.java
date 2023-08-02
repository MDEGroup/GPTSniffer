

import java.util.*;


public class RandomMatrixFiller{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size for the the matrix: ");
        int size = in.nextInt();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (0.5 + Math.random());
            }
        }
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }

        
        int[] row = checkRows(matrix);
        
        int[] column = checkColumns(matrix);


        if (row != null) {
            System.out.println("All " + row[0] + " on " + "row " + row[1]);
        } else {
            System.out.println("No same numbers on a row");
        }

        if (column != null) {
            System.out.println("All " + column[0] + " on " + "column " + column[1]);
        } else {
            System.out.println("No same numbers on a column");
        }


    }

    static int[] checkColumns(int[][] matrix) {
        for (int checkNum = 0; checkNum <= 1; checkNum++) {
            for (int i = 0; i < matrix.length; i++) {
                if (checkColumn(matrix, i, checkNum)) {
                    return new int[]{checkNum, i};
                }
            }
        }
        return null;
    }

    static boolean checkColumn(int[][] matrix, int column, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] != num) {
                return false;
            }
        }
        return true;
    }

    static int[] checkRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowCheck = matrix[i][0];
            COLUMN:
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != rowCheck) {
                    break COLUMN;
                } else if (j == matrix[i].length - 1) {
                    return new int[]{rowCheck, i};
                }
            }
        }
        return null;
    }
}