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
            return String.format("%.2f", this.realPart);
        } else if (this.imaginaryPart < 0) {
            return String.format("%.2f - %.2fi", this.realPart, -this.imaginaryPart);
        } else {
            return String.format("%.2f + %.2fi", this.realPart, this.imaginaryPart);
        }
    }

    public static void main(String[] args) {
        // Test program can be added here
    }
}
