import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java AlphabeticalOrder <filename>");
            return;
        }

        String filename = args[0];
        File file = new File(filename);
        Set<String> words = new TreeSet<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (word.length() > 0) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
