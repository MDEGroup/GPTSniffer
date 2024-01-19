import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class IntegerFileIO {
    
    public static void main(String[] args) {
        File file = new File("Exercise12_15.txt");
        
        // Create the file if it does not exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                System.exit(1);
            }
        }
        
        // Generate 100 random integers and write them to the file
        Random random = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(1000);
                bw.write(num + " ");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            System.exit(1);
        }
        
        // Read the integers from the file and store them in an ArrayList
        ArrayList<Integer> nums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        
        // Sort the integers in increasing order
        Collections.sort(nums);
        
        // Display the integers in increasing order
        for (int num : nums) {
            System.out.println(num);
        }
    }
    
}