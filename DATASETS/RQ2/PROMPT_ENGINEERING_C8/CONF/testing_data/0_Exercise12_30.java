import java.io.File;import java.io.FileNotFoundException;import java.util.Scanner;public class LetterOccurrenceCounter {    public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);        // Prompt the user to enter a file name        System.out.print("Enter a filename: ");        String fileName = scanner.nextLine();        // Count occurrences of each letter in the file        countLetterOccurrences(fileName);        // Close the scanner        scanner.close();    }    // Method to count occurrences of each letter in the file    private static void countLetterOccurrences(String fileName) {        try {            // Create a file object            File file = new File(fileName);            // Create an array to store occurrences of each letter            int[] letterOccurrences = new int[26];            // Initialize array with zeros            for (int i = 0; i < letterOccurrences.length; i++) {                letterOccurrences[i] = 0;            }            // Read the file            Scanner fileScanner = new Scanner(file);            // Process each line in the file            while (fileScanner.hasNextLine()) {                String line = fileScanner.nextLine();                // Process each character in the line                for (char character : line.toCharArray()) {                    // Check if the character is a letter (case-insensitive)                    if (Character.isLetter(character)) {                        // Convert the letter to uppercase and update occurrences                        int index = Character.toUpperCase(character) - 'A';                        letterOccurrences[index]++;                    }                }            }            // Close the file scanner            fileScanner.close();            // Display the occurrences of each letter            for (int i = 0; i < letterOccurrences.length; i++) {                char letter = (char) ('A' + i);                System.out.println("Number of " + letter + "'s: " + letterOccurrences[i]);            }        } catch (FileNotFoundException e) {            // Handle file not found exception            System.out.println("Error: File not found - " + e.getMessage());        }    }}