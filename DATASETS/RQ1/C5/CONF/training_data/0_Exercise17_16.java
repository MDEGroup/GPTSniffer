import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharFrequencyCounter{
    public static void main(String[] args) {
        
        System.out.print("Enter the file name: ");
        String fileName = new Scanner(System.in).nextLine();

        
        Map<Character, Integer> freqMap = new HashMap<>();
        try (Scanner input = new Scanner(new File("exercise17_16/" + fileName))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return;
        }

        
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            System.out.printf("%c: %d\n", ch, freq);
        }
    }
}
