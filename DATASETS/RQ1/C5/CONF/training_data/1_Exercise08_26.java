

import java.io.DataOutput;
import java.util.*;


public class Sort2DArray{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        double[][] res = sortRows(matrix);
        System.out.println("The row-sorted array is: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(res[i]));

        }

    }

    public static double[][] sortRows(double[][] m) {
        double[][] sorted = new double[m.length][m.length];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(m[i], 0, sorted[i], 0, 3);
        }

        for (int i = 0; i < sorted.length; i++) {
            boolean keepSorting = true;
            while (keepSorting) {
                keepSorting = false;
                for (int j = 0; j < sorted[i].length - 1; j++) {
                    if (sorted[i][j] > sorted[i][j + 1]) {
                        double tmp = sorted[i][j];
                        sorted[i][j] = sorted[i][j + 1];
                        sorted[i][j + 1] = tmp;
                        keepSorting = true;
                    }
                }
            }
        }
        return sorted;

    }

}