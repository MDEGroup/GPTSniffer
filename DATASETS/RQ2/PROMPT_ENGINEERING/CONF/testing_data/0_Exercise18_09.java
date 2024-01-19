import java.util.Scanner;

public class ReverseDisplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Display reversal
        reverseDisplay(input);
    }

    public static void reverseDisplay(String value) {
        reverseDisplayHelper(value, value.length() - 1);
    }

    private static void reverseDisplayHelper(String value, int index) {
        if (index >= 0) {
            // Display the character at the current index
            System.out.print(value.charAt(index));

            // Recursively invoke with the decreased index
            reverseDisplayHelper(value, index - 1);
        }
    }
}