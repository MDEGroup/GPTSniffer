// Importing Scanner for user input
import java.util.Scanner;

// Class definition
public class CompoundValueCalculator {

    // Main method
    public static void main(String[] args) {
        // Display a welcoming message
        System.out.println("Welcome to the Compound Value Calculator!");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the monthly savings amount
        System.out.print("Enter the monthly savings amount (e.g., 100): ");
        double monthlySavings = scanner.nextDouble();

        // Prompt the user to enter the annual interest rate
        System.out.print("Enter the annual interest rate (e.g., 5): ");
        double annualInterestRate = scanner.nextDouble();

        // Prompt the user to enter the number of months
        System.out.print("Enter the number of months (e.g., 6): ");
        int numberOfMonths = scanner.nextInt();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Calculate the monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        // Initialize the total amount in the savings account
        double totalAmount = 0;

        // Loop through each month to calculate the compound value
        for (int i = 0; i < numberOfMonths; i++) {
            // Calculate the compound value after the current month
            totalAmount = (totalAmount + monthlySavings) * (1 + monthlyInterestRate);
        }

        // Display the result
        System.out.println("The amount in the savings account after " + numberOfMonths + " months is: $" + totalAmount);

        // Display a friendly goodbye message
        System.out.println("Thank you for using the Compound Value Calculator! Have a wonderful day!");
    }
}