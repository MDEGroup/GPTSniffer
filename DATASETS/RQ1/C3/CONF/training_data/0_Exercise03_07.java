import java.util.*;

public class Denomination {
    public static void main(String[] args) {
        // Create a scanner to get input from the user
        Scanner input = new Scanner(System.in);

        // Get the amount from the user
        System.out.print("Enter the amount in dollars and cents: ");
        double amount = input.nextDouble();

        // Convert the amount to cents
        int cents = (int) (amount * 100);

        // Calculate the number of dollars, quarters, dimes, nickels, and pennies
        int dollars = cents / 100;
        cents %= 100;
        int quarters = cents / 25;
        cents %= 25;
        int dimes = cents / 10;
        cents %= 10;
        int nickels = cents / 5;
        cents %= 5;
        int pennies = cents;

        // Display the nonzero denominations in words
        if (dollars == 1) {
            System.out.print("1 dollar");
        } else if (dollars > 1) {
            System.out.printf("%d dollars", dollars);
        }

        if (dollars > 0 && (quarters > 0 || dimes > 0 || nickels > 0 || pennies > 0)) {
            System.out.print(", ");
        }

        if (quarters == 1) {
            System.out.print("1 quarter");
        } else if (quarters > 1) {
            System.out.printf("%d quarters", quarters);
        }

        if (quarters > 0 && (dimes > 0 || nickels > 0 || pennies > 0)) {
            System.out.print(", ");
        }

        if (dimes == 1) {
            System.out.print("1 dime");
        } else if (dimes > 1) {
            System.out.printf("%d dimes", dimes);
        }

        if (dimes > 0 && (nickels > 0 || pennies > 0)) {
            System.out.print(", ");
        }

        if (nickels == 1) {
            System.out.print("1 nickel");
        } else if (nickels > 1) {
            System.out.printf("%d nickels", nickels);
        }

        if (nickels > 0 && pennies > 0) {
            System.out.print(", ");
        }

        if (pennies == 1) {
            System.out.print("1 penny");
        } else if (pennies > 1) {
            System.out.printf("%d pennies", pennies);
        }

        System.out.println();
    }
}