

import java.util.*;


public class Exercise03_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter the exchange rate from dollars to RMB: ");
        double rate = in.nextDouble();

        System.out.print("\nEnter 0 to convert dollars to RMB and 1 vice versa: ");
        int choice = in.nextInt();

        double amt = 0;

        if (choice == 1) {
            System.out.print("\nEnter the RMB amount: ");
        } else {
            System.out.println("\nEnter the dollar amount: ");
        }

        amt = in.nextDouble();

        if (choice == 1) {
            double yuan = amt * rate;
            System.out.println("$" + amt + " dollars is " + yuan + " yuan");

        } else {
            double dollars = amt / rate;
            System.out.printf("%.2f yuan is %.2f dollars", amt, dollars);

        }


    }
}