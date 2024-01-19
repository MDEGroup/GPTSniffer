// Importing necessary classes for Scanner and formatting
import java.util.Scanner;

// Definition of the class
public class DivisibleNumbersFinder {

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Greet the user
        System.out.println("Welcome to the Divisible Numbers Finder!");

        // Prompt the user to press Enter to start the program
        System.out.print("Press Enter to find the numbers...");
        scanner.nextLine(); // Pause for dramatic effect

        // Display numbers from 100 to 200 that are divisible by 5 or 6, but not both
        int count = 0; // Counter for the numbers displayed per line

        // Loop through numbers from 100 to 200 (inclusive)
        for (int number = 100; number <= 200; number++) {
            // Check if the number is divisible by 5 or 6, but not both
            if ((number % 5 == 0 || number % 6 == 0) && !(number % 5 == 0 && number % 6 == 0)) {
                // Display the number with a space separator
                System.out.print(number + " ");
                count++;

                // Move to the next line after displaying 10 numbers
                if (count == 10) {
                    System.out.println(); // Start a new line
                    count = 0; // Reset the counter
                }
            }
        }

        // Display a friendly goodbye message
        System.out.println("\nThank you for using the Divisible Numbers Finder! Have a great day!");
        
        // Close the scanner to prevent potential issues
        scanner.close();
    }
}