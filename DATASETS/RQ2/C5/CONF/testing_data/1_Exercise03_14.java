

import java.util.Scanner;


public class CoinFlipGuess {
	public static void main(String[] args) {

		int x = (int) (Math.random() * 2);

		System.out.println("Enter your guess now! 0 for heads, or 1 for tails:");

		Scanner input = new Scanner(System.in);
		int a = input.nextInt();

		if (a == x) {
			System.out.println("You are correct!");
		} else {
			System.out.println("Wrong! Better luck next time!");
			System.out.println("The correct anwser was: " + x);
		}
		input.close();
	}

}
