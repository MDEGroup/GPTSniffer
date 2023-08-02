import java.util.Random;
import java.util.Scanner;

public class ThreeSingleDigits {
    public static void main(String[] args) {
        
        Random random = new Random();

        
        int number1 = random.nextInt(10);
        int number2 = random.nextInt(10);
        int number3 = random.nextInt(10);

        
        int sum = number1 + number2 + number3;

        
        Scanner input = new Scanner(System.in);
        System.out.print("What is the sum of " + number1 + " + " + number2 + " + " + number3 + "? ");
        int userSum = input.nextInt();

        
        if (userSum == sum) {
            System.out.println("Congratulations! Your answer is correct.");
        } else {
            System.out.println("Sorry, your answer is incorrect. The correct answer is " + sum + ".");
        }
    }
}