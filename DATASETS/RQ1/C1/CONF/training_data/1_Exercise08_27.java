package ch_08;

import java.util.*;


public class Exercise08_27 {

    public static double[][] sortColumns(double[][] m) {
        double[][] sorted = new double[m.length][m.length];

        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted[i].length; j++) {
                sorted[i][j] = m[i][j];
            }
        }

        for (int col = 0; col < sorted.length; col++) {
            boolean keepSorting = true;
            while (keepSorting) {
                keepSorting = false;
                for (int row = 0; row < sorted[col].length - 1; row++) {
                    if (sorted[row][col] < sorted[row + 1][col]) {
                        keepSorting = true;
                        double temp = sorted[row][col];
                        sorted[row][col] = sorted[row + 1][col];
                        sorted[row + 1][col] = temp;
                    }

                }
            }
        }
        return sorted;

    }
}