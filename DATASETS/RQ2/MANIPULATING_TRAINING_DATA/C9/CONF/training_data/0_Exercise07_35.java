import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"write", "that", "program", "java", "python", "computer", "science", "software", "engineering", "algorithm"};
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            String wordToGuess = words[random.nextInt(words.length)];
            int misses = 0;
            int numberOfGuesses = 0;
            boolean[] lettersGuessed = new boolean[wordToGuess.length()];

            while (true) {
                System.out.print("(Guess) Enter a letter in word ");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (lettersGuessed[i]) {
                        System.out.print(wordToGuess.charAt(i));
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.print(" > ");

                char guess = input.next().charAt(0);
                boolean isMiss = true;

                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess && !lettersGuessed[i]) {
                        lettersGuessed[i] = true;
                        isMiss = false;
                    }
                }

                if (isMiss) {
                    misses++;
                    System.out.println(guess + " is not in the word");
                } else {
                    numberOfGuesses++;
                    System.out.println(guess + " is in the word");
                }

                boolean wordGuessed = true;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (!lettersGuessed[i]) {
                        wordGuessed = false;
                        break;
                    }
                }

                if (wordGuessed) {
                    System.out.println("The word is " + wordToGuess + ". You missed " + misses + " time" + (misses > 1 ? "s" : ""));
                    break;
                }
            }

            System.out.print("Do you want to guess another word? Enter y or n> ");
            char playAgainChar = input.next().charAt(0);
            playAgain = (playAgainChar == 'y' || playAgainChar == 'Y');
        }
    }
}