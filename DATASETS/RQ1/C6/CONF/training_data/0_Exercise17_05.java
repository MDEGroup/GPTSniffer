import java.io.*;
import java.util.*;

public class Exercise17_05{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        int[] nums = {1, 2, 3, 4, 5};
        Date date = new Date();
        double value = 5.5;

        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"));

        
        output.writeObject(nums);
        output.writeObject(date);
        output.writeDouble(value);

        
        output.close();

        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_05.dat"));

        
        int[] readNums = (int[]) input.readObject();
        Date readDate = (Date) input.readObject();
        double readValue = input.readDouble();

        System.out.println("Array of integers: " + Arrays.toString(readNums));
        System.out.println("Date object: " + readDate);
        System.out.println("Double value: " + readValue);

        
        input.close();
    }
}
