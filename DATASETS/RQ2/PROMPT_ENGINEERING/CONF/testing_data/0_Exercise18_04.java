public class SumSeries {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            double result = computeSeries(i);
            System.out.println("m(" + i + ") = " + result);
        }
    }

    public static double computeSeries(int i) {
        if (i == 1) {
            return 1;
        } else {
            double currentTerm = 1.0 / i;
            return currentTerm + computeSeries(i - 1);
        }
    }
}