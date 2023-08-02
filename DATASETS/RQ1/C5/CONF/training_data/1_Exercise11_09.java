

import java.util.ArrayList;
import java.util.Scanner;


public class CourseRevised{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        in.close();
        ArrayList<Integer> rowSums = new ArrayList<>();
        ArrayList<Integer> columnSums = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            rowSums.add(i, sum);
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[j][i];
            }
            columnSums.add(i, sum);
        }
        Integer maxRowValue = maxValue(rowSums);
        Integer maxColValue = maxValue(columnSums);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nRow sums: " + rowSums.toString());
        System.out.println("Column sums: " + columnSums.toString());

        System.out.print("The largest row index/es is: ");
        for (Integer i : rowSums) {
            if (i.equals(maxRowValue)) {
                System.out.print(rowSums.indexOf(i) + " ");
            }
        }
        System.out.print("\nThe largest column index is: ");

        for (Integer i : columnSums) {
            if (i.equals(maxColValue)) {
                System.out.print(columnSums.indexOf(i) + " ");
            }
        }


    }

    static Integer maxValue(ArrayList<Integer> nums) {
        Integer max = nums.get(0);
        for (Integer integer : nums) {
            max = Math.max(integer, max);
        }
        return max;
    }

}
