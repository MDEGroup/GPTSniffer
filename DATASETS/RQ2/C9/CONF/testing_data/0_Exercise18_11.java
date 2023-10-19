import java.util.Scanner;

public class DigitSumCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long number = input.nextLong();

        int sum = sumDigits(number);
        System.out.println("The sum of the digits is: " + sum);
    }

    public static int sumDigits(long n) {
        // Base case: If n is a single-digit number, return n
        if (n < 10) {
            return (int) n;
        } else {
            // Recursive case: Sum the last digit and recursively sum the remaining digits
            int lastDigit = (int) (n % 10);
            long remainingDigits = n / 10;
            int sumOfRemainingDigits = sumDigits(remainingDigits);
            return lastDigit + sumOfRemainingDigits;
        }
    }
}