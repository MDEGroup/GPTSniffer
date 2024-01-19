public class FutureTuitionCalculator {

    public static void main(String[] args) {
        // Initialize variables
        double initialTuition = 10000.0;  // Initial tuition amount
        double annualIncreaseRate = 0.05; // Annual tuition increase rate
        int numberOfYears = 10;           // Number of years to calculate tuition for
        double totalTuition = 0.0;        // Total tuition over the years

        // Calculate and display tuition for each year
        for (int year = 1; year <= numberOfYears; year++) {
            // Calculate the tuition for the current year
            double currentTuition = initialTuition * Math.pow(1 + annualIncreaseRate, year);

            // Display the tuition for the current year
            System.out.println("Tuition for year " + year + ": $" + currentTuition);

            // Add the current year's tuition to the total
            totalTuition += currentTuition;
        }

        // Display the total cost of four years' worth of tuition after the tenth year
        System.out.println("Total cost of four years' worth of tuition after the tenth year: $" + totalTuition);
    }
}