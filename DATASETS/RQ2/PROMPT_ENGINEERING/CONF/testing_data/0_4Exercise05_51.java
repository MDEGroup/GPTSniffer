import java.util.Scanner;

// Longest common prefix program

public class CommonPrefixFinder {

    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the first string
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        // Prompt user for the second string
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        // Initialize variables to store the common prefix
        String commonPrefix = "";
        int minLength = Math.min(firstString.length(), secondString.length());

        // Loop through characters in the strings to find the common prefix
        for (int i = 0; i < minLength; i++) {
            if (firstString.charAt(i) == secondString.charAt(i)) {
                commonPrefix = commonPrefix + firstString.charAt(i);
            } else {
                // Break the loop if a mismatch is found
                break;
            }
        }

        // Display the common prefix or a message if there is none
        if (commonPrefix.length() > 0) {
            System.out.println("The common prefix is " + commonPrefix);
        } else {
            System.out.println(firstString + " and " + secondString + " have no common prefix");
        }

        // Close the Scanner
        scanner.close();
    }
}