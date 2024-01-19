import java.io.*;
import java.util.Scanner;

public class PackageInserter {

    public static void main(String[] args) {
        // Check if the user provided the root directory as a command-line argument
        if (args.length == 1) {
            String rootDirectoryPath = args[0];
            File rootDirectory = new File(rootDirectoryPath);

            // Check if the provided path is a directory
            if (rootDirectory.isDirectory()) {
                insertPackageStatements(rootDirectory);
                System.out.println("Package statements inserted successfully.");
            } else {
                System.out.println("Error: The provided path is not a directory.");
            }
        } else {
            System.out.println("Usage: java PackageInserter <srcRootDirectory>");
        }
    }

    // Method to insert package statements in Java source files
    private static void insertPackageStatements(File directory) {
        // Get the list of files in the directory
        File[] files = directory.listFiles();

        // Iterate through each file in the directory
        for (File file : files) {
            // Check if the file is a directory
            if (file.isDirectory()) {
                // Recursively insert package statements in subdirectories
                insertPackageStatements(file);
            } else if (file.getName().endsWith(".java")) {
                // Insert package statement in Java source file
                insertPackageStatement(file);
            }
        }
    }

    // Method to insert package statement in a Java source file
    private static void insertPackageStatement(File file) {
        try {
            // Read the contents of the file
            StringBuilder fileContent = new StringBuilder();
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine()).append("\n");
            }

            // Close the scanner
            scanner.close();

            // Insert the package statement as the first line
            String packageName = file.getParentFile().getName();
            String packageStatement = "package " + packageName + ";";
            fileContent.insert(0, packageStatement + "\n");

            // Write the modified content back to the file
            PrintWriter writer = new PrintWriter(file);
            writer.write(fileContent.toString());
            writer.close();

        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error processing file: " + file.getName());
        }
    }
}