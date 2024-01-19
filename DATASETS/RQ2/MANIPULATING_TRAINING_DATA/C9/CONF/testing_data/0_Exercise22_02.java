import java.util.Scanner;

public class MaxIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String maxIncreasingSubsequence = findMaxIncreasingSubsequence(input);

        System.out.println("Max Increasing Ordered Subsequence: " + maxIncreasingSubsequence);

        scanner.close();
    }

    public static String findMaxIncreasingSubsequence(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int length = input.length();
        int[] dp = new int[length];
        int maxLength = 1;
        int endIndex = 0;

        for (int i = 0; i < length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (input.charAt(i) > input.charAt(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = endIndex; i >= 0; i--) {
            if (dp[i] == maxLength) {
                result.insert(0, input.charAt(i));
                maxLength--;
            }
        }

        return result.toString();
    }
}