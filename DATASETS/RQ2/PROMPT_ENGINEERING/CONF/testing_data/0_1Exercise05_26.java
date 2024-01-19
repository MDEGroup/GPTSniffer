// Class definition
public class ApproximateE {

    // Main method
    public static void main(String[] args) {
        // Display a welcoming message
        System.out.println("Welcome to the e Approximator Program!");

        // Initialize the variables e and item to 1
        double e = 1.0;
        double item = 1.0;

        // Loop through values of i from 10000 to 100000 in steps of 10000
        for (int i = 10000; i <= 100000; i += 10000) {
            // Display the current iteration
            System.out.println("For i = " + i + ":");

            // Loop to calculate the approximation using the given series
            for (int j = 1; j <= i; j++) {
                item = item / j; // Calculate the new item

                // Add the new item to e
                e += item;
            }

            // Display the result for the current iteration
            System.out.println("Approximated e: " + e);

            // Reset the variables for the next iteration
            e = 1.0;
            item = 1.0;
        }

        // Display a friendly goodbye message
        System.out.println("Thank you for using the e Approximator Program! Have a fantastic day!");
    }
}