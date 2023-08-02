

import java.util.*;


public class HangmanRandom{
    static int missed = 0;
    final static String[] words = {"words", "bread", "signal", "time", "display", "friend", "computer",
            "forget",
            "java"};
    static boolean wordLoop = true;
    static boolean gameLoop = true;
    final static String prompt = "(Guess) Enter a letter in word ";
    static String currentWord;
    static int[] guessed;
    static String display;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (gameLoop) {
            currentWord = getRandomWord();
            handleNewWord();
            do {
                System.out.print(prompt + display + " >");
                String guess = in.next();
                handleGuess(guess.charAt(0));
                wordLoop = validateWord();
                if (!wordLoop) {
                    System.out.println("The word is " + currentWord + " you missed " + missed + " times.");
                }
            } while (wordLoop);
            System.out.println("Do you want to guess another word? y or n >");
            gameLoop = in.next().charAt(0) == 'y';
        }
        System.out.println("Thanks for playing hangman!");
        in.close();
    }

    private static boolean validateWord() {
        boolean gameNotOver = false;
        for (int pos : guessed) {
            if (pos == 0) {
                gameNotOver = true;
                break;
            }
        }
        return gameNotOver;
    }

    static String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    static void handleAsterisk() {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (guessed[i] == 0) {
                letters[i] = '*';
            }
        }
        display = String.valueOf(letters);
    }

    static void handleNewWord() {
        guessed = new int[currentWord.length()];
        char[] d = new char[currentWord.length()];
        Arrays.fill(d, '*');
        display = String.valueOf(d);
    }

    static void handleGuess(char guess) {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == guess) {
                if (guessed[i] != 0) {
                    System.out.println(guess + " is already in the word.");
                } else {
                    guessed[i] = 1;
                    handleAsterisk();
                    return;
                }
                break;
            }
        }
        missed++;
        System.out.println(guess + " is not in the word.");
    }
}