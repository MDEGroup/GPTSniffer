import java.io.*;
import java.util.Random;

public class Exercise17_01{
    public static void main(String[] args) {
        try {
            
            FileWriter fileWriter = new FileWriter("Exercise17_01.txt", true);

            
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                fileWriter.write(num + " ");
            }

            
            fileWriter.close();

            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
