import java.io.*;
import java.util.*;

public class Exercise17_05 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create array of integers, date object, and double value
        int[] nums = {1, 2, 3, 4, 5};
        Date date = new Date();
        double value = 5.5;

        // Create output stream to write to file
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"));

        // Write objects to file
        output.writeObject(nums);
        output.writeObject(date);
        output.writeDouble(value);

        // Close output stream
        output.close();

        // Create input stream to read from file
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_05.dat"));

        // Read objects from file and print them
        int[] readNums = (int[]) input.readObject();
        Date readDate = (Date) input.readObject();
        double readValue = input.readDouble();

        System.out.println("Array of integers: " + Arrays.toString(readNums));
        System.out.println("Date object: " + readDate);
        System.out.println("Double value: " + readValue);

        // Close input stream
        input.close();
    }
}
