public class PiApproximation {

    public static void main(String[] args) {
        double result1 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
        double result2 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);

        System.out.println("Approximation 1 of Pi: " + result1);
        System.out.println("Approximation 2 of Pi: " + result2);
    }
}