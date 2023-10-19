import java.io.*;

public class SumIntegersInBinaryFile {
    public static void main(String[] args) {
        String fileName = "Exercise17_03.dat";
        int sum = 0;

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    int value = dataInputStream.readInt();
                    sum += value;
                } catch (EOFException e) {
                    // End of file reached, break out of the loop
                    break;
                }
            }

            System.out.println("Sum of integers in the file " + fileName + ": " + sum);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}