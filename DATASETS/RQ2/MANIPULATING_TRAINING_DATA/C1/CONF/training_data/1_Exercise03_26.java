package ch_03;

import java.util.*;


public class Exercise03_26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int userInt = in.nextInt();

        boolean fiveAndSix = userInt % 5 == 0 && userInt % 6 == 0;
        boolean fiveOrSix = userInt % 5 == 0 || userInt % 6 == 0;
        boolean fiveSixNotBoth = (userInt % 5 == 0 || userInt % 6 == 0) ^ (userInt % 5 == 0 && userInt % 6 == 0);

        System.out.println("Is " + userInt + " divisible by 5 and 6? " + fiveAndSix);
        System.out.println("Is " + userInt + " divisible by 5 or 6? " + fiveOrSix);
        System.out.println("Is " + userInt + " divisible by 5 or 6, but not both? " + fiveSixNotBoth);


    }
}