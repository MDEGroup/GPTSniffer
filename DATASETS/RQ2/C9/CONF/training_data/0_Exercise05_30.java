import java.util.Scanner;

public class SavingsAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the initial amount: $");
        double amount = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualRate = scanner.nextDouble();
        System.out.print("Enter the number of months: ");
        int months = scanner.nextInt();
        
        // Compute monthly interest rate
        double monthlyRate = annualRate / 1200.0;  // 12 months in a year, 100 to convert percentage to decimal
        
        // Compute balance after specified number of months
        for (int i = 1; i <= months; i++) {
            amount = amount + (100 * monthlyRate) + 100;  // add monthly deposit and interest
        }
        
        // Output balance
        System.out.printf("The balance after %d months is: $%.2f", months, amount);
    }
}