import java.io.*;
import java.util.Scanner;

public class TextReplacer {

    public static void main(String[] args) {
        // Check if the correct number of command-line arguments are provided
        if (args.length != 3) {
            System.out.println("Usage: java TextReplacer <directory> <oldString> <newString>");
            return;
        }

        // Get command-line arguments
        String directoryPath = args[0];
        String oldString = args[1];
        String newString = args[2];

        // Replace text in all files in the specified directory
        replaceTextInDirectory(directoryPath, oldString, newString);

        System.out.println("Text replaced successfully in all files.");
    }

    // Method to replace text in all files in a directory
    private static void replaceTextInDirectory(String directoryPath, String oldString, String newString) {
        File directory = new File(directoryPath);

        // Check if the provided path is a directory
        if (!directory.isDirectory()) {
            System.out.println("Error: The provided path is not a directory.");
            return;
        }

        // Get the list of files in the directory
        File[] files = directory.listFiles();

        // Iterate through each file in the directory
        for (File file : files) {
            // Check if the file is a regular file
            if (file.isFile()) {
                // Replace text in the file
                replaceTextInFile(file, oldString, newString);
            }
        }
    }

    // Method to replace text in a file
    private static void replaceTextInFile(File file, String oldString, String newString) {
        try {
            // Read the content of the file
            StringBuilder fileContent = new StringBuilder();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine()).append("\n");
            }

            // Close the scanner
            scanner.close();

            // Replace the old string with the new string
            String updatedContent = fileContent.toString().replace(oldString, newString);

            // Write the updated content back to the file
            PrintWriter writer = new PrintWriter(file);
            writer.write(updatedContent);

            // Close the writer
            writer.close();

        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error processing file: " + file.getName());
        }
    }
}
