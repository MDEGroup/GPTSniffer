package ch_06;

import java.util.*;


public class Exercise06_29 {
    public static void main(String[] args) {
        int[] primes = new int[1000];
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                primes[i] = 1;
            }
        }

        int[][] twinPrimes = new int[1000][2];
        for (int i = 2, j = 0; i < primes.length; i++) {
            if (primes[i] > 0) {
                twinPrimes[j] = twinPrime(primes, i);
                if (twinPrimes[j][0] > 1) {
                    j++;
                }
            }
        }
        for (int i = 0; i < twinPrimes.length; i++) {
            if (twinPrimes[i][0] == 0) break;
            System.out.println(Arrays.toString(twinPrimes[i]));

        }

    }

    static boolean isPrime(int num) {
        boolean prime = true;
        for (int i = 2; i <= (num / 2); i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    static int[] twinPrime(int[] primes, int prime) {
        if (primes[prime + 2] > 0) {
            return new int[]{prime, prime + 2};
        }
        return new int[]{0, 0};
    }
}