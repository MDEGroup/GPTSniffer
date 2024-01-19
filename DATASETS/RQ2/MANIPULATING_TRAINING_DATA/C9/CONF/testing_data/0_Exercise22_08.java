import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberFinder {
    private static final long MAX_NUM = 10_000_000_000L;
    private static final int SEGMENT_SIZE = 100_000;
    private static final int ARRAY_SIZE = 10_000;

    private List<Long> primes;
    private long highestPrime;

    public PrimeNumberFinder() {
        primes = new ArrayList<>();
        highestPrime = 2L; // Start from 2
    }

    public void findAndStorePrimes() {
        // Load previously stored prime numbers from PrimeNumbers.dat
        loadPrimesFromFile();

        long start = highestPrime + 1;
        long end = start + SEGMENT_SIZE;

        while (start <= MAX_NUM) {
            // Perform segmented sieve in the range [start, end]
            boolean[] isPrime = new boolean[SEGMENT_SIZE];
            Arrays.fill(isPrime, true);

            for (long prime : primes) {
                long startIdx = Math.max(start / prime, 2) * prime - start;
                for (long j = startIdx; j < SEGMENT_SIZE; j += prime) {
                    isPrime[(int) j] = false;
                }
            }

            // Add newly found primes to the list and the file
            for (int i = 0; i < SEGMENT_SIZE; i++) {
                if (isPrime[i]) {
                    long prime = start + i;
                    primes.add(prime);
                    highestPrime = prime;
                    appendPrimeToFile(prime);
                }
            }

            start = end + 1;
            end = Math.min(end + SEGMENT_SIZE, MAX_NUM);
        }
    }

    private void loadPrimesFromFile() {
        // Load previously stored primes from the binary file and initialize primes list
        // Update highestPrime accordingly
        // Handle exceptions appropriately
    }

    private void appendPrimeToFile(long prime) {
        // Append the new prime to the binary file
        // Handle exceptions appropriately
    }

    public static void main(String[] args) {
        PrimeNumberFinder primeFinder = new PrimeNumberFinder();
        primeFinder.findAndStorePrimes();
    }
}