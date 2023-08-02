

import java.util.Scanner;


public class StringPermutation{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.next();
        in.close();

        displayPermutation(input);
    }

    public static void displayPermutation(String s) {
        displayPermutation(" ", s);
    }

    public static void displayPermutation(String s1, String s2) {
        if (s2.length() > 0) {
            for (int i = 0; i < s2.length(); i++) {
                String shuffle1 = s1 + s2.charAt(i);
                String shuffle2 = s2.substring(0, i) + s2.substring(i + 1);
                displayPermutation(shuffle1, shuffle2);
            }
        } else {
            System.out.println(s1);
        }
    }
}
