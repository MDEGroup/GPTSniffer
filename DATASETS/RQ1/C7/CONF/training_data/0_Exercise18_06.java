public class SumSeries {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            double result = sumSeries(i);
            System.out.printf("m(%d) = %.2f%n", i, result);
        }
    }

    public static double sumSeries(int i) {
        if (i == 1) {
            return 1.0 / 2.0;
        } else {
            return i / (double)(i + 1) + sumSeries(i - 1);
        }
    }
}
