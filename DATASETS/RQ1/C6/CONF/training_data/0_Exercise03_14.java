import java.util.Scanner;
import java.util.Random;

public class CoinFlip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        int coinFlip = random.nextInt(2);

        
        System.out.print("Guess whether the coin flip results in heads or tails (0 for heads, 1 for tails): ");
        int guess = scanner.nextInt();

        
        if (guess == coinFlip) {
            System.out.println("Your guess is correct!");
        } else {
            System.out.println("Your guess is incorrect!");
        }

        scanner.close();
    }
}