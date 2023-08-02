public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------|   40     41    42    43    44    45");
        System.out.println("------------------------------------------------------------------------");

        long[][] times = new long[2][6]; // to store the execution times

        for (int i = 40; i <= 45; i++) {
            long startTime = System.nanoTime();
            long gcd1 = gcd(FibonacciRecursive(i), FibonacciRecursive(i+1));
            long endTime = System.nanoTime();
            times[0][i-40] = endTime - startTime;

            startTime = System.nanoTime();
            long gcd2 = gcd(FibonacciIterative(i), FibonacciIterative(i+1));
            endTime = System.nanoTime();
            times[1][i-40] = endTime - startTime;

            System.out.printf("Fibonacci(%2d) and Fibonacci(%2d) | %6d %6d %6d %6d %6d %6d\n", i, i+1, times[0][i-40], times[0][i-39], times[0][i-38], times[0][i-37], times[0][i-36], times[0][i-35]);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Recursive algorithm: " + Arrays.toString(times[0]));
        System.out.println("Iterative algorithm: " + Arrays.toString(times[1]));
    }

    // Recursive algorithm for Fibonacci numbers
    public static long FibonacciRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return FibonacciRecursive(n-1) + FibonacciRecursive(n-2);
    }

    // Iterative algorithm for Fibonacci numbers
    public static long FibonacciIterative(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        long fibMinusTwo = 0;
        long fibMinusOne = 1;
        long fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = fibMinusOne + fibMinusTwo;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fib;
        }

        return fib;
    }

    // Euclidean algorithm for finding the greatest common divisor
    public static long gcd(long m, long n) {
        if (m % n == 0)
            return n;
        else
            return gcd(n, m % n);
    }
}