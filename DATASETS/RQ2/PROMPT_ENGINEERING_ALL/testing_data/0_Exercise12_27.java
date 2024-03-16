import java.io.File;import java.io.FileNotFoundException;import java.io.PrintWriter;import java.util.Scanner;public class WordReplacer {    public static void main(String[] args) {        // Check if the user provided the symbol '*' as a command-line argument        if (args.length == 1 && args[0].equals("*")) {            // Get the list of files in the current directory            File currentDirectory = new File(".");            File[] files = currentDirectory.listFiles();            // Iterate through each file in the directory            for (File file : files) {                // Check if the file is a directory                if (file.isFile()) {                    // Replace words in the file if it matches the Exercise pattern                    if (file.getName().matches("Exercise\\d_\\d.*")) {                        replaceWords(file);                    }                }            }            System.out.println("Words replaced successfully.");        } else {            System.out.println("Usage: java WordReplacer *");        }    }    // Method to replace words by padding '0' before i and j if they are single digits    private static void replaceWords(File file) {        try {            // Create a Scanner to read from the file            Scanner scanner = new Scanner(file);            // Create a PrintWriter to write to a temporary file            PrintWriter writer = new PrintWriter("tempFile.txt");            // Read each line from the file            while (scanner.hasNextLine()) {                String line = scanner.nextLine();                // Replace words in the line                String modifiedLine = line.replaceAll("Exercise(\\d)_(\\d)", "Exercise0$1_0$2");                // Write the modified line to the temporary file                writer.println(modifiedLine);            }            // Close the scanner and writer to free up resources            scanner.close();            writer.close();            // Rename the temporary file to the original file            File tempFile = new File("tempFile.txt");            if (tempFile.renameTo(file)) {                System.out.println("Words replaced in file: " + file.getName());            } else {                System.out.println("Error replacing words in file: " + file.getName());            }        } catch (FileNotFoundException e) {            // Handle file not found exception            System.out.println("Error: File '" + file.getName() + "' not found.");        }    }}