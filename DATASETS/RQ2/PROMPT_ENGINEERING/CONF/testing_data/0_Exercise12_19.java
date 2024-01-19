import java.io.*;
import java.net.URL;
import java.util.Scanner;

// Program to count the number of words in Lincoln's Gettysburg address
public class WordCounter {

    // Main method
    public static void main(String[] args) {
        try {
            // URL for Lincoln's Gettysburg address
            URL url = new URL("http://se.cs.depaul.edu/Java/Chapter04/Lincoln.txt");

            // Open a connection to the URL and create a Scanner for reading
            Scanner scanner = new Scanner(url.openStream());

            // Initialize word count variable
            int wordCount = 0;

            // Read the Gettysburg address line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Split the line into words using a simple space-based approach
                String[] words = line.split(" ");

                // Count the words in the line
                wordCount += words.length;
            }

            // Close the scanner to free up resources
            scanner.close();

            // Print the final word count
            System.out.println("The Gettysburg address contains approximately " + wordCount + " words.");

        } catch (IOException e) {
            // Handle the exception if there is an error reading from the URL
            System.out.println("Error reading data from the URL.");
        }
    }
}