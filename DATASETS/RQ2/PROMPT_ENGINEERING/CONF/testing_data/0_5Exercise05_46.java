import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the String Reverser Program!");

        // Create a Scanner object to get user input
        Scanner userInputScanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Please enter a string: ");
        String userString = userInputScanner.nextLine();

        // Display the string in reverse order
        System.out.print("The reverse of the string is: ");
        for (int i = userString.length() - 1; i >= 0; i--) {
            System.out.print(userString.charAt(i));
        }

        // Close the Scanner
        userInputScanner.close();
    }
}