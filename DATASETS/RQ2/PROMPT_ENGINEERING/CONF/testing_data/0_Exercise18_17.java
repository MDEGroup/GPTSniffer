/**
 * Welcome to the CharacterArrayCounter program!
 * This program counts the occurrences of a specified character in an array.
 * Author: [Your Name]
 */

import java.util.Scanner;

public class CharacterArrayCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a list of characters separated by spaces: ");
        String inputString = scanner.nextLine();
        char[] charArray = inputString.toCharArray();

        System.out.print("Enter a character to count: ");
        char targetChar = scanner.next().charAt(0);

        // Display the result
        int count = countOccurrences(charArray, targetChar);
        System.out.println("Occurrences of '" + targetChar + "' in the array: " + count);
    }

    // Method to count occurrences of a specified character in an array
    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    // Recursive helper method
    private static int count(char[] chars, char ch, int high) {
        if (high < 0) {
            return 0; // Base case: reached the beginning of the array
        } else {
            int currentCount = (chars[high] == ch) ? 1 : 0;
            return currentCount + count(chars, ch, high - 1);
        }
    }
}
