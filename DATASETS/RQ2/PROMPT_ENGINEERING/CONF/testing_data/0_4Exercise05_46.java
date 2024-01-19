import java.util.Scanner;

public class StringReversalProgram {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the String Reversal Program!");

        // Get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String userString = scanner.nextLine();

        // Convert the string to a character array
        char[] charArray = userString.toCharArray();

        // Initialize an empty string for the reversed result
        String reversedString = "";

        // Loop through the character array in reverse order
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Concatenate each character to the reversed result
            reversedString = reversedString + charArray[i];
        }

        // Display the reversed string
        System.out.println("\nReversed string: " + reversedString);

        // Close the scanner
        scanner.close();
    }
}