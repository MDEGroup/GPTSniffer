import java.util.Scanner;

public class CharacterCounter {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Character Occurrence Counter!");

        // Get a string and character from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter a character to count: ");
        char targetChar = scanner.next().charAt(0);

        // Calculate and display the character occurrence
        int occurrenceResult = countCharacter(inputString, targetChar);
        System.out.println("The character '" + targetChar + "' occurs " + occurrenceResult + " times in the string.");
    }

    // Helper method to count occurrences of a character in a string
    public static int countCharacter(String str, char a) {
        // Start with the entire string
        return countCharacterHelper(str, a, str.length() - 1);
    }

    // Recursive helper method to count occurrences of a character
    public static int countCharacterHelper(String str, char a, int high) {
        // Base case: if the substring is empty, return 0
        if (high < 0) {
            return 0;
        }

        // Count occurrences in the substring and make a recursive call
        int count = (str.charAt(high) == a) ? 1 : 0;
        return count + countCharacterHelper(str, a, high - 1);
    }
}