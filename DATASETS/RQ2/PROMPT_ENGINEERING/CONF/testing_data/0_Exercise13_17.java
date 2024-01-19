import java.util.Scanner;

public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex(double realPart) {
        this.realPart = realPart;
        this.imaginaryPart = 0.0;
    }

    public Complex() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public Complex add(Complex complex) {
        double newRealPart = this.realPart + complex.getRealPart();
        double newImaginaryPart = this.imaginaryPart + complex.getImaginaryPart();
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex subtract(Complex complex) {
        double newRealPart = this.realPart - complex.getRealPart();
        double newImaginaryPart = this.imaginaryPart - complex.getImaginaryPart();
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex multiply(Complex complex) {
        double newRealPart = (this.realPart * complex.getRealPart()) - (this.imaginaryPart * complex.getImaginaryPart());
        double newImaginaryPart = (this.realPart * complex.getImaginaryPart()) + (this.imaginaryPart * complex.getRealPart());
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex divide(Complex complex) {
        double divisor = Math.pow(complex.getRealPart(), 2) + Math.pow(complex.getImaginaryPart(), 2);
        double newRealPart = ((this.realPart * complex.getRealPart()) + (this.imaginaryPart * complex.getImaginaryPart())) / divisor;
        double newImaginaryPart = ((this.imaginaryPart * complex.getRealPart()) - (this.realPart * complex.getImaginaryPart())) / divisor;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2));
    }

    @Override
    public String toString() {
        if (this.imaginaryPart == 0) {
            return String.format("%.1f", this.realPart);
        } else if (this.imaginaryPart < 0) {
            return String.format("%.1f - %.1fi", this.realPart, -this.imaginaryPart);
        } else {
            return String.format("%.1f + %.1fi", this.realPart, this.imaginaryPart);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first complex number: ");
        double realPart1 = scanner.nextDouble();
        double imaginaryPart1 = scanner.nextDouble();

        System.out.print("Enter the second complex number: ");
        double realPart2 = scanner.nextDouble();
        double imaginaryPart2 = scanner.nextDouble();

        Complex complex1 = new Complex(realPart1, imaginaryPart1);
        Complex complex2 = new Complex(realPart2, imaginaryPart2);

        System.out.println(complex1 + " + " + complex2 + " = " + complex1.add(complex2));
        System.out.println(complex1 + " - " + complex2 + " = " + complex1.subtract(complex2));
        System.out.println(complex1 + " * " + complex2 + " = " + complex1.multiply(complex2));
        System.out.println(complex1 + " / " + complex2 + " = " + complex1.divide(complex2));
        System.out.println("|" + complex1 + "| = " + complex1.abs());
    }
}