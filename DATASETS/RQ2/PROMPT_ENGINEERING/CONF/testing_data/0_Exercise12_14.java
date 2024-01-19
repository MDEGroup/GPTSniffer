import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the file name
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            // Open the file for reading
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            // Initialize variables
            int total = 0;
            int count = 0;

            // Read scores from the file
            while (fileScanner.hasNext()) {
                int score = fileScanner.nextInt();
                total += score;
                count++;
            }

            // Close the file scanner
            fileScanner.close();

            // Calculate and display total and average
            if (count > 0) {
                double average = (double) total / count;
                System.out.println("Total: " + total);
                System.out.println("Average: " + average);
            } else {
                System.out.println("No scores found in the file.");
            }

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("Error: File '" + fileName + "' not found.");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
