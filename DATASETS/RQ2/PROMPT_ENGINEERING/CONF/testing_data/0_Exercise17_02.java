import java.io.*;
import java.util.Random;

public class BinaryDataFileCreator {
    public static void main(String[] args) {
        // Let's create a binary data file named "Exercise17_02.dat"
        File file = new File("Exercise17_02.dat");

        // Check if the file already exists
        if (file.exists()) {
            System.out.println("The file Exercise17_02.dat already exists. Appending data to it...");
        } else {
            System.out.println("The file Exercise17_02.dat does not exist. Creating a new file...");
        }

        // We'll use a try-catch block for file handling
        try {
            // Create a FileOutputStream to write binary data
            FileOutputStream fos = new FileOutputStream(file, true); // We append data if the file already exists

            // Create a DataOutputStream to write integers
            DataOutputStream dos = new DataOutputStream(fos);

            // Let's generate and write 100 integers into the file
            for (int i = 0; i < 100; i++) {
                // Generate a random integer between 1 and 100
                int randomNumber = new Random().nextInt(100) + 1;

                // Write the integer to the file
                dos.writeInt(randomNumber);

                // Display a message for each integer written
                System.out.println("Writing integer: " + randomNumber);
            }

            // Close the DataOutputStream
            dos.close();

            System.out.println("Data successfully written to Exercise17_02.dat.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing data: " + e.getMessage());
        }
    }
}