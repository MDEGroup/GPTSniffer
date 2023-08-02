


public class Exercise13_15 {
    public static void main(String[] args) {
        //Test behavior of RationalNumCalculator number class that uses BigInteger internally
        System.out.println("Using the RationalNumCalculator class..");
        ch_13.exercise13_15.Rational r1 = new ch_13.exercise13_15.Rational(1, 123456789);
        ch_13.exercise13_15.Rational r2 = new ch_13.exercise13_15.Rational(1, 123456789);
        ch_13.exercise13_15.Rational r3 = new ch_13.exercise13_15.Rational(1, 123456789);
        System.out.println("r1 * r2 * r3 is " +
                r1.multiply(r2.multiply(r3)));
    }
}
