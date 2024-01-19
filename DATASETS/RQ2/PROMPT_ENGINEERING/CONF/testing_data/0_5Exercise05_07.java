public class TuitionCalculator {

    public static void main(String[] args) {
        // Declare and initialize variables
        double currentTuition = 10000.0;
        double annualIncreaseRate = 0.05;
        int numberOfYears = 10;

        // Calculate tuition for each year
        for (int year = 1; year <= numberOfYears; year++) {
            currentTuition = currentTuition + (currentTuition * annualIncreaseRate);
        }

        // Display tuition after ten years
        System.out.println("Tuition in " + numberOfYears + " years: $" + currentTuition);

        // Calculate and display total cost for four years
        double totalCost = 0;
        for (int i = 1; i <= 4; i++) {
            totalCost = totalCost + currentTuition;
            currentTuition = currentTuition + (currentTuition * annualIncreaseRate);
        }

        System.out.println("Total cost of four years' worth of tuition after " + numberOfYears + " years: $" + totalCost);
    }
}