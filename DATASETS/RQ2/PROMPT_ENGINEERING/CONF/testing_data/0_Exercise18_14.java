import java.util.Scanner;

public class UppercaseCounter {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Uppercase Letter Counter!");

        // Get a string from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Calculate and display the number of uppercase letters
        int uppercaseCount = countUppercaseLetters(inputString);
        System.out.println("The number of uppercase letters in the string is: " + uppercaseCount);
    }

    // Recursive method to count uppercase letters in a string
    public static int countUppercaseLetters(String str) {
        // Start with the entire string
        return countUppercaseLettersHelper(str, str.length() - 1);
    }

    // Recursive helper method to count uppercase letters
    public static int countUppercaseLettersHelper(String str, int high) {
        // Base case: if the substring is empty, return 0
        if (high < 0) {
            return 0;
        }

        // Count uppercase letters in the substring and make a recursive call
        int count = Character.isUpperCase(str.charAt(high)) ? 1 : 0;
        return count + countUppercaseLettersHelper(str, high - 1);
    }
}
