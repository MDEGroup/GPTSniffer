import java.util.Scanner;

public class SeriesCalculator {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Series Calculator!");

        // Get user input for the number of terms in the series
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the series (e.g., 10): ");
        int numberOfTerms = scanner.nextInt();

        // Display the series for the given number of terms
        displaySeries(numberOfTerms);

        // Close the scanner
        scanner.close();
    }

    // Method to display the series
    public static void displaySeries(int numberOfTerms) {
        // Display the series header
        System.out.println("The series for " + numberOfTerms + " terms:");

        // Initialize the sum
        double sum = 0;

        // Loop to calculate and display each term in the series
        for (int i = 1; i <= numberOfTerms; i++) {
            sum += (double) i / (2 * i + 1);
            System.out.printf("Term %d: %.4f\n", i, sum);
        }
    }
}
