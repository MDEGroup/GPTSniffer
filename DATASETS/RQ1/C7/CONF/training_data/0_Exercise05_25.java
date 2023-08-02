public class Main {
    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = 0;
            for (int j = 0; j < i; j++) {
                int sign = j % 2 == 0 ? 1 : -1;
                double term = sign * (1.0 / (2 * j + 1));
                pi += term;
            }
            pi *= 4;
            System.out.println("pi for i = " + i + ": " + pi);
        }
    }
}
