public class EApproximator {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the E Approximator!");

        // Declare and initialize variables
        double e = 1.0;
        double item = 1.0;
        int iterations = 100000;

        // Calculate e for each iteration
        for (int i = 2; i <= iterations; i++) {
            item /= i;
            e += item;
        }

        // Display the result
        System.out.println("The approximate value of e for " + iterations + " iterations is: " + e);
    }
}