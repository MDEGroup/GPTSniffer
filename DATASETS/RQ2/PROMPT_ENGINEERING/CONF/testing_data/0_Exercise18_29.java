import java.util.Scanner;
import java.io.File;

public class FileCounter {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the File Counter!");

        // Get user input for the directory path
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Count and display the number of files in the directory
        int fileCount = countFiles(directoryPath);
        System.out.println("Number of files in the directory: " + fileCount);

        // Close the scanner
        scanner.close();
    }

    // Method to count the number of files in a directory
    public static int countFiles(String directoryPath) {
        int count = 0;

        // Create a File object for the specified directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List all files in the directory
            File[] files = directory.listFiles();

            // Count the number of files
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        count++;
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path. Please provide a valid directory path.");
        }

        return count;
    }
}
