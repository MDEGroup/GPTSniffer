import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Exercise18_31 {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Exercise18_31 dirName oldWord newWord");
            System.exit(1);
        }

        String directoryName = args[0];
        String oldWord = args[1];
        String newWord = args[2];

        replaceWordsInFiles(directoryName, oldWord, newWord);

        System.out.println("Word replacement complete.");
    }

    public static void replaceWordsInFiles(String directoryName, String oldWord, String newWord) {
        File directory = new File(directoryName);

        if (!directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryName);
            System.exit(1);
        }

        replaceWordsInDirectory(directory, oldWord, newWord);
    }

    private static void replaceWordsInDirectory(File directory, String oldWord, String newWord) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    replaceWordsInDirectory(file, oldWord, newWord);
                } else {
                    replaceWordsInFile(file, oldWord, newWord);
                }
            }
        }
    }

    private static void replaceWordsInFile(File file, String oldWord, String newWord) {
        try {
            Path path = Paths.get(file.getPath());
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(oldWord, newWord);
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
        }
    }
}