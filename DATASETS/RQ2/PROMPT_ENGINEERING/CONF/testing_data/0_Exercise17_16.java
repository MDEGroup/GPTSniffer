import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequencyCounter {

    public static void main(String[] args) {
        System.out.println("Welcome to the Character Frequency Counter!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the ASCII text file (located in the exercise17_16 package): ");
        String fileName = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader("exercise17_16/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Map<Character, Integer> charFrequency = new HashMap<>();

            int c;
            while ((c = bufferedReader.read()) != -1) {
                char character = (char) c;

                if (Character.isLetterOrDigit(character)) {
                    if (charFrequency.containsKey(character)) {
                        int currentFrequency = charFrequency.get(character);
                        charFrequency.put(character, currentFrequency + 1);
                    } else {
                        charFrequency.put(character, 1);
                    }
                }
            }

            bufferedReader.close();

            System.out.println("Character frequency in the file:");
            for (char character : charFrequency.keySet()) {
                int frequency = charFrequency.get(character);
                System.out.println("Character '" + character + "': " + frequency + " times");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}