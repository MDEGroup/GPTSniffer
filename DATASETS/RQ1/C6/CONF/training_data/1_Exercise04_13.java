

import java.util.*;


public class VowelConsonantChecker{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String str = in.next().trim();
        if (str.length() > 1) {
            System.out.println(str + " is invalid input.");
        } else {
            char ch = str.charAt(0);
            if (Character.isLetter(ch)) {
                String s = ch + "";
                String res = "";
                if ("aeiou".contains(s.toLowerCase())) {
                    res += "vowel";
                } else {
                    res += "consonant";
                }

                System.out.println(ch + " is a " + res);

            } else {
                System.out.println(ch + " is invalid input.");
            }
        }
        in.close();
    }
}