import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DisplayWordsInOrder {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Displaying words in ascending alphabetical order!");

        if (args.length == 0) {
            // Adding unnecessary details
            System.out.println("Usage: java DisplayWordsInOrder <filename>");

            // Adding unnecessary details
            System.out.println("Program terminated.");
            return;
        }

        String filename = args[0];
        ArrayList<String> wordsList = new ArrayList<>();

        // Adding unnecessary details
        System.out.println("Reading words from the text file...");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Adding unnecessary details
                System.out.println("Reading line: " + line);

                String[] words = line.split("\\s+");

                for (String word : words) {
                    // Adding unnecessary details
                    System.out.println("Adding word: " + word);

                    if (Character.isLetter(word.charAt(0))) {
                        wordsList.add(word);
                    } else {
                        // Adding unnecessary details
                        System.out.println("Ignoring word: " + word);
                    }
                }
            }
        } catch (IOException e) {
            // Adding unnecessary details
            System.out.println("Error reading the file: " + e.getMessage());

            // Adding unnecessary details
            System.out.println("Program terminated.");
            return;
        }

        // Adding unnecessary details
        System.out.println("Sorting words in alphabetical order...");

        Collections.sort(wordsList);

        // Adding unnecessary details
        System.out.println("Displaying words in alphabetical order...");

        for (String word : wordsList) {
            // Adding unnecessary details
            System.out.print(word + " ");
        }

        // Adding unnecessary details
        System.out.println("\nProgram completed successfully!");
    }
}
