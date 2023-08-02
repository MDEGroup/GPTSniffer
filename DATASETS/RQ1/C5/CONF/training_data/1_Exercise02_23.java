

import java.util.Scanner;


public class DrivingCost{
    public static void main(String[] args) {

        double distance;
        double milesPerGallon;
        double pricePerGallon;

        System.out.println("Enter the driving distance in miles:");

        Scanner input = new Scanner(System.in);
        distance = input.nextDouble();

        System.out.println("Enter the miles per gallon:");

        milesPerGallon = input.nextDouble();

        System.out.println("Enter the price of gas per gallon:");

        pricePerGallon = input.nextDouble();

        double tripCost = (distance / milesPerGallon) * pricePerGallon;

        System.out.print("\nThe cost of driving for this trip is: $");
        System.out.printf("%.2f", tripCost);

        input.close();
    }

}
