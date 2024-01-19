import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordListFromFile {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordListFromFile <filename>");
            return;
        }

        String filename = args[0];
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    // Remove non-letter characters and empty words
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort and display words in ascending alphabetical order
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
    }
}