

import java.util.*;


public class Exercise06_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string followed by a character: ");
        String s = in.nextLine();
        char c = s.charAt(s.length() - 1);
        s = s.substring(0, s.length() - 1);
        s = s.trim();

        System.out.println("The character " + c + " occurs " + count(s, c) + " times in " + s);

    }

    public static int count(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }
}