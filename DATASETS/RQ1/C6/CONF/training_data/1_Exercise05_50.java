

import java.util.Scanner;


public class CountUpperCase{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string with some uppercase letters: ");

        String toBeevaluated = input.nextLine();
        int numberOfuppercase = 0;
        int x = 0;

        while (x < toBeevaluated.length()) {

            if (Character.isUpperCase(toBeevaluated.charAt(x))) {
                numberOfuppercase++;
            }
            x++;
        }

        System.out.println("The number of upper case letters is: " + numberOfuppercase);

    }

}
