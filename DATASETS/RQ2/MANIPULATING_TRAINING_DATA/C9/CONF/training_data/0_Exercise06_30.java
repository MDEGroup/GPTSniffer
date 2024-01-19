import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int point = 0;
        int sum = rollDice();

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You rolled " + sum + ". You lose.");
        } else if (sum == 7 || sum == 11) {
            System.out.println("You rolled " + sum + ". You win.");
        } else {
            point = sum;
            System.out.println("You rolled " + sum + ". Point is " + point + ".");
            sum = rollDice();

            while (sum != 7 && sum != point) {
                System.out.println("You rolled " + sum + ".");
                sum = rollDice();
            }

            if (sum == 7) {
                System.out.println("You rolled " + sum + ". You lose.");
            } else {
                System.out.println("You rolled " + sum + ". You win.");
            }
        }
    }

    public static int rollDice() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}