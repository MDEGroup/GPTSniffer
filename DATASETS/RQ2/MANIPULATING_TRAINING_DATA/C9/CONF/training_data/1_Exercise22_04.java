package ch_22;


import java.util.Scanner;


public class Exercise22_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter a string s2: ");
        String s2 = scanner.nextLine();
        int result = new Exercise22_04().indexOfSubstring(s1, s2);
        if (result == -1) {
            System.out.println("s2 is not a substring of s1...");
            return;
        }

        System.out.println("matched at index " + result);
        scanner.close();
    }

    private int indexOfSubstring(String s1, String s2) {
        int index = 0;
        int matchLength = s2.length();
        char s2Start = s2.charAt(0);
        while (index < (s1.length() - matchLength)) {
            /* Try to match first char in s2 with char at next index */
            if (s1.charAt(index) == s2Start) {
                String s1Sub = s1.substring(index, index + matchLength);
                if (s1Sub.equals(s2)) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }
}
