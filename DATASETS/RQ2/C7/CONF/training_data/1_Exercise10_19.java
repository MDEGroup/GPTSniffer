



public class MersenneCalculator {
    static int P = 2;
    static BigInteger TWO = BigInteger.valueOf(2L);

    public static void main(String[] args) {
        System.out.print("p     2^p - 1");

        while (P <= 100) {
            BigInteger mersennePrime = TWO.pow(P).subtract(BigInteger.ONE);
            if (mersennePrime.isProbablePrime(1)) {
                System.out.print("\n" + P + "     " + mersennePrime.toString());
                System.out.println();
                P++;
            }
        }
    }

}

