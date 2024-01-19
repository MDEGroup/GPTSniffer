import java.io.*;

public class SumIntegersInBinaryFile {
    public static void main(String[] args) {
        try {
            FileInputStream fileStream = new FileInputStream("Exercise17_03.dat");
            DataInputStream dataStream = new DataInputStream(fileStream);

            int sum = 0; // Initialize sum to 0

            while (true) { // Keep looping until an exception occurs
                try {
                    int num = dataStream.readInt(); // Read an integer from the file
                    sum += num; // Add the integer to the sum
                } catch (EOFException e) {
                    break; // Exit the loop when we reach the end of the file
                }
            }

            dataStream.close(); // Close the data stream
            fileStream.close(); // Close the file stream

            System.out.println("The sum of integers in the file is: " + sum); // Print the sum
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle any IO errors
        }
    }
}