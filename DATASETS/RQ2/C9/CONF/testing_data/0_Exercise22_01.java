import java.util.Scanner;

public class MaxConsecutiveIncreasingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String maxConsecutiveIncreasingSubstring = findMaxConsecutiveIncreasingSubstring(input);

        System.out.println(maxConsecutiveIncreasingSubstring);

        scanner.close();
    }

    public static String findMaxConsecutiveIncreasingSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int maxLength = 1;
        int currentLength = 1;
        int endIndex = 0;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) > input.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    endIndex = i - 1;
                }
                currentLength = 1;
            }
        }

        // Check if the last sequence is the longest
        if (currentLength > maxLength) {
            endIndex = input.length() - 1;
        }

        int startIndex = endIndex - maxLength + 1;
        return input.substring(startIndex, endIndex + 1);
    }
}