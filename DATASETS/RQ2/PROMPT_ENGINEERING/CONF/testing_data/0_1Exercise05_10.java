import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string: ");
        String firstString = input.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the second string: ");
        String secondString = input.nextLine();

        // Call the method to find the longest common prefix
        String commonPrefix = findCommonPrefix(firstString, secondString);

        // Display the result
        if (commonPrefix.length() > 0) {
            System.out.println("The common prefix is " + commonPrefix);
        } else {
            System.out.println(firstString + " and " + secondString + " have no common prefix");
        }

        // Close the scanner
        input.close();
    }

    // Method to find the longest common prefix
    public static String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        String prefix = "";

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                prefix += str1.charAt(i);
            } else {
                break;
            }
        }

        return prefix;
    }
}