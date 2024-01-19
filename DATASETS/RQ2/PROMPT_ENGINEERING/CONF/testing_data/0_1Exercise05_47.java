import java.util.Scanner;

// Class definition
public class ISBNChecker {

    // Main method
    public static void main(String[] args) {
        // Display a welcoming message
        System.out.println("Welcome to the ISBN-13 Checker Program!");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first 12 digits of an ISBN-13 as a string
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String input = scanner.nextLine();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Check if the input has exactly 12 digits
        if (input.length() == 12) {
            // Calculate the checksum
            int checksum = calculateChecksum(input);

            // Display the ISBN-13 number
            System.out.println("The ISBN-13 number is " + input + checksum);
        } else {
            // Display an error message for invalid input
            System.out.println(input + " is an invalid input. Please enter exactly 12 digits.");
        }

        // Display a friendly goodbye message
        System.out.println("Thank you for using the ISBN-13 Checker Program! Have a nice day!");
    }

    // Function to calculate the checksum for ISBN-13
    private static int calculateChecksum(String input) {
        int sum = 0;

        // Loop through each digit in the input
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            // Apply the formula to calculate the checksum
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += 3 * digit;
            }
        }

        // Calculate the checksum based on the formula
        int checksum = 10 - (sum % 10);

        // If the checksum is 10, replace it with 0
        if (checksum == 10) {
            checksum = 0;
        }

        // Return the calculated checksum
        return checksum;
    }
}