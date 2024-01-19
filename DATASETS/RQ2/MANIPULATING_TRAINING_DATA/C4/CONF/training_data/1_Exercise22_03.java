

import java.util.Scanner;


public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = scanner.nextLine();
        String res = getMatchedIndex(s1, s2);
        System.out.println(res);
        scanner.close();
    }

    private static String getMatchedIndex(String s1, String s2) {
        int i1 = 0;
        int matchLength = s2.length();
        char s2Start = s2.charAt(0);
        while (i1 < s1.length()) {
            if (s1.charAt(i1) == s2Start) { 
                String s1Sub = s1.substring(i1, i1 + matchLength);
                if (s1Sub.equals(s2)) {
                    return "matched at index " + i1;
                } else {
                    
                }
            }
            i1++;
        }
        return "s2 is not a substring of s1";
    }

}
