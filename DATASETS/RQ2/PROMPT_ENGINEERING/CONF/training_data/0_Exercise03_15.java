import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        // Create a Random object to generate random integers
        Random random = new Random();

        // Generate a three-digit lottery number
        int lottery = random.nextInt(900) + 100; // ensure the number is three-digit

        // Prompt the user to enter a three-digit number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a three-digit number: ");
        int guess = input.nextInt();

        // Check if the guess matches the lottery number
        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000!");
        } else {
            // Check if all digits in the guess match all digits in the lottery number
            int lotteryDigit1 = lottery / 100;
            int lotteryDigit2 = (lottery / 10) % 10;
            int lotteryDigit3 = lottery % 10;

            int guessDigit1 = guess / 100;
            int guessDigit2 = (guess / 10) % 10;
            int guessDigit3 = guess % 10;

            if (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit3) {
                System.out.println("Match all digits: you win $3,000!");
            } else if (guessDigit1 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit3 == lotteryDigit3) {
                System.out.println("Match one digit: you win $1,000!");
            } else {
                System.out.println("Sorry, no match. Try again next time!");
            }
        }
    }
}