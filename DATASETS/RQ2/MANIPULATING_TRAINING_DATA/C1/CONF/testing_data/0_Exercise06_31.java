import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();
        input.close();
        if (isValid(number)) {
            System.out.println(number + " is valid");
        } else {
            System.out.println(number + " is invalid");
        }
    }

    public static boolean isValid(long number) {
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return sum % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        int count = 0;
        while (number > 0) {
            count++;
            if (count % 2 == 0) {
                sum += getDigit((int) (2 * (number % 10)));
            }
            number /= 10;
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        while (number > 0) {
            sum += (int) (number % 10);
            number /= 100;
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        int size = 0;
        while (d > 0) {
            size++;
            d /= 10;
        }
        return size;
    }

    public static long getPrefix(long number, int k) {
        int size = getSize(number);
        if (size < k) {
            return number;
        } else {
            long prefix = number;
            for (int i = 0; i < size - k; i++) {
                prefix /= 10;
            }
            return prefix;
        }
    }
}