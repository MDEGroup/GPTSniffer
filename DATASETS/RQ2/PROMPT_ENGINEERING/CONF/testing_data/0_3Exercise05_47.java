import java.util.Scanner;

// Program to check ISBN-13 validity and calculate the checksum
public class ISBNChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first 12 digits of an ISBN-13 as a string
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String input = scanner.nextLine();

        // Check if the input has exactly 12 digits
        if (input.length() != 12) {
            System.out.println(input + " is an invalid input");
        } else {
            // Calculate the checksum
            int checksum = calculateChecksum(input);

            // Display the complete ISBN-13 number
            System.out.println("The ISBN-13 number is " + input + checksum);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to calculate the ISBN-13 checksum
    private static int calculateChecksum(String input) {
        int sum = 0;

        // Loop through each digit of the input string
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            // Apply the formula for calculating the checksum
            sum += (i % 2 == 0) ? digit : 3 * digit;
        }

        // Calculate the checksum value
        int checksum = 10 - (sum % 10);

        // If the checksum is 10, replace it with 0
        return (checksum == 10) ? 0 : checksum;
    }
}