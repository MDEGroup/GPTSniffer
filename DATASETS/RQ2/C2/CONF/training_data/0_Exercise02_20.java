import java.util.Scanner;public class NextMonthInterest {  public static void main(String[] args) {    Scanner scanner = new Scanner(System.in);    // Get input from user    System.out.print("Enter the balance: ");    double balance = scanner.nextDouble();    System.out.print("Enter the annual interest rate: ");    double annualInterestRate = scanner.nextDouble();    // Calculate interest for next month    double monthlyInterestRate = annualInterestRate / 1200.0;    double interest = balance * monthlyInterestRate;    // Output result    System.out.printf("The interest for the next month is $%.2f", interest);  }}