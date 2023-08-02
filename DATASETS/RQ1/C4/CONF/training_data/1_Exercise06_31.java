

import java.util.*;


public class Exercise06_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        String ccNum = in.next();

        System.out.println(ccNum + (isValid(Long.parseLong(ccNum)) ? " is valid." : " is invalid."));
    }

    
    public static boolean isValid(long number) {
        String s = String.valueOf(number);
        if (s.length() < 13 || s.length() > 16) {
            return false;
        } else if (prefixMatched(number, 4) || prefixMatched(number, 6) || prefixMatched(number, 5) || prefixMatched(number, 37)) {
            int sumEven = sumOfDoubleEvenPlace(number);
            int sumOdd = sumOfOddPlace(number);
            int total = sumEven + sumOdd;
            return total % 10 == 0;
        }
        return false;
    }

    
    public static int sumOfDoubleEvenPlace(long number) {
        System.out.println("Sum of Double Even Place Numbers: ");
        int sum = 0;
        String n = String.valueOf(number);
        for (int i = n.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(n.substring(i, i + 1));
            System.out.println("extracted digit:" + digit);
            int temp = digit + digit;
            int d = getDigit(temp);
            System.out.println("Digit processed into: " + d);
            sum += d;
        }
        return sum;
    }

    
    public static int getDigit(int number) {
        if (getSize(number) > 1) {
            int d1 = number % 10;
            int d2 = number / 10;
            return d1 + d2;
        }
        return number;
    }

    
    public static int sumOfOddPlace(long number) {
        System.out.println("Sum of Odd Place Numbers: ");
        int sum = 0;
        String n = String.valueOf(number);
        for (int i = n.length() - 1; i >= 0; i -= 2) {
            int x = Integer.parseInt(n.substring(i, i + 1));
            System.out.println("Extracted digit " + x);
            sum += x;
        }
        return sum;
    }

    
    public static boolean prefixMatched(long number, int d) {
        String s = String.valueOf(number);
        if (s.startsWith(String.valueOf(d))) {
            return true;
        }
        return false;
    }

    
    public static int getSize(long d) {
        String s = String.valueOf(d);
        return s.length();
    }

    
    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        }
        String s = String.valueOf(number);
        return Long.parseLong(s.substring(0, k));
    }
}