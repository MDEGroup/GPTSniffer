import java.util.Scanner;

public class FutureInvestmentValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the investment amount: $");
        double investmentAmount = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int numberOfYears = scanner.nextInt();
        
        // Calculate future investment value
        double monthlyInterestRate = annualInterestRate / 1200.0; // 12 months in a year, 100 to convert percentage to decimal
        double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);
        
        // Output result
        System.out.printf("The future investment value is: $%.2f", futureInvestmentValue);
    }
}