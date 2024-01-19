import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordCounter <filename>");
            return;
        }

        String filename = args[0];
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using various delimiters
                String[] words = line.split("[ ,;.:?'\")(]");

                for (String word : words) {
                    // Remove leading and trailing whitespace, and convert to lowercase
                    word = word.trim().toLowerCase();

                    // Check if the word starts with a letter
                    if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
                        // Update the word count in the map
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort the wordCounts map by keys (words)
        Map<String, Integer> sortedWordCounts = new TreeMap<>(wordCounts);

        // Display the word counts in alphabetical order
        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}