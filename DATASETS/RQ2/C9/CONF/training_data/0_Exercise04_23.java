import java.util.Scanner;

public class PayrollStatement {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      // Prompt user to input employee information
      System.out.print("Enter employee's name: ");
      String name = input.nextLine();

      System.out.print("Enter number of hours worked in a week: ");
      double hoursWorked = input.nextDouble();

      System.out.print("Enter hourly pay rate: ");
      double hourlyPayRate = input.nextDouble();

      System.out.print("Enter federal tax withholding rate (%): ");
      double federalTaxRate = input.nextDouble();

      System.out.print("Enter state tax withholding rate (%): ");
      double stateTaxRate = input.nextDouble();

      // Calculate gross pay, federal withholding, state withholding, and net pay
      double grossPay = hoursWorked * hourlyPayRate;
      double federalWithholding = grossPay * (federalTaxRate / 100);
      double stateWithholding = grossPay * (stateTaxRate / 100);
      double totalDeduction = federalWithholding + stateWithholding;
      double netPay = grossPay - totalDeduction;

      // Print payroll statement
      System.out.println("Employee Name: " + name);
      System.out.println("Hours Worked: " + hoursWorked);
      System.out.println("Pay Rate: $" + hourlyPayRate);
      System.out.println("Gross Pay: $" + grossPay);
      System.out.println("Deductions:");
      System.out.printf("\tFederal Withholding (%.1f%%): $%.2f\n", federalTaxRate, federalWithholding);
      System.out.printf("\tState Withholding (%.1f%%): $%.2f\n", stateTaxRate, stateWithholding);
      System.out.printf("\tTotal Deduction: $%.2f\n", totalDeduction);
      System.out.println("Net Pay: $" + netPay);
   }
}