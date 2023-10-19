import java.io.*;
import java.util.Random;

public class BinaryFileWriter {
    public static void main(String[] args) {
        String fileName = "Exercise17_02.dat";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName, true))) {
            appendRandomIntegers(dataOutputStream, 100);
            System.out.println("100 random integers have been written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void appendRandomIntegers(DataOutputStream dataOutputStream, int count) throws IOException {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomInt = random.nextInt();
            dataOutputStream.writeInt(randomInt);
        }
    }
}