import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string (s1): ");
        String s1 = scanner.nextLine();

        System.out.print("Enter the second string (s2): ");
        String s2 = scanner.nextLine();

        int s1Length = s1.length();
        int s2Length = s2.length();

        boolean found = false;

        for (int i = 0; i <= s1Length - s2Length; i++) {
            int j;

            for (j = 0; j < s2Length; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }

            if (j == s2Length) {
                System.out.println("Matched at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No match found.");
        }

        scanner.close();
    }
}