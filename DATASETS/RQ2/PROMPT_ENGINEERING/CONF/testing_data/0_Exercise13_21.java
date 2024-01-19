import java.util.Scanner;

public class VertexFormEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a, b, c in standard form (y = ax^2 + bx + c): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double h = -b / (2.0 * a);
        double k = a * Math.pow(h, 2) + b * h + c;

        System.out.println("h is " + formatFraction(h) + " k is " + formatFraction(k));
    }

    // Format a double as a fraction if possible.
    private static String formatFraction(double value) {
        String fraction = "";

        if (value % 1 == 0) {
            fraction = Integer.toString((int) value);
        } else {
            int numerator = (int) (value * 100);
            int denominator = 100;
            int gcd = gcd(numerator, denominator);

            numerator /= gcd;
            denominator /= gcd;

            if (denominator == 1) {
                fraction = Integer.toString(numerator);
            } else {
                fraction = numerator + "/" + denominator;
            }
        }
        return fraction;
    }

    // Find the greatest common divisor (GCD) using Euclidean algorithm.
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}