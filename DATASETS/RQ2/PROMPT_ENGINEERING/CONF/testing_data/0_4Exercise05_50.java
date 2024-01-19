import java.util.Scanner;

public class UppercaseCounterProgram {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Uppercase Letter Counter Program!");

        // Get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String userString = scanner.nextLine();

        // Initialize the counter for uppercase letters
        int uppercaseCount = 0;

        // Loop through each character in the string
        for (int i = 0; i < userString.length(); i++) {
            char currentChar = userString.charAt(i);

            // Check if the character is uppercase
            if (Character.isUpperCase(currentChar)) {
                // Increment the uppercase counter
                uppercaseCount = uppercaseCount + 1;
            }
        }

        // Display the result
        System.out.println("\nNumber of uppercase letters in the string: " + uppercaseCount);

        // Close the scanner
        scanner.close();
    }
}