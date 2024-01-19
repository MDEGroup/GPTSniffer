import java.util.Scanner;

public class CommonPrefixFinderByHarryDulaney {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Common Prefix Finder!");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        // Find the common prefix
        String commonPrefix = findCommonPrefix(firstString, secondString);

        // Display the result
        if (commonPrefix.length() > 0) {
            System.out.println("The common prefix is " + commonPrefix);
        } else {
            System.out.println(firstString + " and " + secondString + " have no common prefix");
        }

        // Close the Scanner
        scanner.close();
    }

    // Function to find the common prefix of two strings
    private static String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonPrefix.append(str1.charAt(i));
            } else {
                break;
            }
        }

        return commonPrefix.toString();
    }
}