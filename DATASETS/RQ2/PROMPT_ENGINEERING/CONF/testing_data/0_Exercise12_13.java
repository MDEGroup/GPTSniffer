import java.io.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TextAnalyzer <filename>");
        } else {
            String filename = args[0];
            processFile(filename);
        }
    }

    private static void processFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
                lineCount++;
            }

            reader.close();

            displayResults(charCount, wordCount, lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }

    private static void displayResults(int charCount, int wordCount, int lineCount) {
        System.out.println("Character count: " + charCount);
        System.out.println("Word count: " + wordCount);
        System.out.println("Line count: " + lineCount);
    }
}