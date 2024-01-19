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
        } catch (NumberFormatException e) {
            // Handle NumberFormatException
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    // Method to convert hex string to decimal
    private static int hex2Dec(String hexString) {
        // Check if the hex string is not valid
        if (!isValidHexString(hexString)) {
            throw new NumberFormatException("Invalid hex string format");
        }

        // Convert hex string to decimal
        return Integer.parseInt(hexString, 16);
    }

    // Method to check if the hex string is valid
    private static boolean isValidHexString(String hexString) {
        try {
            // Attempt to parse the hex string
            Integer.parseInt(hexString, 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}