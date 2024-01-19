import java.util.Scanner;

public class LargestNumberFinder {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Largest Number Finder!");

        // Get user input for the list of integers
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[8];
        System.out.println("Enter eight integers, one at a time:");

        // Read integers from the user
        for (int i = 0; i < 8; i++) {
            System.out.print("Enter integer #" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Find and display the largest number
        int largestNumber = findLargestNumber(numbers);
        System.out.println("The largest number is: " + largestNumber);

        // Close the scanner
        scanner.close();
    }

    // Recursive method to find the largest number in an array
    public static int findLargestNumber(int[] array) {
        return findLargestNumberHelper(array, 0, array.length - 1);
    }

    // Helper method for recursive search
    private static int findLargestNumberHelper(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = findLargestNumberHelper(array, start, mid);
            int rightMax = findLargestNumberHelper(array, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }
}