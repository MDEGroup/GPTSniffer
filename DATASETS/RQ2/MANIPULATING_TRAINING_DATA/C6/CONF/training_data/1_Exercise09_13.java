

import java.util.Scanner;


public class ArrayTest{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");

        int numRow = in.nextInt();
        int numCol = in.nextInt();
        double[][] numbers = new double[numRow][numCol];

        System.out.println("Enter the array: ");

        for (int r = 0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[r].length; c++) {
                numbers[r][c] = in.nextDouble();
            }
        }
        Location location = Location.locateLargest(numbers);

        System.out.printf("The location of the largest element is: %.2f at (%d, %d)", location.maxValue, location.row,
                location.column
        );


    }
}
