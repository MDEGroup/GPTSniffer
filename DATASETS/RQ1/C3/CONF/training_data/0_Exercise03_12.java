import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        // create Scanner object to read input
        Scanner input = new Scanner(System.in);

        // prompt user to enter a three-digit integer
        System.out.print("Enter a three-digit integer: ");
        int number = input.nextInt();

        // extract digits from the number
        int firstDigit = number / 100;
        int lastDigit = number % 10;

        // check if number is a palindrome
        if (firstDigit == lastDigit) {
            System.out.println(number + " is a palindrome number.");
        } else {
            System.out.println(number + " is not a palindrome number.");
        }
    }
}