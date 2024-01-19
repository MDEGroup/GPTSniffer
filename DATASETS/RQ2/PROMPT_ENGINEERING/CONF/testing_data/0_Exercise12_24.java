import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DatasetCreator {

    public static void main(String[] args) {
        // Define the file name
        String fileName = "Salary.txt";

        // Attempt to create the data file
        try {
            // Create a BufferedWriter for efficient writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            // Write 1,000 lines of faculty members' information
            for (int i = 1; i <= 1000; i++) {
                // Generate random data
                String firstName = "FirstName" + i;
                String lastName = "LastName" + i;
                String rank = generateRandomRank();
                double salary = generateRandomSalary(rank);

                // Write the data to the file
                writer.write(firstName + " " + lastName + " " + rank + " " + salary);
                writer.newLine();
            }

            // Close the writer
            writer.close();

            System.out.println("Data file created successfully: " + fileName);
        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error creating the data file: " + e.getMessage());
        }
    }

    // Method to generate a random rank (assistant, associate, full)
    private static String generateRandomRank() {
        String[] ranks = {"assistant", "associate", "full"};
        Random random = new Random();
        return ranks[random.nextInt(ranks.length)];
    }

    // Method to generate a random salary based on rank
    private static double generateRandomSalary(String rank) {
        Random random = new Random();
        double salary;

        switch (rank) {
            case "assistant":
                salary = 50000 + random.nextDouble() * 30000;
                break;
            case "associate":
                salary = 60000 + random.nextDouble() * 50000;
                break;
            case "full":
                salary = 75000 + random.nextDouble() * 55000;
                break;
            default:
                salary = 0;
        }

        return Math.round(salary * 100.0) / 100.0; // Round to two decimal places
    }
}
