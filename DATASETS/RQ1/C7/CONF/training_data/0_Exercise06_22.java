public class SqrtApproximation {
    public static void main(String[] args) {
        long n = 144;
        double sqrtN = sqrt(n);
        System.out.printf("The square root of %d is approximately %.4f\n", n, sqrtN);
    }

    public static double sqrt(long n) {
        double lastGuess = 1.0;
        double nextGuess = (lastGuess + n / lastGuess) / 2.0;
        while (Math.abs(nextGuess - lastGuess) > 0.0001) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2.0;
        }
        return nextGuess;
    }
}
