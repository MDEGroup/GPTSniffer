import java.util.Scanner;

public class CompoundValueCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Compound Value Calculator!");

        System.out.print("Enter the monthly saving amount (e.g., 100): ");
        double monthlySavingAmount = input.nextDouble();

        System.out.print("Enter the annual interest rate (e.g., 5): ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter the number of months (e.g., 6): ");
        int numberOfMonths = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 1200; // Calculating monthly interest rate

        double futureValue = 0; // Initializing future value to 0

        for (int i = 1; i <= numberOfMonths; i++) {
            futureValue = (monthlySavingAmount + futureValue) * (1 + monthlyInterestRate);
        }

        System.out.println("The amount in the savings account after " + numberOfMonths + " months is: $" + futureValue);

        input.close();
    }
}