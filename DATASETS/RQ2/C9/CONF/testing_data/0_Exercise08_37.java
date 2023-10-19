import java.util.Scanner;

public class CapitalQuiz {
    public static void main(String[] args) {
        // Define a two-dimensional array to store states and their capitals
        String[][] stateCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            // Add the remaining states and capitals
        };

        int correctAnswers = 0;
        Scanner userInput = new Scanner(System.in);

        // Loop through the states and ask the user for capital names
        for (int i = 0; i < stateCapitals.length; i++) {
            System.out.print("What is the capital of " + stateCapitals[i][0] + "? ");
            String userResponse = userInput.nextLine();

            if (isAnswerCorrect(userResponse, stateCapitals[i][1])) {
                System.out.println("Correct!\n");
                correctAnswers++;
            } else {
                System.out.println("Incorrect. The correct answer is " + stateCapitals[i][1] + "\n");
            }
        }

        // Display the total number of correct answers
        System.out.println("You answered " + correctAnswers + " out of 50 state capitals correctly.");
    }

    // Helper method to check if the answer is correct (case-insensitive)
    private static boolean isAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}