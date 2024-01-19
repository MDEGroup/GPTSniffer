import java.io.*;

public class TextReplacer {

    public static void main(String[] args) {
        // Check if the correct number of command-line arguments are provided
        if (args.length != 3) {
            System.out.println("Usage: java TextReplacer <filename> <oldString> <newString>");
            return;
        }

        // Get command-line arguments
        String filename = args[0];
        String oldString = args[1];
        String newString = args[2];

        // Read the file and replace the text
        replaceTextInFile(filename, oldString, newString);

        System.out.println("Text replaced successfully in the file.");
    }

    // Method to replace text in a file and save changes in the original file
    private static void replaceTextInFile(String filename, String oldString, String newString) {
        try {
            // Read the content of the file
            StringBuilder fileContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Replace the old string with the new string
            String updatedContent = fileContent.toString().replace(oldString, newString);

            // Write the updated content back to the original file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(updatedContent);

            // Close the writer
            writer.close();

        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error processing file: " + filename);
        }
    }
}