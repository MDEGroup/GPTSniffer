import java.util.Scanner;

public class StringProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        processAndDisplayString(inputString);

        System.out.println("\nBy: Harry Dulaney");
    }

    public static void processAndDisplayString(String inputString) {
        System.out.print("Processed string: ");

        for (int i = 0; i < inputString.length(); i++) {
            // Display characters at odd positions (1-based index)
            if (i % 2 == 0) {
                System.out.print(inputString.charAt(i));
            }
        }
    }
}