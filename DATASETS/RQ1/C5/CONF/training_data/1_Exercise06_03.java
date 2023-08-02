

import java.util.*;


public class Palindrome{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = in.nextInt();

        if (isPalindrome(num)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }
    }

    public static int reverse(int number) {
        String temp = "";
        while (number > 0) {
            int t = number % 10;
            number /= 10;
            temp += t;

        }
        return Integer.parseInt(temp);
    }

    public static boolean isPalindrome(int number) {
        String n1 = String.valueOf(number);
        String n2 = String.valueOf(reverse(number));

        return n1.equals(n2);

    }
}