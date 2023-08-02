

import java.util.*;


public class Exercise08_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of a two-dimensional array: ");
        int numRows = in.nextInt();
        int numColumns = in.nextInt();
        int[][] values = new int[numRows][numColumns];
        System.out.println("Enter the values: ");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = in.nextInt();
            }
        }

        System.out.println("Are there four consecutive numbers?");
        System.out.println(isConsecutiveFour(values));
        in.close();
    }

    public static boolean isConsecutiveFour(int[][] values) {

        int count = 0;
        int lastVal = 0;
        /* Check rows */
        for (int r = 0; r < values.length; r++) {
            count = 0;
            for (int c = 0; c < values[r].length; c++) {
                int val = values[r][c];
                if (val == lastVal) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 4) {
                    return true;
                }

            }
        }
        lastVal = 0;
        /* Check Columns */
        for (int c = 0; c < values[0].length; c++) {
            count = 0;
            for (int r = 0; r < values.length; r++) {
                int val = values[r][c];
                if (val == lastVal) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 4) {
                    return true;
                }

            }
        }

        /* Check Diagonals */
        for (int r = 0; r < values.length; r++) {
            for (int c = 0; c < values[r].length; c++) {
                int val = values[r][c];
                count = 1;
                /* Check down and right diagonal */
                for (int d = 1; (r + d) < values.length && (c + d) < values[r].length; d++) {
                    if (values[r + d][c + d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }

                /* Check up and right diagonal */
                for (int d = 1; (r - d) >= 0 && (c + d) < values[r].length; d++) {
                    if (values[r - d][c + d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;
                }

                /* Check down and left diagonal */
                for (int d = 1; (r + d) < values.length && (c - d) >= 0; d++) {
                    if (values[r + d][c - d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }

                /* Check up and left diagonal */
                for (int d = 1; (r - d) >= 0 && (c - d) >= 0; d++) {
                    if (values[r - d][c - d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }
            }

        }
        return false;
    }
}