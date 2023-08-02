

import java.util.Scanner;


public class UpperCaseCounterPanel{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s = in.nextLine().trim();
        System.out.println("The number of uppercase letters in " + s + " is: " + numUpperCase(s, 0, 0));

    }

    static int numUpperCase(String str, int idx, int count) {
        if (idx == str.length()) {
            return count;
        }
        if (Character.isUpperCase(str.charAt(idx))) {
            count++;
        }
        return numUpperCase(str, ++idx, count);
    }
}
