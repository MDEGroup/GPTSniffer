import java.util.Scanner; // Import Scanner for reading user input

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // Use Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the first string
        System.out.print("Enter the first string: ");
        String string1 = scanner.nextLine(); // Read first string

        // Prompt user for the second string
        System.out.print("Enter the second string: ");
        String string2 = scanner.nextLine(); // Read second string

        // Find the longest common prefix
        String commonPrefix = findLongestCommonPrefix(string1, string2);

        // Check if common prefix exists and display the result
        if (commonPrefix.equals("")) {
            System.out.println(string1 + " and " + string2 + " have no common prefix");
        } else {
            System.out.println("The common prefix is " + commonPrefix);
        }

        scanner.close(); // Close the scanner
    }

    // Method to find the longest common prefix
    private static String findLongestCommonPrefix(String str1, String str2) {
        String result = ""; // Initialize result string
        int length = Math.min(str1.length(), str2.length()); // Find the shorter length

        // Iterate over the characters to find the common prefix
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break; // Break loop if characters don't match
            }
            result += str1.charAt(i); // Concatenate matching character to result
        }

        return result; // Return the common prefix
    }
}
