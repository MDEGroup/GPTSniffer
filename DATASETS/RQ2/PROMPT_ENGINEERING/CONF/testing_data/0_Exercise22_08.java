import java.io.*;
import java.util.ArrayList;

public class PrimeNumberFinder {

    public static void main(String[] args) {
        // Define the upper limit for prime numbers
        long upperLimit = 10_000_000_000L;

        // Create an array to store prime numbers
        ArrayList<Long> primes = new ArrayList<>();

        // Read existing prime numbers from the data file, if any
        try {
            FileInputStream fileIn = new FileInputStream("PrimeNumbers.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            primes = (ArrayList<Long>) objIn.readObject();
            objIn.close();
        } catch (FileNotFoundException e) {
            // File doesn't exist, initialize with initial prime
            primes.add(2L);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Start finding new prime numbers
        for (long num = primes.get(primes.size() - 1) + 1; num <= upperLimit; num++) {
            boolean isPrime = true;

            // Check if num is divisible by any prime number in the list
            for (Long prime : primes) {
                if (prime * prime > num) {
                    break;
                }
                if (num % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(num);

                // Check if it's time to write primes to the file
                if (primes.size() % 10_000 == 0) {
                    savePrimesToFile(primes);
                }
            }
        }

        // Save the final list of prime numbers to the file
        savePrimesToFile(primes);
    }

    // Save the list of prime numbers to the data file
    private static void savePrimesToFile(ArrayList<Long> primes) {
        try {
            FileOutputStream fileOut = new FileOutputStream("PrimeNumbers.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(primes);
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}