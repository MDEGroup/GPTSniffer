import java.util.Scanner;

public class BinaryToDecimalConverter {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Binary to Decimal Converter!");

        // Get the binary string from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binaryString = scanner.nextLine();

        // Convert binary to decimal
        int decimalValue = bin2Dec(binaryString);

        // Display the result
        System.out.println("The decimal equivalent of " + binaryString + " is: " + decimalValue);
    }

    // Recursive method to convert binary to decimal
    public static int bin2Dec(String binaryString) {
        // Base case: if the binary string is empty, return 0
        if (binaryString.isEmpty()) {
            return 0;
        }

        // Get the last character of the binary string
        char lastChar = binaryString.charAt(binaryString.length() - 1);

        // Convert the last character to an integer
        int lastDigit = Character.getNumericValue(lastChar);

        // Recursive call to process the rest of the binary string
        int restDecimalValue = bin2Dec(binaryString.substring(0, binaryString.length() - 1));

        // Calculate the decimal value
        return (lastDigit * (int) Math.pow(2, binaryString.length() - 1)) + restDecimalValue;
    }
}
