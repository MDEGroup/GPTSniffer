import java.util.Scanner;

public class StateCapitalsGame {
    public static void main(String[] args) {
        String[][] stateCapitals = {
            {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, /* and so on... */};

        Scanner input = new Scanner(System.in);
        int correctCount = 0;

        System.out.println("Welcome to the State Capitals Quiz!");
        System.out.println("Guess the capital of each state.");

        for (String[] stateCapital : stateCapitals) {
            System.out.print("What's the capital of " + stateCapital[0] + "? ");
            String userGuess = input.nextLine().trim();

            if (userGuess.equalsIgnoreCase(stateCapital[1])) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital of " + stateCapital[0] + " is " + stateCapital[1] + ".");
            }
        }

        System.out.println("\nYou got " + correctCount + " out of " + stateCapitals.length + " correct.");
    }
}