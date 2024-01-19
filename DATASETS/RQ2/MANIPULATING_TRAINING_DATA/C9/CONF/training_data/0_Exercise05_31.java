import java.util.Scanner;

public class CDValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the initial amount, annual percentage yield, and number of months
        System.out.print("Enter the initial amount: ");
        double amount = input.nextDouble();
        System.out.print("Enter the annual percentage yield: ");
        double rate = input.nextDouble();
        System.out.print("Enter the number of months: ");
        int months = input.nextInt();

        // Calculate and display the CD's value after each month
        System.out.println("Month\tCD Value");
        for (int i = 1; i <= months; i++) {
            double value = amount * Math.pow(1 + rate / 1200, i);
            System.out.printf("%-5d\t%.2f\n", i, value);
        }
    }
}
