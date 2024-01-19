public class FibonacciGCD {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println("| Index |   40   |   41   |   42   |   43   |   44   |   45   |");
        System.out.println("-------------------------------------------------------");
        System.out.print("| GCD   |");

        // Loop through Fibonacci indices from 40 to 45
        for (int i = 40; i <= 45; i++) {
            long startTime;
            long endTime;
            long executionTime;

            // Calculate GCD using Listing 22.3 (GCD) algorithm
            startTime = System.currentTimeMillis();
            long gcd = findGCDListing22_3(i);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.print("  " + gcd + "  |");

            // Calculate GCD using Listing 22.4 (GCDEuclid) algorithm
            startTime = System.currentTimeMillis();
            long euclidGCD = findGCDEuclidListing22_4(i);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.print("  " + euclidGCD + "  |");
        }

        System.out.println("\n-------------------------------------------------------");
    }

    // Listing 22.3 GCD algorithm
    public static long findGCDListing22_3(int n) {
        if (n <= 1) {
            return 1;
        }
        return findGCDListing22_3(n - 1) + findGCDListing22_3(n - 2);
    }

    // Listing 22.4 GCDEuclid algorithm
    public static long findGCDEuclidListing22_4(int n) {
        if (n <= 1) {
            return 1;
        }
        return gcd(n, n - 1);
    }

    // Find GCD of two numbers using Euclid's algorithm
    public static long gcd(long m, long n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}