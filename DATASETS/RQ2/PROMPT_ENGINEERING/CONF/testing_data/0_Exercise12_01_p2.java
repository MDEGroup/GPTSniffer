import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter two numbers
        System.out.print("Enter the first number: ");
        double num1 = getDoubleInput(scanner);

        System.out.print("Enter the second number: ");
        double num2 = getDoubleInput(scanner);

        // Calculate and display the result with exception handling
        try {
            double result = divideWithException(num1, num2);
            System.out.println("Result with exception handling: " + result);
        } catch (Exception e) {
            System.out.println("Error with exception handling: " + e.getMessage());
        }

        // Calculate and display the result without exception handling
        double resultWithoutException = divideWithoutException(num1, num2);
        System.out.println("Result without exception handling: " + resultWithoutException);

        // Close the scanner
        scanner.close();
    }

    // Method to get a valid double input from the user
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    // Method to perform division with exception handling
    private static double divideWithException(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    // Method to perform division without exception handling
    private static double divideWithoutException(double num1, double num2) {
        // Check for division by zero before performing the division
        if (num2 == 0) {
            System.out.println("Error without exception handling: Cannot divide by zero");
            System.exit(0);
        }
        return num1 / num2;
    }
}
