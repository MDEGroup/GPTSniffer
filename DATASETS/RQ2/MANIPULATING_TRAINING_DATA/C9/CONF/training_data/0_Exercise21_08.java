import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java WordCounter filename");
            System.exit(1);
        }

        String fileName = args[0];
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] words = line.split("[\\s\\p{Punct}&&[^']&&[^-]]+");
                for (String word : words) {
                    if (word.matches("[a-zA-Z]+.*")) {
                        String lowercaseWord = word.toLowerCase();
                        wordCounts.put(lowercaseWord, wordCounts.getOrDefault(lowercaseWord, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Object[] keys = wordCounts.keySet().toArray();
        Arrays.sort(keys, Comparator.comparing(String::toLowerCase));

        for (Object key : keys) {
            System.out.printf("%-15s%3d%n", key, wordCounts.get(key));
        }
    }

}
