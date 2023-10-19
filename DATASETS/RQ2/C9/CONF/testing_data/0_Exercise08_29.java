import java.util.Scanner;

public class IdenticalArrays {
    public static void main(String[] args) {
        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        // Prompt the user to enter the first array
        System.out.println("Enter the first array (3x3):");
        fillArray(array1);

        // Prompt the user to enter the second array
        System.out.println("Enter the second array (3x3):");
        fillArray(array2);

        // Check if the two arrays are identical and display the result
        if (areArraysIdentical(array1, array2)) {
            System.out.println("The two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }
    }

    // Method to fill a 2D array with user input
    public static void fillArray(int[][] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the elements of the array:");
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = input.nextInt();
            }
        }
    }

    // Method to check if two 2D arrays are identical
    public static boolean areArraysIdentical(int[][] array1, int[][] array2) {
        if (array1.length != array2.length || array1[0].length != array2[0].length) {
            return false;
        }

        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array1[row].length; col++) {
                if (array1[row][col] != array2[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}