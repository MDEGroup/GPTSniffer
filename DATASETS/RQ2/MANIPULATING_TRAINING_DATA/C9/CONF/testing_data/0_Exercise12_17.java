import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        final int MAX_WRONG_GUESSES = 7;

        // Load words from an external file
        String[] words = loadWordsFromFile("hangman_words.txt");

        // Select a random word from the word list
        String targetWord = selectRandomWord(words);

        // Initialize the hidden word with asterisks
        char[] hiddenWord = initializeHiddenWord(targetWord);

        int wrongGuesses = 0;

        // Create a scanner for user input
        Scanner inputScanner = new Scanner(System.in);

        // Main game loop
        while (wrongGuesses < MAX_WRONG_GUESSES && new String(hiddenWord).contains("*")) {
            System.out.print("(Guess) Enter a letter in word " + new String(hiddenWord) + " > ");
            char guess = inputScanner.nextLine().charAt(0);
            boolean correctGuess = updateHiddenWord(targetWord, hiddenWord, guess);

            if (!correctGuess) {
                System.out.println(guess + " is not in the word.");
                wrongGuesses++;
            }
        }

        // Close the input scanner
        inputScanner.close();

        // Display the game result
        displayGameResult(targetWord, new String(hiddenWord));
    }

    // Load words from a file and return them as an array
    private static String[] loadWordsFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            return input.nextLine().split("\\s+");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not find the word file.");
            System.exit(1);
        }
        return null;
    }

    // Select a random word from an array of words
    private static String selectRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    // Initialize the hidden word with asterisks
    private static char[] initializeHiddenWord(String word) {
        char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '*';
        }
        return hiddenWord;
    }

    // Update the hidden word based on the user's guess
    private static boolean updateHiddenWord(String word, char[] hiddenWord, char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess && hiddenWord[i] == '*') {
                hiddenWord[i] = guess;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    // Display the game result
    private static void displayGameResult(String targetWord, String hiddenWord) {
        if (hiddenWord.contains("*")) {
            System.out.println("You lose. The word was " + targetWord);
        } else {
            System.out.println("Congratulations! You guessed the word: " + targetWord);
        }
    }
}