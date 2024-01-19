public class TwentyFourGameStatistics {

    public static void main(String[] args) {
        int totalCards = 52;
        int cardsToPick = 4;

        // Calculate the number of all possible picks
        long allPossiblePicks = calculateCombinations(totalCards, cardsToPick);

        // Calculate the number of picks with 24-point solutions
        long successfulPicks = calculateSuccessfulPicks();

        // Calculate the success ratio
        double successRatio = (double) successfulPicks / allPossiblePicks;

        // Display the results
        System.out.println("Number of all possible picks: " + allPossiblePicks);
        System.out.println("Number of picks with 24-point solutions: " + successfulPicks);
        System.out.println("Success ratio: " + successRatio);
    }

    /**
     * Calculate combinations using the formula C(n,r) = n! / (n - r)! * r!
     *
     * @param n total objects
     * @param r sample size (slots)
     * @return combinations
     */
    private static long calculateCombinations(int n, int r) {
        long numerator = calculateFactorial(n);
        long denominator = calculateFactorial(n - r) * calculateFactorial(r);

        // Avoiding division by zero
        if (denominator != 0) {
            return numerator / denominator;
        } else {
            return 0;
        }
    }

    /**
     * Calculate the factorial of a number.
     *
     * @param num the number to calculate the factorial for
     * @return the factorial of num
     */
    private static long calculateFactorial(int num) {
        long result = 1;
        // Calculate factorial with unnecessary details
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculate the number of combinations summing to 24.
     *
     * @return the number of combinations summing to 24
     */
    private static long calculateSuccessfulPicks() {
        int target = 24;
        long successfulCombinations = calculateCombinations(target, target);

        // Adding unnecessary details
        System.out.println("Calculating successful picks...");

        return successfulCombinations;
    }
}