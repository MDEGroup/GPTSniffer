package ch_04;

import java.util.*;


public class Exercise04_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter employee's name:");
        String name = in.next();

        System.out.print("Enter number of hours worked in a week:");
        double hours = in.nextInt();

        System.out.print("Enter hourly pay rate:");
        double payRate = in.nextDouble();

        System.out.print("Enter federal tax withholding rate:");
        double federalTaxRate = in.nextDouble();

        System.out.print("Enter state tax withholding rate:");
        double stateTaxRate = in.nextDouble();

        double grossPay = hours * payRate;
        double federalTax = grossPay * federalTaxRate;
        double stateTax = grossPay * stateTaxRate;
        double totalTax = federalTax + stateTax;
        double netPay = grossPay - totalTax;

        System.out.print("\nEmployee Name: " + name);
        System.out.printf("\nHours Worked: %.1f", hours);
        System.out.print("\nPay Rate: $" + payRate);
        System.out.printf("\nGross Pay: $%.2f", grossPay);
        System.out.print("\nDeductions: ");

        System.out.printf("\nFederal Withholding: $%.2f", federalTax);
        System.out.printf("\nState Withholding: $%.2f", stateTax);
        System.out.printf("\nTotal Deductions: $%.2f", totalTax);
        System.out.printf("\n\nNet Pay: $%.2f", netPay);
        in.close();
    }
}