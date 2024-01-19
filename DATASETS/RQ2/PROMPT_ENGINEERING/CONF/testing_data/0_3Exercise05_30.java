import java.util.Scanner;

// Program to calculate the compound value in a savings account
public class CompoundValueCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the amount, annual interest rate, and number of months
        System.out.print("Enter the monthly savings amount (e.g., 100): ");
        double monthlySavings = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (e.g., 5): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the number of months (e.g., 6): ");
        int numberOfMonths = scanner.nextInt();

        // Calculate the monthly interest rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        // Initialize the total amount
        double totalAmount = 0;

        // Loop through each month to calculate the compound value
        for (int i = 1; i <= numberOfMonths; i++) {
            totalAmount = (totalAmount + monthlySavings) * (1 + monthlyInterestRate);
        }

        // Display the result
        System.out.println("The amount in the savings account after " + numberOfMonths + " months is: $" + totalAmount);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}