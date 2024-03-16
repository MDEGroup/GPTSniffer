

import java.util.*;


public class nan{
    public static void main(String[] args) {

        int nextLineCount = 8;
        for (int i = 2; i <= 1000; i++) {

            if (isPrime(i)) {
                System.out.print(i + " ");
                --nextLineCount;
                if (nextLineCount == 0) {
                    System.out.println();
                    nextLineCount = 8;
                }
            }
        }
    }

    static boolean isPrime(int n) {
        boolean notPrime = false;
        int d = 2;
        while (d <= n / 2) {
            if (n % d == 0) {
                notPrime = true;
                break;
            }
            ++d;
        }
        return !notPrime;

    }
}