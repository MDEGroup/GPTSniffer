public class DivisibleNumbersProgram {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Divisible Numbers Program!");

        // Initialize a counter for tracking numbers per line
        int numbersPerLine = 0;

        // Loop through numbers from 100 to 1000
        for (int i = 100; i <= 1000; i++) {
            // Check if the number is divisible by 5 and 6
            if (i % 5 == 0 && i % 6 == 0) {
                // Display the number
                System.out.print(i + " ");

                // Increment the counter
                numbersPerLine++;

                // Check if ten numbers have been displayed
                if (numbersPerLine == 10) {
                    // Move to the next line
                    System.out.println();

                    // Reset the counter
                    numbersPerLine = 0;
                }
            }
        }

        // Display a closing message
        System.out.println("\nThat's it for the Divisible Numbers Program!");
    }
}