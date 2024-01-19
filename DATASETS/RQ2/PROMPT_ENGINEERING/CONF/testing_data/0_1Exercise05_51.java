// Importing the Scanner class for user input
import java.util.Scanner;

// Class definition
public class CommonPrefixFinder {

    // Main method
    public static void main(String[] args) {
        // Display a welcoming message
        System.out.println("Welcome to the Common Prefix Finder!");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Find the common prefix
        String commonPrefix = findCommonPrefix(firstString, secondString);

        // Display the result
        if (commonPrefix.length() > 0) {
            System.out.println("The common prefix is " + commonPrefix);
        } else {
            System.out.println(firstString + " and " + secondString + " have no common prefix");
        }

        // Display a friendly goodbye message
        System.out.println("Thank you for using the Common Prefix Finder! Have a great day!");
    }

    // Function to find the common prefix of two strings
    private static String findCommonPrefix(String str1, String str2) {
        StringBuilder commonPrefix = new StringBuilder();
        int minLength = Math.min(str1.length(), str2.length());

        // Loop through each character in the strings
        for (int i = 0; i < minLength; i++) {
            // Check if the characters are the same
            if (str1.charAt(i) == str2.charAt(i)) {
                // Append the character to the common prefix
                commonPrefix.append(str1.charAt(i));
            } else {
                // Break the loop if characters are different
                break;
            }
        }

        // Return the common prefix as a string
        return commonPrefix.toString();
    }
}