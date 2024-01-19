/**
 * Welcome to the FactorialCalculator program!
 * This program calculates the factorial of a number using recursion.
 * Author: [Your Name]
 */

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a non-negative integer: ");
        int userInput = scanner.nextInt();

        // Display the result
        BigInteger result = calculateFactorial(userInput);
        System.out.println("Factorial of " + userInput + ": " + result);
    }

    // Recursive method to calculate factorial
    public static BigInteger calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE; // Base case: factorial of 0 or 1 is 1
        } else {
            return BigInteger.valueOf(n).multiply(calculateFactorial(n - 1));
        }
    }
}
