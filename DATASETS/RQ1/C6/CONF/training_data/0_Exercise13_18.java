class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        int commonDenominator = this.denominator * other.denominator;
        int sumNumerator = this.numerator * other.denominator + other.numerator * this.denominator;

        return new Rational(sumNumerator, commonDenominator);
    }

    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

public class SummationSeries {
    public static void main(String[] args) {
        Rational sum = new Rational(0, 1);

        for (int i = 1; i <= 99; i++) {
            Rational term = new Rational(i, i + 1);
            sum = sum.add(term);
        }

        System.out.println("Summation series result: " + sum.toDouble());
    }
}