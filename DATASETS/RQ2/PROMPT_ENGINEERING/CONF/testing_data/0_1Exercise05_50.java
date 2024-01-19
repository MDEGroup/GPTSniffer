import java.util.Scanner;

// Class definition
public class UppercaseCounterProgram {

    // Main method
    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display a welcoming message
        System.out.println("Welcome to the Uppercase Letter Counter Program!");

        // Prompt the user to enter a string
        System.out.print("Please enter a string: ");
        
        // Read the user input as a string
        String userString = scanner.nextLine();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Count the number of uppercase letters in the string
        int uppercaseCount = countUppercaseLetters(userString);

        // Display the result
        System.out.println("The number of uppercase letters in the entered string is: " + uppercaseCount);

        // Display a friendly goodbye message
        System.out.println("Thank you for using the Uppercase Letter Counter Program! Have a great day!");
    }

    // Function to count uppercase letters in a string
    private static int countUppercaseLetters(String inputString) {
        int count = 0;

        // Loop through each character in the string
        for (int i = 0; i < inputString.length(); i++) {
            // Check if the character is an uppercase letter
            if (Character.isUpperCase(inputString.charAt(i))) {
                count++;
            }
        }

        // Return the count of uppercase letters
        return count;
    }
}