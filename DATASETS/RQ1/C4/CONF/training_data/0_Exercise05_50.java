import java.util.Scanner;

public class CountUpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int upperCaseCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isUpperCase(inputString.charAt(i))) {
                upperCaseCount++;
            }
        }

        System.out.println("Number of upper-case letters: " + upperCaseCount);
    }
}