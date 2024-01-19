import java.util.Scanner; // Importing the Scanner class for user input

// Class definition
public class StringReverser {

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display a welcoming message
        System.out.println("Welcome to the String Reverser Program!");

        // Prompt the user to enter a string
        System.out.print("Please enter a string: ");
        
        // Read the user's string input
        String userString = scanner.nextLine();

        // Close the scanner to prevent potential issues
        scanner.close();

        // Reverse the string
        String reversedString = reverseString(userString);

        // Display the result
        System.out.println("The reversed string is: " + reversedString);

        // Display a friendly goodbye message
        System.out.println("Thank you for using the String Reverser Program! Have a wonderful day!");
    }

    // Function to reverse a string
    private static String reverseString(String inputString) {
        // Convert the string to a character array
        char[] charArray = inputString.toCharArray();

        // Initialize a StringBuilder to store the reversed string
        StringBuilder reversedStringBuilder = new StringBuilder();

        // Loop through the character array in reverse order
        for (int i = charArray.length - 1; i >= 0; i--) {
            // Append each character to the StringBuilder
            reversedStringBuilder.append(charArray[i]);
        }

        // Convert the StringBuilder back to a string and return it
        return reversedStringBuilder.toString();
    }
}