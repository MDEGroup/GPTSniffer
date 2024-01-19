import java.util.Scanner;

public class IntegerSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        do {
            System.out.print("Enter the first integer: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter the first integer: ");
                scanner.next();
            }
            num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter the second integer: ");
                scanner.next();
            }
            num2 = scanner.nextInt();
        } while (num1 < Integer.MIN_VALUE/2 || num1 > Integer.MAX_VALUE/2 || num2 < Integer.MIN_VALUE/2 || num2 > Integer.MAX_VALUE/2);

        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
    }
}