

import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        int num = in.nextInt();
        reverseDisplay(num);
        in.close();
    }

    public static void reverseDisplay(int value) {
        if (value > 0) {
            System.out.print(value % 10);
            reverseDisplay(value / 10);
        }

    }
}
