import java.io.*;
import java.nio.file.*;

public class Exercise17_08 {
    public static void main(String[] args) {
        String countFileName = "Exercise17_08.dat";
        int executionCount = 0;

        File countFile = new File(countFileName);

        if (countFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(countFile));
                executionCount = Integer.parseInt(reader.readLine());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        executionCount++;

        System.out.println("This program has been executed " + executionCount + " times.");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(countFile));
            writer.write(String.valueOf(executionCount));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}