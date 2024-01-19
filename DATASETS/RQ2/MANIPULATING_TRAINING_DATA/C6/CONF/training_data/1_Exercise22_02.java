

import java.util.Scanner;


public class MaximumIncreasingSubsequence{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.next().trim();
        String result = "";
        char lastSeqChar = input.charAt(0);
        
        for (int j = 1; j < input.length(); j++) {
            if (lastSeqChar < input.charAt(j)) {
                result += lastSeqChar + "";
                lastSeqChar = input.charAt(j);
            }
        }
        result += lastSeqChar;
        System.out.println(result);

        in.close();
    }
}
