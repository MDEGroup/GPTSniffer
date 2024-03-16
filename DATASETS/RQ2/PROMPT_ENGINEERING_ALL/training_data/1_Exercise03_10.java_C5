

import java.util.Scanner;


public class QuestionGenerator {

    public static void main(String[] args) {
        int n1 = (int) (Math.random() * 100); 
        int n2 = (int) (Math.random() * 100);

        System.out.print("What is " + n1 + " + " + n2 + "? ");

        Scanner input = new Scanner(System.in);
        int userAnswer = input.nextInt();

        if (n1 + n2 == userAnswer)
            System.out.println("You are correct!");
        else {
            System.out.println("Your answer is wrong.");
            System.out.println(n1 + " + " + n2 + " should be " + (n1 + n2));
            input.close();
        }
    }
}
