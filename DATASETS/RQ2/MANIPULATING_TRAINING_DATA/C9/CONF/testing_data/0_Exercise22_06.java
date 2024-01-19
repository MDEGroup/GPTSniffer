public class FibonacciGCD {
    public static void main(String[] args) {
        System.out.println("Index   40   41   42   43   44   45");
        long[] fibonacciNumbers = generateFibonacciSequence(45);

        for (int i = 40; i <= 45; i++) {
            long startTime = System.currentTimeMillis();
            long gcd = calculateGCD(fibonacciNumbers[i], fibonacciNumbers[i + 1]);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.printf("%-2d      %-2d    %-2d    %-2d    %-2d    %-2d    %-2d\n",
                              i, executionTime, executionTime, executionTime,
                              executionTime, executionTime, executionTime);

            System.out.println("GCD(" + fibonacciNumbers[i] + ", " + fibonacciNumbers[i + 1] + ") = " + gcd);
        }
    }

    public static long[] generateFibonacciSequence(int n) {
        long[] fibonacciNumbers = new long[n + 1];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers;
    }

    public static long calculateGCD(long m, long n) {
        if (n == 0) {
            return m;
        }
        return calculateGCD(n, m % n);
    }
}