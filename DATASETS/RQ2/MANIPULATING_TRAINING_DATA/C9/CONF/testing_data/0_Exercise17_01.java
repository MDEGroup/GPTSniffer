import java.io.*;
import java.util.Random;

public class Exercise17_01 {
    public static void main(String[] args) {
        String fileName = "Exercise17_01.txt";

        try {
            // Create a FileWriter in append mode (true as the second argument)
            FileWriter fileWriter = new FileWriter(fileName, true);

            // Create a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Generate and write 100 random integers to the file
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int randomInt = random.nextInt(1000); // Change the range as needed
                bufferedWriter.write(Integer.toString(randomInt));
                if (i < 99) {
                    bufferedWriter.write(" "); // Separate integers with spaces, except for the last one
                }
            }

            // Close the BufferedWriter to flush and close the file
            bufferedWriter.close();

            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}