import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the monthly saving amount: $");
        double monthlySaving = input.nextDouble();
        
        // Calculate the account value after six months
        double annualInterestRate = 0.05;
        double monthlyInterestRate = annualInterestRate / 12;
        double accountValue = 0;
        for (int i = 1; i <= 6; i++) {
            accountValue = (accountValue + monthlySaving) * (1 + monthlyInterestRate);
        }
        
        // Display the result
        System.out.printf("After six months, the account value will be $%.2f.%n", accountValue);
    }
}