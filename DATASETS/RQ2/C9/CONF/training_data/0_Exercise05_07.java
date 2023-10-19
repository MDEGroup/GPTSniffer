public class TuitionCalculator {
    public static void main(String[] args) {
        double tuition = 10000.0; // Initial tuition is $10,000
        double totalCost = 0.0;

        // Compute the tuition for each of the next ten years
        for (int i = 1; i <= 10; i++) {
            tuition *= 1.05; // Increase tuition by 5%
            if (i > 4) {
                totalCost += tuition; // Add tuition to the total cost for years 5-10
            }
        }

        // Display the tuition in ten years and the total cost of four years' worth of tuition
        System.out.printf("The tuition in ten years is $%.2f\n", tuition);
        System.out.printf("The total cost of four years' worth of tuition after the tenth year is $%.2f\n", totalCost);
    }
}