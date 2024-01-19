import java.util.Scanner;

public class TuitionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double initialTuition = 10000; // Initial tuition amount
        double tuitionIncreaseRate = 0.05; // Tuition increase rate

        System.out.println("Calculating future tuition...");

        // Calculate tuition for ten years
        double futureTuition = initialTuition;
        for (int year = 1; year <= 10; year++) {
            futureTuition = futureTuition + (futureTuition * tuitionIncreaseRate);
        }

        System.out.println("The tuition in ten years will be: $" + futureTuition);

        // Calculate total cost of four years' worth of tuition after the tenth year
        double totalCost = 0;
        for (int i = 1; i <= 4; i++) {
            totalCost = totalCost + (futureTuition * i);
        }

        System.out.println("The total cost of four years' worth of tuition after the tenth year will be: $" + totalCost);

        input.close();
    }
}