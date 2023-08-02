

import java.util.Scanner;


public class LongestSubSequence{
    private void findSubsequence(String[] tokens) {
        int longest = 0;
        int longestStartIndex = 0;
        int count = 1;
        int value = 0;
        int startIndex = 0;

        for (int i = 0; i < tokens.length - 1; i++) {
            int curr = Integer.parseInt(tokens[i]);
            int next = Integer.parseInt(tokens[i + 1]);
            if (next == 0) break;
            if (curr == next) {
                count++;
                longest = Math.max(longest, count);
                if (count == longest) {
                    value = curr;
                    longestStartIndex = startIndex;
                }
            } else {
                startIndex = i + 1;
                count = 1;
            }

        }
        System.out.println("The longest same number sequence starts at index " + longestStartIndex +
                " with " + longest + " values " + "of " + value);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a series of numbers ending with 0:");
        String[] tokens = input.nextLine().split("\\s+");
        new Exercise22_05().findSubsequence(tokens);

        input.close();

    }
}
