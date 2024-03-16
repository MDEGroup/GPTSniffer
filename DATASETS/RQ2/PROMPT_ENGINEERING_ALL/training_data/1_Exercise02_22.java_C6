

import java.util.Scanner;


public class ConvertDoubleToInt{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(
                "Enter dollar amount as an integer whose last two digits represent the cents, for example 1156 for $11.56: ");
        int amount = input.nextInt();

        int quarters = 0, dimes = 0, nickles = 0, pennies = 0;

        int cents = amount % 100;
        int dollars = amount / 100;
        quarters = cents / 25;
        cents %= 25;

        dimes = cents / 10;
        cents %= 10;
        nickles = cents / 5;
        cents %= 5;
        pennies = cents / 1;
        cents %= 1;

        System.out.println("Your integer amount " + amount + " consists of " + "\n" + dollars + " dollars" + "\n"
                + quarters + " quarters " + "\n" + dimes + " dimes" + "\n" + nickles + " nickels" + "\n" + pennies
                + " pennies");

        input.close();
    }
}
