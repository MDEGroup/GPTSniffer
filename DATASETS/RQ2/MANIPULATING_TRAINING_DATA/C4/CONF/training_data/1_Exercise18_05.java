


public class Exercise18_05 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("\nm(" + i + ") = %.4f", m(i));
        }

    }

    private static double m(int target) {
        int numerator = 1;
        double sum = numerator / ((2.0 * numerator) + 1);
        return m(sum, numerator, target);
    }

    private static double m(double sum, int numerator, int target) {
        if (numerator == target) {
            return sum;
        }
        numerator++;
        sum += numerator / ((2.0 * numerator) + 1);

        return m(sum, numerator, target);
    }
}
