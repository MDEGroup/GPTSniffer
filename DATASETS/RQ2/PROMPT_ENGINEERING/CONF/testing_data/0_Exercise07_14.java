import java.util.Scanner;

public class GCDCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter five numbers: ");
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        int result = gcd(numbers);
        System.out.println("The gcd of the numbers is: " + result);
        
        scanner.close();
    }

    public static int gcd(int... numbers) {
        if (numbers.length == 0) {
            return 0; // No numbers, gcd is 0
        }

        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = findGCD(result, numbers[i]);
        }
        return result;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}