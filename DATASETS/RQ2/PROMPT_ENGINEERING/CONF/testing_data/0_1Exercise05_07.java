import java.util.Scanner;

public class TuitionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final double INITIAL_TUITION = 10000.0; // Initial tuition for the first year
        final double ANNUAL_INCREASE_PERCENTAGE = 5.0; // Annual increase percentage

        // User prompt
        System.out.println("Welcome to Tuition Calculator!");
        System.out.println("Let's predict the future tuition costs...");

        // Calculate tuition for ten years
        double tuition = INITIAL_TUITION;
        for (int year = 1; year <= 10; year++) {
            tuition = tuition + (tuition * ANNUAL_INCREASE_PERCENTAGE / 100);
        }

        // Display the tuition after ten years
        System.out.println("The tuition after ten years will be: $" + tuition);

        // Calculate the total cost of four years' worth of tuition after the tenth year
        double totalCost = 0;
        for (int i = 1; i <= 4; i++) {
            tuition = tuition + (tuition * ANNUAL_INCREASE_PERCENTAGE / 100);
            totalCost = totalCost + tuition;
        }

        // Display the total cost after the tenth year
        System.out.println("The total cost of four years' worth of tuition after the tenth year will be: $" + totalCost);

        // Close the scanner
        input.close();
    }
}