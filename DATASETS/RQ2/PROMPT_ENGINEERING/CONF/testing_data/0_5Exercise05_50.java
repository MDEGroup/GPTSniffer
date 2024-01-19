import java.util.Scanner;

public class UppercaseLetterCounterProgramByHarryDulaney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.println("Please enter a string: ");
        String userString = scanner.nextLine();

        // Initialize variable to count uppercase letters
        int uppercaseLetterCount = 0;

        // Loop through each character in the string
        for (int i = 0; i < userString.length(); i++) {
            // Check if the character is an uppercase letter
            if (Character.isUpperCase(userString.charAt(i))) {
                // Increment the count if it is an uppercase letter
                uppercaseLetterCount++;
            }
        }

        // Display the result
        System.out.println("The number of uppercase letters in the string is: " + uppercaseLetterCount);

        // Close the scanner
        scanner.close();
    }
}