import java.util.Scanner;

// Welcome to the DigitSumCalculator program!

public class DigitSumCalculator {

    public static void main(String[] args) {
        // Prompting the user to enter an integer
        System.out.print("Enter an integer: ");

        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Reading the entered integer
        long number = scanner.nextLong();

        // Calculating and displaying the sum of the digits
        int sum = sumDigits(number);
        System.out.println("The sum of the digits is: " + sum);

        // Closing the Scanner
        scanner.close();
    }

    // Recursive method to compute the sum of the digits in an integer
    public static int sumDigits(long n) {
        // Base case: if the number is a single digit, return the number
        if (n < 10) {
            return (int) n;
        } else {
            // Recursive case: sum the last digit and call the method with the remaining digits
            return (int) (n % 10) + sumDigits(n / 10);
        }
    }
}