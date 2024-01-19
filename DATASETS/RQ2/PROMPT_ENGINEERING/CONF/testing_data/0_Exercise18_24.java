import java.util.Scanner;

public class HexToDecimalConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a hex string: ");
        String hexString = scanner.nextLine();

        // Display decimal equivalent
        int decimalValue = hex2Dec(hexString);
        System.out.println("Decimal equivalent: " + decimalValue);
    }

    public static int hex2Dec(String hexString) {
        return hex2DecHelper(hexString, hexString.length() - 1);
    }

    private static int hex2DecHelper(String hexString, int high) {
        if (high < 0) {
            return 0;
        } else {
            char hexChar = hexString.charAt(hexString.length() - 1 - high);
            int decimalValue = hexCharToDecimal(hexChar);
            return decimalValue * (int) Math.pow(16, high) + hex2DecHelper(hexString, high - 1);
        }
    }

    private static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            return 0; // Handle invalid characters gracefully
        }
    }
}