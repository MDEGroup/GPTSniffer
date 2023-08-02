


public class Complex extends Number implements Cloneable {

    private double a;
    private double b;
    private static double i = Math.sqrt(-1);

    public Complex() {
        this(0);
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    
    public double add(Complex complex) {
        return (this.a + complex.a) + (this.b + complex.b) * i;
    }

    
    public double subtract(Complex complex) {
        return (this.a - complex.a) + (this.b - complex.b) * i;

    }

    
    public double multiply(Complex complex) {
        return (this.a * complex.a - this.b * complex.b) + ((this.b * complex.a + this.a * complex.b) * i);
    }

    
    public double divide(Complex complex) {
        return (this.a * complex.a + this.b * complex.b) / (Math.pow(complex.a, 2) + Math.pow(complex.b, 2)) + ((this.b * complex.a - this.a * complex.b) * i) / (Math.pow(complex.a, 2) + Math.pow(complex.b, 2));
    }

    public double abs(Complex complex) {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b * i;
    }

    @Override
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();

    }

    @Override
    public int intValue() {
        return (int) Math.round(a + b * i);
    }

    @Override
    public long longValue() {
        return Math.round(a + b * i);
    }

    @Override
    public float floatValue() {
        return (float) (a + b * i);
    }

    @Override
    public double doubleValue() {
        return a + b * i;
    }
}
