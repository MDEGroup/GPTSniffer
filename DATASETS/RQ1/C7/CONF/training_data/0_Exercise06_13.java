public class SumSeries {
    public static void main(String[] args) {
        System.out.println("i\tm(i)");
        System.out.println("-------------------");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d\t%.4f\n", i, sumSeries(i));
        }
    }

    public static double sumSeries(int i) {
        double sum = 0.0;
        for (int j = 1; j <= i; j++) {
            sum += (double) j / (j + 1);
        }
        return sum;
    }
}
