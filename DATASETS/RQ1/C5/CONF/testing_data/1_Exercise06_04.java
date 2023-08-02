

import java.util.Scanner;


public class NumberDisplayer{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter and integer now: ");
        int number = input.nextInt();
        reverse(number);
    }

    public static void reverse(int number) {
        while (number > 0) {
            System.out.print(number % 10);
            number = (number / 10);

        }
    }
}
