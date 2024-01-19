package ch_13.exercise13_21;

import java.util.Scanner;


public class Exercise13_21 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter a, b, c (as integers): ");
            /* a,b,c as integers in Standard Form */
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Rational aRational = new Rational(a); // Constructs Rational with denominator of 1 as default
            Rational bRational = new Rational(b); // Constructs Rational with denominator of 1 as default
            Rational cRational = new Rational(c); // Constructs Rational with denominator of 1 as default
            Rational h = new Rational(bRational.multiply(new Rational(-1)).longValue(),
                    aRational.multiply(new Rational(2)).longValue());
            Rational k = aRational.multiply(h.multiply(h)).add(bRational.multiply(h)).add(cRational);
            System.out.println("h is " + h + ", k is " + k);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
