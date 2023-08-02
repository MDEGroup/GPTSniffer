

import java.util.Scanner;


public class Exercise22_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.next().trim();
        String result = "";
        char lastSeqChar = input.charAt(0);
        /* Loop always executes one time, so growth rate of time is constant as the input string gets larger */
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
