import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a binary string
        System.out.print("Enter a binary string: ");
        String binaryString = scanner.nextLine();

        try {
            // Convert binary string to decimal
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal value: " + decimalValue);
        } catch (BinaryFormatException e) {
            // Handle BinaryFormatException
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    // Method to convert binary string to decimal with exception handling
    private static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the binary string is not valid
        if (!isValidBinaryString(binaryString)) {
            throw new BinaryFormatException("Invalid binary string format");
        }

        // Convert binary string to decimal
        return Integer.parseInt(binaryString, 2);
    }

    // Method to check if the binary string is valid
    private static boolean isValidBinaryString(String binaryString) {
        for (char digit : binaryString.toCharArray()) {
            // Check if each character is '0' or '1'
            if (digit != '0' && digit != '1') {
                return false;
            }
        }
        return true;
    }

    // Custom exception class for binary format
    static class BinaryFormatException extends Exception {
        public BinaryFormatException(String message) {
            super(message);
        }
    }
}
