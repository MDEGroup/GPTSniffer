import java.util.Scanner;

public class ISBN13Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ISBN-13 Checker!");

        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String input = scanner.nextLine();

        if (input.length() != 12) {
            System.out.println(input + " is an invalid input");
        } else {
            int checksum = calculateChecksum(input);

            String isbn13 = input + checksum;

            System.out.println("The ISBN-13 number is " + isbn13);
        }

        scanner.close();
    }

    private static int calculateChecksum(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += 3 * digit;
            }
        }

        int checksum = 10 - (sum % 10);
        if (checksum == 10) {
            checksum = 0;
        }

        return checksum;
    }
}