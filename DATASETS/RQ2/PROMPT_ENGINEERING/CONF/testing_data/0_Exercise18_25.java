import java.util.Scanner;

public class StringPermutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Display permutations
        displayPermutation(input);
    }

    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) {
        if (s2.isEmpty()) {
            System.out.println(s1);  // Base case: print the permutation
        } else {
            for (int i = 0; i < s2.length(); i++) {
                // Move a character from s2 to s1
                char selectedChar = s2.charAt(i);
                String newS1 = s1 + selectedChar;
                String newS2 = s2.substring(0, i) + s2.substring(i + 1);

                // Recursively invoke with the new strings
                displayPermutation(newS1, newS2);
            }
        }
    }
}