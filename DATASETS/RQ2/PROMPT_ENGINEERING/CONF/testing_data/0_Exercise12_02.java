import java.util.Scanner;
import java.util.InputMismatchException;

public class SimpleAdditionProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first integer
        System.out.println("Enter the first integer:");

        // Initialize variables to store user input
        int firstNumber = getUserInput(scanner);

        // Prompt the user to enter the second integer
        System.out.println("Enter the second integer:");

        // Initialize variables to store user input
        int secondNumber = getUserInput(scanner);

        // Display the sum of the two integers
        displaySum(firstNumber, secondNumber);

        // Close the scanner to free up resources
        scanner.close();
    }

    private static int getUserInput(Scanner scanner) {
        int number = 0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                // Get user input
                number = scanner.nextInt();
                inputValid = true;
            } catch (InputMismatchException e) {
                // Handle input mismatch exception
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return number;
    }

    private static void displaySum(int num1, int num2) {
        int sum = num1 + num2;

        // Display the sum of the two integers
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    }
}