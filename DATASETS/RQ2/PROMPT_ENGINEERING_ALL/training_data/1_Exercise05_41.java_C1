package ch_05;

import java.util.Scanner;


public class Exercise05_41 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int max = 0;
        int count = 0;
        int numStart = 0;

        do {
            System.out.println("Enter an integer (0 ends the input): ");

            numStart = input.nextInt();

            if (numStart > max) {
                count = 1;
                max = numStart;
                continue;
            }
            if (numStart == max) {
                count++;
            }

        } while (numStart != 0);

        System.out.println("Max is: " + max + "\nThe count for max is: " + count);
    }
}