

import java.util.Scanner;


public class CountOccurrences {
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String and a character to count it's occurrences:");
        String str = in.next();
        char ch = in.next().charAt(0);

        System.out.println("Character " + ch + " occurs " + count(str, ch) + " times in " + str);
        in.close();
    }

    public static int count(String str, char a) {
        if (str.length() > 0) {
            if (str.charAt(str.length() - 1) == a) {
                return 1 + count(str.substring(0, str.length() - 1), a);
            } else {
                return count(str.substring(0, str.length() - 1), a);
            }
        }
        return 0;

    }
}
