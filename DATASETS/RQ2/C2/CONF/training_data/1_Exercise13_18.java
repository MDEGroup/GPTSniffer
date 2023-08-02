

import ch_13.exercise13_15.Rational;


public class Exercise13_18 {
    public static void main(String[] args) {
        Rational resultRational = new Rational();
        long i = 2;
        while (i <= 100) {
            Rational rational = new Rational(i - 1, i);
            System.out.print(rational.getNumerator() + "/" + rational.getDenominator());

            if (i == 100) System.out.print(" = ");
            else if (i % 10 == 0) System.out.println(" + ");
            else System.out.print(" + ");

            resultRational = resultRational.add(rational);
            i++;
        }
        System.out.println(resultRational.getNumerator() + " / " + resultRational.getDenominator());

    }
}
