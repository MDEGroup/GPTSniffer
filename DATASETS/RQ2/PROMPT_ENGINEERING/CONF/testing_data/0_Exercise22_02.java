import java.util.Scanner;

public class MaxIncreasingSubsequenceFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Max Increasing Subsequence Finder!");
        System.out.print("Please enter a string: ");
        
        String inputString = scanner.nextLine();
        int length = inputString.length();
        String maxIncreasingSubsequence = ""; // We'll store the result here.
        
        for (int i = 0; i < length; i++) {
            char currentChar = inputString.charAt(i);
            StringBuilder subsequence = new StringBuilder();
            subsequence.append(currentChar);
            
            for (int j = i + 1; j < length; j++) {
                if (inputString.charAt(j) > currentChar) {
                    subsequence.append(inputString.charAt(j));
                    currentChar = inputString.charAt(j);
                }
            }
            
            if (subsequence.length() > maxIncreasingSubsequence.length()) {
                maxIncreasingSubsequence = subsequence.toString();
            }
        }
        
        System.out.println("The maximum increasingly ordered subsequence is: " + maxIncreasingSubsequence);
        
        // Time complexity analysis:
        System.out.println("__________________________________________________________________________________________");
        System.out.println("------------------------------- Time Complexity Analysis ---------------------------------");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Time complexity is: O(n) (Linear Time)");
        System.out.println("For example:");
        System.out.println("If input string is length " + length + ":");
        System.out.println("---- T(n) = " + length + " * (input string loop) = O(n) -----");
        System.out.println("So, Time complexity is O(n) because");
        System.out.println("as the length of the input grows, the time will increase at a linear rate");
        System.out.println("based on the size of the input.");
        System.out.println("__________________________________________________________________________________________");
    }
}