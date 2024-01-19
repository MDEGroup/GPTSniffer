public class ApproximateEProgram {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Approximate e Calculator Program!");

        // Calculate and display the approximate e for various values of i
        for (int i = 10000; i <= 100000; i += 10000) {
            // Initialize e and item to be 1
            double e = 1;
            double item = 1;

            // Calculate the approximate e
            for (int j = 1; j <= i; j++) {
                // Update item
                item /= j;

                // Add the new item to e
                e += item;
            }

            // Display the result
            System.out.println("Approximate e for i = " + i + ": " + e);
        }

        // Display a closing message
        System.out.println("\nThank you for using the Approximate e Calculator Program!");
    }
}