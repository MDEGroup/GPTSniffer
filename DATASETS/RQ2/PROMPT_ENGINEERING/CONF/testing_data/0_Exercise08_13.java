import java.util.Scanner;

public class LargestElementFinder {

    public static int[] locateLargest(double[][] a) {
        int[] location = new int[2];
        double max = a[0][0];
        location[0] = 0;
        location[1] = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

        return location;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        double[][] array = new double[rows][cols];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Enter element [%d][%d]: ", i, j);
                array[i][j] = scanner.nextDouble();
            }
        }

        int[] location = locateLargest(array);
        System.out.printf("The location of the largest element is at [%d][%d]\n", location[0], location[1]);
    }
}