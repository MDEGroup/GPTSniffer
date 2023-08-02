
public class PrimeNumberGenerator {
    public static void main(String[] args) {
        long MAX_NUMBER = 10000000000L;
        int PRIME_CHUNK_SIZE = 10000;
        boolean[] isPrime = new boolean[(int)MAX_NUMBER];
        isPrime[0] = false;
        isPrime[1] = false;

        
        for (int i = 2; i < MAX_NUMBER; i++) {
            isPrime[i] = true;
        }

        
        for (int i = 2; i < Math.sqrt(MAX_NUMBER); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX_NUMBER; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        
        long[] primes = new long[PRIME_CHUNK_SIZE];
        int numPrimes = 0;

        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("PrimeNumbers.dat")))) {
            while (true) {
                primes[numPrimes] = inputStream.readLong();
                numPrimes++;
            }
        } catch (FileNotFoundException e) {
            
        } catch (EOFException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("PrimeNumbers.dat", true)))) {
            long start = numPrimes == 0 ? 2 : primes[numPrimes - 1] + 1;
            for (long i = start; i < MAX_NUMBER; i++) {
                if (isPrime[(int)i]) {
                    boolean isPrimeNumber = true;
                    for (int j = 0; j < numPrimes; j++) {
                        if (i % primes[j] == 0) {
                            isPrimeNumber = false;
                            break;
                        }
                    }
                    if (isPrimeNumber) {
                        primes[numPrimes] = i;
                        numPrimes++;
                        outputStream.writeLong(i);
                    }
                    if (numPrimes == PRIME_CHUNK_SIZE) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
