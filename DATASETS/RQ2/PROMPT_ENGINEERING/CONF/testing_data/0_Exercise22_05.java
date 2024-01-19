import java.util.Scanner;

public class LongestSameNumberSubsequenceFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Same-number Subsequence Finder!");
        System.out.println("Please enter a series of numbers ending with 0:");
        
        int[] sequence = new int[100]; // I'll just assume we won't have more than 100 numbers.
        int currentIndex = 0;
        
        int currentNumber = scanner.nextInt();
        while (currentNumber != 0) {
            sequence[currentIndex] = currentNumber;
            currentIndex++;
            currentNumber = scanner.nextInt();
        }
        
        int longestStartIndex = 0;
        int longestLength = 0;
        int currentStartIndex = 0;
        int currentLength = 1;
        
        for (int i = 1; i < currentIndex; i++) {
            if (sequence[i] == sequence[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestStartIndex = currentStartIndex;
                }
                currentStartIndex = i;
                currentLength = 1;
            }
        }
        
        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestStartIndex = currentStartIndex;
        }
        
        System.out.println("The longest same number sequence starts at index " + longestStartIndex +
                           " with " + longestLength + " values of " + sequence[longestStartIndex]);
    }
}