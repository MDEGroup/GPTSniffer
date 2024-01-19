import java.util.Scanner;

public class HexConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a hex string
        System.out.print("Enter a hex string: ");
        String hexString = scanner.nextLine();

        try {
            // Convert hex string to decimal
            int decimalValue = hex2Dec(hexString);
            System.out.println("Decimal value: " + decimalValue);
        } catch (HexFormatException e) {
            // Handle custom HexFormatException
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    // Method to convert hex string to decimal
    private static int hex2Dec(String hexString) throws HexFormatException {
        int decimalValue = 0;

        // Validate hex string
        if (!isValidHexString(hexString)) {
            throw new HexFormatException("Invalid hex string format");
        }

        // Convert hex string to decimal
        for (int i = hexString.length() - 1, power = 0; i >= 0; i--, power++) {
            char hexChar = hexString.charAt(i);
            int hexDigit = hexCharToDecimal(hexChar);
            decimalValue += hexDigit * Math.pow(16, power);
        }

        return decimalValue;
    }

    // Method to check if the hex string is valid
    private static boolean isValidHexString(String hexString) {
        // Check for null or empty string
        if (hexString == null || hexString.isEmpty()) {
            return false;
        }

        // Check for valid hex characters
        for (char hexChar : hexString.toCharArray()) {
            if (!Character.isDigit(hexChar) && (hexChar < 'A' || hexChar > 'F') && (hexChar < 'a' || hexChar > 'f')) {
                return false;
            }
        }

        return true;
    }

    // Method to convert hex character to decimal
    private static int hexCharToDecimal(char hexChar) {
        if (Character.isDigit(hexChar)) {
            return hexChar - '0';
        } else {
            return Character.toUpperCase(hexChar) - 'A' + 10;
        }
    }

    // Custom HexFormatException class
    static class HexFormatException extends Exception {
        public HexFormatException(String message) {
            super(message);
        }
    }
}
