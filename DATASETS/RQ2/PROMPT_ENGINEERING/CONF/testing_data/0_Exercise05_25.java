public class PiApproximation {

    public static void main(String[] args) {
        int terms = 10000;
        double piApproximation = 0;

        for (int i = 1; i <= terms; i++) {
            double term = 4.0 * (1 - (i % 2) * 2) / (2 * i - 1);
            piApproximation += term;
        }

        System.out.println("Approximation of pi for " + terms + " terms: " + piApproximation);
    }
}