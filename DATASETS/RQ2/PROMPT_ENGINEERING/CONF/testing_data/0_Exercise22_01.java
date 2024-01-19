import java.util.Scanner;

public class MaxConsecutiveSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Max Consecutive Increasing Substring Finder!");
        
        // Prompt for the input string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        int inputLength = inputString.length();

        String maxConsecutiveSubstring = "";
        String currentSubstring = "";

        // Iterate through the input string to find the maximum consecutive substring
        for (int i = 0; i < inputLength; i++) {
            currentSubstring = "" + inputString.charAt(i);

            // Check for consecutive increasing characters
            for (int j = i + 1; j < inputLength; j++) {
                if (inputString.charAt(j) > inputString.charAt(j - 1)) {
                    currentSubstring += inputString.charAt(j);
                } else {
                    break; // Stop if not increasing
                }
            }

            // Update the maximum consecutive substring
            if (currentSubstring.length() > maxConsecutiveSubstring.length()) {
                maxConsecutiveSubstring = currentSubstring;
            }
        }

        // Display the result
        System.out.println("The maximum consecutive increasing substring is: " + maxConsecutiveSubstring);

        // Time complexity analysis
        System.out.println("__________________________________________________________________________________________");
        System.out.println("------------------------------- Time Complexity Analysis ---------------------------------");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("If input string is length " + inputLength + ":");
        System.out.println("---- T(n) = " + inputLength + " * (input string loop) * (substring loop) = O(n^2) -----");
        System.out.println("Time complexity is O(n^2).");
        System.out.println("As the length of the input grows, the time complexity will grow");
        System.out.println("exponentially because we use an inner loop to traverse each");
        System.out.println("sub-string of the input string.");
        System.out.println("__________________________________________________________________________________________");
    }
}
