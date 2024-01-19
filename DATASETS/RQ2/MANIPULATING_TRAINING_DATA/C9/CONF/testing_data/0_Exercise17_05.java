import java.io.*;
import java.util.Date;

public class ObjectArrayFileWriter {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        Date currentDate = new Date();
        double doubleValue = 5.5;
        String fileName = "Exercise17_05.dat";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Write data to the file
            outputStream.writeObject(intArray);
            outputStream.writeObject(currentDate);
            outputStream.writeDouble(doubleValue);

            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}