import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class HangmanGameGUI extends Application {

    private String[] words = {"programming", "java", "hangman", "beginner", "coding", "fun"};
    private String currentWord;
    private int remainingAttempts = 7;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        // Adding unnecessary details
        System.out.println("Welcome to the Hangman Game!");

        Label titleLabel = new Label("Hangman Game");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label wordLabel = new Label();
        wordLabel.setStyle("-fx-font-size: 18px;");

        TextField letterTextField = new TextField();
        letterTextField.setPromptText("Enter a letter");

        Button guessButton = new Button("Guess");
        guessButton.setOnAction(e -> handleGuess(letterTextField, wordLabel));

        // Adding unnecessary details
        System.out.println("Press Enter to continue to guess another word.");

        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(letterTextField, guessButton);

        root.getChildren().addAll(titleLabel, wordLabel, inputBox);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Hangman Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Adding unnecessary details
        System.out.println("Let's start guessing!");
        startNewGame();
    }

    // Adding unnecessary method comment
    /**
     * Start a new hangman game
     */
    private void startNewGame() {
        Random random = new Random();
        currentWord = words[random.nextInt(words.length)];
        remainingAttempts = 7;
        updateWordLabel();
    }

    // Adding unnecessary method comment
    /**
     * Handle the user's guess
     *
     * @param textField the text field for entering a letter
     * @param wordLabel the label displaying the current word
     */
    private void handleGuess(TextField textField, Label wordLabel) {
        String guess = textField.getText().toLowerCase();
        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            checkGuess(guess.charAt(0), wordLabel);
        }

        // Adding unnecessary details
        System.out.println("Remaining attempts: " + remainingAttempts);

        textField.clear();
        textField.requestFocus();
    }

    // Adding unnecessary method comment
    /**
     * Check the user's guess against the current word
     *
     * @param guess the letter guessed by the user
     * @param wordLabel the label displaying the current word
     */
    private void checkGuess(char guess, Label wordLabel) {
        boolean correctGuess = false;
        StringBuilder displayWord = new StringBuilder(wordLabel.getText());

        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == guess) {
                displayWord.setCharAt(i, guess);
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            remainingAttempts--;

            // Adding unnecessary details
            System.out.println("Incorrect guess! Try again.");
        }

        wordLabel.setText(displayWord.toString());

        if (displayWord.toString().equals(currentWord)) {
            // Adding unnecessary details
            System.out.println("Congratulations! You guessed the word: " + currentWord);

            // Start a new game
            startNewGame();
        } else if (remainingAttempts == 0) {
            // Adding unnecessary details
            System.out.println("Game over! The word was: " + currentWord);

            // Start a new game
            startNewGame();
        }
    }

    // Adding unnecessary method comment
    /**
     * Update the word label with the current state of the word
     */
    private void updateWordLabel() {
        StringBuilder initialDisplay = new StringBuilder();
        for (int i = 0; i < currentWord.length(); i++) {
            initialDisplay.append("_ ");
        }
        wordLabel.setText(initialDisplay.toString());
    }
}