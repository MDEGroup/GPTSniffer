import java.util.Scanner;

public class LargestElementFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the number of rows and columns in the array: ");
        int rows = input.nextInt();
        int columns = input.nextInt();
        
        double[][] array = new double[rows][columns];
        
        System.out.println("Please enter the array elements: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        
        int maxRow = 0;
        int maxColumn = 0;
        double maxElement = array[0][0];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (array[i][j] > maxElement) {
                    maxElement = array[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }
        
        System.out.println("The location of the largest element is " + maxElement + " at (" + maxRow + ", " + maxColumn + ")");
        
        input.close();
    }
}