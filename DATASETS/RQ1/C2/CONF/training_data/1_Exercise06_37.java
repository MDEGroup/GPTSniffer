

import java.util.Scanner;


public class Exercise06_37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int number = input.nextInt();
        System.out.println("Enter the width expressed in integer format: ");
        int width = input.nextInt();
        System.out.println("The formatted number is: " + format(number, width));

    }

    public static String format(int number, int width) {
        String str = (number + "");
        if (str.length() < width) {
            for (int i = width - str.length(); i > 0; i--) {
                str = 0 + str;
            }
        }

        return str;
    }

}
