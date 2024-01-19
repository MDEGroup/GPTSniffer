import java.math.BigInteger;

public class MersennePrimes {
    public static void main(String[] args) {
        BigInteger two = BigInteger.valueOf(2);
        for (int p = 2; p <= 100; p++) {
            BigInteger mersenne = two.pow(p).subtract(BigInteger.ONE);
            if (isPrime(mersenne)) {
                System.out.printf("M%d is prime%n", p);
            }
        }
    }
    
    public static boolean isPrime(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        if (n.compareTo(BigInteger.TWO) == 0) {
            return true;
        }
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }
        BigInteger sqrt = n.sqrt();
        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt) <= 0; i = i.add(BigInteger.TWO)) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}
