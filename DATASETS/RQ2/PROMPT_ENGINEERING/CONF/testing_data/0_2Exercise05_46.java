import java.util.Scanner;

public class ReverseStringProgram {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Welcome to the String Reverser Program!");
        System.out.print("Please enter a string: ");

        String inputString = userInputScanner.nextLine();
        char[] characters = inputString.toCharArray();

        System.out.print("The reversed string is: ");
        for (int i = characters.length - 1; i >= 0; i--) {
            System.out.print(characters[i]);
        }

        System.out.println(); // Adding a new line for better output appearance

        userInputScanner.close();
    }
}