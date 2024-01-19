import java.math.BigInteger;

public class MersennePrimeFinder {

    public static void main(String[] args) {
        System.out.println("Mersenne Primes with p <= 100:");
        
        for (int p = 2; p <= 100; p++) {
            BigInteger mersenneNumber = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
            
            if (isPrime(mersenneNumber)) {
                System.out.println("Mersenne Prime for p = " + p + ": " + mersenneNumber);
            }
        }
    }

    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(num.sqrt()) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }
}