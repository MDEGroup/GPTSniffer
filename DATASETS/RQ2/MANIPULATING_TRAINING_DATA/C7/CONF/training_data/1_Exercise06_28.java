


public class MersennePrimeCalculator {
    public static void main(String[] args) {
        System.out.println("p   2^p-1");
        for (int p = 2; p <= 31; p++) {
            System.out.print(mersennePrime(p));
        }
    }

    static String mersennePrime(int p) {
        int pow = 2;
        for (int i = 1; i < p; i++) {
            pow = pow * 2;
        }
        int checkNum = pow - 1;

        if (isPrime(checkNum)) {
            return p + "   " + checkNum + "\n";
        }
        return "";
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
