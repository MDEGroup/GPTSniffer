import java.util.Scanner;

public class AdditionQuizLoop {
    public static void main(String[] args) {
        final int NUMBER_OF_QUESTIONS = 10; // Total number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();

        Scanner input = new Scanner(System.in);

        while (count < NUMBER_OF_QUESTIONS) {
            // Generate two random integers between 1 and 15
            int number1 = (int) (Math.random() * 15 + 1);
            int number2 = (int) (Math.random() * 15 + 1);

            // Prompt the user to answer the question
            System.out.print("What is " + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            // Check the user's answer
            if (number1 + number2 == answer) {
                System.out.println("You are correct!");
                correctCount++;
            } else {
                System.out.println("Your answer is wrong.");
                System.out.println(number1 + " + " + number2 + " should be " + (number1 + number2));
            }

            // Increase the question count
            count++;
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount + " out of " + NUMBER_OF_QUESTIONS);
        System.out.println("Test time is " + testTime / 1000 + " seconds");
    }
}
