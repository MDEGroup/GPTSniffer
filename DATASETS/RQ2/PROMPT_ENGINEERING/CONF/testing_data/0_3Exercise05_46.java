import java.util.Scanner;

// A program to reverse a string entered by the user
public class StringReverser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Please enter a string: ");
        String userInput = scanner.nextLine();

        // Convert the string to a character array
        char[] charArray = userInput.toCharArray();

        // Create a new array to store the reversed characters
        char[] reversedArray = new char[charArray.length];

        // Reverse the string using a for loop
        for (int i = charArray.length - 1, j = 0; i >= 0; i--, j++) {
            reversedArray[j] = charArray[i];
        }

        // Display the reversed string
        System.out.print("The reversed string is: ");
        for (char reversedChar : reversedArray) {
            System.out.print(reversedChar);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}