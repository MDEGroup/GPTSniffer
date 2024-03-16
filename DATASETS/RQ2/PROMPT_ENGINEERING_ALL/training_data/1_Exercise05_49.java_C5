

import java.util.*;


public class VowelConsonantCounter {
    public static void main(String[] args) {
        final String vowelString = "AEIOU";

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = in.nextLine().toUpperCase();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (vowelString.contains(String.valueOf(ch))) {
                    ++vowels;
                } else {
                    ++consonants;
                }
            }
        }
        in.close();
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }
}