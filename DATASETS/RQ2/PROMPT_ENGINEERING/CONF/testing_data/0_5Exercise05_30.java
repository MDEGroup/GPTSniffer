import java.util.Scanner;

public class CompoundValueCalculator {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Compound Value Calculator!");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the amount, annual interest rate, and number of months
        System.out.print("Enter the amount to save each month (e.g., 100): ");
        double monthlyAmount = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (e.g., 5): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the number of months (e.g., 6): ");
        int numberOfMonths = scanner.nextInt();

        // Calculate the monthly interest rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        // Calculate the amount in the savings account after the given number of months
        double totalAmount = 0;
        for (int i = 1; i <= numberOfMonths; i++) {
            totalAmount = (totalAmount + monthlyAmount) * (1 + monthlyInterestRate);
        }

        // Display the result
        System.out.println("The amount in the savings account after " + numberOfMonths + " months is: $" + totalAmount);

        // Close the Scanner
        scanner.close();
    }
}