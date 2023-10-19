import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the ASCII text file: ");
        String fileName = scanner.nextLine();

        File file = new File("exercise17_16", fileName);

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            int characterCode;

            while ((characterCode = reader.read()) != -1) {
                char character = (char) characterCode;
                if (Character.isLetterOrDigit(character)) {
                    updateFrequency(frequencyMap, character);
                }
            }

            displayCharacterFrequencies(frequencyMap);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void updateFrequency(Map<Character, Integer> frequencyMap, char character) {
        frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
    }

    private static void displayCharacterFrequencies(Map<Character, Integer> frequencyMap) {
        System.out.println("Character frequencies in the file:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue() + " times");
        }
    }
}