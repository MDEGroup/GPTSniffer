import java.util.Scanner;
import java.util.Random;

public class ArrayElementReader {

    public static void main(String[] args) {
        // Declare and initialize an array with 100 randomly chosen integers
        int[] randomIntegers = new int[100];
        fillArrayWithRandomIntegers(randomIntegers);

        // Prompt the user to enter the index of the array
        System.out.println("Enter the index of the array (0-99):");

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Get user input for the array index
        int index = getUserIndexInput(scanner);

        // Display the corresponding element value or handle out-of-bounds exception
        displayArrayElement(randomIntegers, index);

        // Close the scanner to free up resources
        scanner.close();
    }

    // Method to fill the array with 100 randomly chosen integers
    private static void fillArrayWithRandomIntegers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000); // Filling with random integers between 0 and 999
        }
    }

    // Method to get user input for the array index
    private static int getUserIndexInput(Scanner scanner) {
        int index;
        while (true) {
            // Use try-catch to handle non-integer inputs
            try {
                System.out.print("Enter an index (0-99): ");
                index = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return index;
    }

    // Method to display the corresponding element value or handle out-of-bounds exception
    private static void displayArrayElement(int[] array, int index) {
        try {
            // Display the corresponding element value
            System.out.println("The element value at index " + index + " is: " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle out-of-bounds exception
            System.out.println("Out of Bounds. Please enter a valid index within the range (0-99).");
        }
    }
}