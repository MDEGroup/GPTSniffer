package ch_22.exercise22_08;

import java.io.*;


public class Exercise22_08 {
    private static PrimeStorage primeStorage;
    private static final String[] packageParts = Exercise22_08.class.getPackage().getName().split("\\.");
    private static final String PATH = packageParts[0] + File.separator + packageParts[1] + File.separator + "PrimeNumbers.dat";
    private static long[] primeReadBuffer = new long[10000];
    private static final long UPPER_BOUND = 10_000_000_000L;
    private static boolean reachedEndOfBuffer = false;

    public static void main(String[] args) {
        try {
            primeStorage = new PrimeStorage(PATH);
            long checkNum = primeStorage.getNextNumberToCheck();
            // Check primes until reaching upper bound
            while (checkNum < UPPER_BOUND) {
                boolean isPrime = checkPrime(checkNum, primeStorage);
                if (isPrime) {
                    primeStorage.appendPrime(checkNum);
                }
                checkNum++;
            }

        } catch (Exception e) {
            System.err.println("Could not create and/or read/write file needed to store prime numbers on this device. " +
                    "Please confirm Security Manager will allow create/read/write file storage.");
            System.exit(0);
        }

    }

    private static boolean checkPrime(long checkNum, PrimeStorage primeStorage) throws IOException {
        boolean loop = true;
        boolean isPrime = true;
        primeStorage.setPosition(0);

        while (loop) {
            primeReadBuffer = primeStorage.readNextPrimes();
            boolean isDivisible = isDivisible(primeReadBuffer, checkNum);
            if (isDivisible) {
                // checkNum is not prime
                loop = false;
                isPrime = false;
                break;
            } else if (reachedEndOfBuffer) {
                loop = false;
                break;
            }
        }

        return isPrime;
    }

    public static boolean isDivisible(long[] primes, long checkNum) {
        for (long prime : primes) {
            if (prime == 0) {
                reachedEndOfBuffer = true;
                return false;
            }
            if (checkNum % prime == 0) {
                return true;
            }
        }
        return false;
    }
}
