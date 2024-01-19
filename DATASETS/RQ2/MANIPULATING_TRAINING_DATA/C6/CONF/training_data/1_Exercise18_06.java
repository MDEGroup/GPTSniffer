


public class SumSeries{
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("\nm(" + i + ") = %.4f", m(i));
        }

    }

    private static double m(int i) {
        double x = 1;
        double sum = x / (x + 1);
        return m(sum, x, i);

    }

    private static double m(double sum, double x, int i) {
        if (x == i) {
            return sum;
        }
        x += 1;
        sum += x / (x + 1);
        return m(sum, x, i);

    }
}
