import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the main string (s1)
        System.out.print("Enter the main string (s1): ");
        String s1 = scanner.nextLine();

        // Prompt the user to enter the substring to search for (s2)
        System.out.print("Enter the substring to search for (s2): ");
        String s2 = scanner.nextLine();

        // Check if s2 is a substring of s1
        int index = findSubstringIndex(s1, s2);

        if (index != -1) {
            System.out.println("The substring s2 is found at index " + index + " in s1.");
        } else {
            System.out.println("The substring s2 is not found in s1.");
        }

        scanner.close();
    }

    // Function to find the index of s2 as a substring in s1
    public static int findSubstringIndex(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        for (int i = 0; i <= s1Length - s2Length; i++) {
            int j;

            // Check if s2 is a substring starting at position i in s1
            for (j = 0; j < s2Length; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }

            // If s2 is found as a substring in s1, return the starting index
            if (j == s2Length) {
                return i;
            }
        }

        // If s2 is not a substring of s1, return -1
        return -1;
    }
}