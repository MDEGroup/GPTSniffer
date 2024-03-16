import java.util.Scanner;public class SubstringMatcher {    public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);        // Welcome message        System.out.println("Welcome to the Substring Matcher!");                // Prompt for the first string        System.out.print("Enter a string s1: ");        String s1 = scanner.nextLine();        // Prompt for the second string        System.out.print("Enter a string s2: ");        String s2 = scanner.nextLine();        int s1Length = s1.length();        int s2Length = s2.length();        int matchIndex = -1; // Initialize matchIndex to -1 (not found)        // Iterate through s1 to find s2        for (int i = 0; i <= s1Length - s2Length; i++) {            // Check if s2 is a substring starting from position i in s1            boolean isSubstring = true;            for (int j = 0; j < s2Length; j++) {                if (s1.charAt(i + j) != s2.charAt(j)) {                    isSubstring = false;                    break;                }            }            if (isSubstring) {                matchIndex = i;                break;            }                        // Additional efficiency: Fast-forward if neighboring characters are distinct            if (j < s2Length - 1) {                char nextChar = s2.charAt(j + 1);                int nextIndex = s1.indexOf(nextChar, i + 1);                if (nextIndex != -1) {                    i = nextIndex - 1;                } else {                    break;                }            }        }        // Display the result        if (matchIndex != -1) {            System.out.println("matched at index " + matchIndex);        } else {            System.out.println("s2 is not a substring of s1");        }        // Time complexity analysis        System.out.println("__________________________________________________________________________________________");        System.out.println("------------------------------- Time Complexity Analysis ---------------------------------");        System.out.println("__________________________________________________________________________________________");        System.out.println("Time complexity is: O(n) (Linear Time)");        System.out.println("If s1.length is " + s1Length + " and s2.length is " + s2Length + ":");        System.out.println("Worst case is that the loop will execute over all values of s1 and check if index");        System.out.println("of s1 matches the starting char in s2.");        System.out.println("T(n) = " + s1Length + " * (s1 String loop) = O(n)");        System.out.println("So, Time complexity is O(n) because");        System.out.println("as the length of the input grows, the time will increase at a linear rate");        System.out.println("based on the size of s1.");        System.out.println("The size of s2 is not relevant to time complexity because we iterate based on the length of s1.");        System.out.println("__________________________________________________________________________________________");                // Additional efficiency explanation        System.out.println("--------------------------------- Additional efficiency ---------------------------------");        System.out.println("This could be made more efficient by utilizing the constraint of neighboring characters must be");        System.out.println("distinct, by performing a fast-forward after a negative match on s1 substring and s2, you move s1's index pointer");        System.out.println("forward to the next possible match for s2 starting character before resuming the loop.");        System.out.println("Fast-forwarding would result in better time complexity of O(n/m) where n is the length of s1 and m is the length of s2;");        System.out.println("__________________________________________________________________________________________");    }}