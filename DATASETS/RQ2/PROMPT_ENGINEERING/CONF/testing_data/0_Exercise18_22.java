import java.util.Scanner;

public class DecimalToHexConverter {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Decimal to Hex Converter!");

        // Get the decimal number from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        // Convert and display the decimal number in hex
        String hexEquivalent = convertToHex(decimalNumber);
        System.out.println("The hex equivalent of " + decimalNumber + " is: " + hexEquivalent);
    }

    // Recursive method to convert decimal to hex
    public static String convertToHex(int value) {
        // Base case: value is less than 16 (single-digit hex)
        if (value < 16) {
            return Integer.toHexString(value).toUpperCase();
        }

        // Recursive case: convert the quotient and append the remainder
        int quotient = value / 16;
        int remainder = value % 16;

        // Recursive call and concatenation
        return convertToHex(quotient) + Integer.toHexString(remainder).toUpperCase();
    }
}
