public class RationalSumSeries {

    public static void main(String[] args) {
        Rational sum = new Rational(0, 1);

        for (int i = 1; i <= 99; i++) {
            Rational term = new Rational(i, i + 1);
            sum = sum.add(term);
        }

        System.out.println("The summation series result is: " + sum.toDouble());
    }

    static class Rational {
        int numerator;
        int denominator;

        Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        double toDouble() {
            return (double) numerator / denominator;
        }

        Rational add(Rational other) {
            int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return new Rational(newNumerator, newDenominator);
        }
    }
}
