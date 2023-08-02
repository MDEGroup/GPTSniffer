import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter a three-digit integer: ");
        int number = input.nextInt();

        
        int firstDigit = number / 100;
        int lastDigit = number % 10;

        
        if (firstDigit == lastDigit) {
            System.out.println(number + " is a palindrome number.");
        } else {
            System.out.println(number + " is not a palindrome number.");
        }
    }
}