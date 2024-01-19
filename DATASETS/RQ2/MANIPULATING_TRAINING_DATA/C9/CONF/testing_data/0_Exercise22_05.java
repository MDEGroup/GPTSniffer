import java.util.Scanner;

public class LongestSameNumberSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of numbers ending with 0: ");

        int currentNumber = -1;
        int longestNumber = -1;
        int currentSequenceLength = 0;
        int longestSequenceLength = 0;
        int currentSequenceStartIndex = -1;
        int longestSequenceStartIndex = -1;
        int currentIndex = 0;

        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (number == currentNumber) {
                currentSequenceLength++;
            } else {
                currentNumber = number;
                currentSequenceLength = 1;
                currentSequenceStartIndex = currentIndex;
            }

            if (currentSequenceLength > longestSequenceLength) {
                longestSequenceLength = currentSequenceLength;
                longestNumber = currentNumber;
                longestSequenceStartIndex = currentSequenceStartIndex;
            }

            currentIndex++;
        }

        if (longestSequenceLength > 1) {
            System.out.println("The longest same number sequence starts at index " + longestSequenceStartIndex +
                    " with " + longestSequenceLength + " occurrences of " + longestNumber);
        } else {
            System.out.println("No repeated numbers found.");
        }

        scanner.close();
    }
}