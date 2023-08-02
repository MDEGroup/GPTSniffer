package ch_19;


public class Exercise19_11 {
    // Test Program
    public static void main(String[] args) {
        ComplexMatrix complexMatrix = new ComplexMatrix();
        Complex[][] m1 = new Complex[][]{
                {new Complex(1, 5), new Complex(1, 6), new Complex(1, 7)},
                {new Complex(2, 5), new Complex(1, 3), new Complex(2, 7)},
                {new Complex(3, 5), new Complex(1, 2), new Complex(3, 7)}
        };

        Complex[][] m2 = new Complex[][]{
                {new Complex(1, 6), new Complex(1, 7), new Complex(1, 8)},
                {new Complex(1, 3), new Complex(2, 7), new Complex(1, 4)},
                {new Complex(1, 2), new Complex(3, 7), new Complex(3, 8)}
        };

        Complex[][] additionResult = complexMatrix.addMatrix(m1, m2);
        ComplexMatrix.printResult(m1, m2, additionResult, '+');

        Complex[][] multipliedResult = complexMatrix.multiplyMatrix(m1, m2);
        ComplexMatrix.printResult(m1, m2, multipliedResult, '*');


    }

}


abstract class GenericMatrix<E extends Number> {
    
    protected abstract E add(E o1, E o2);

    
    protected abstract E multiply(E o1, E o2);

    
    protected abstract E zero();

    
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        // Check bounds of the two matrices
        if ((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException(
                    "The matrices do not have the same size");
        }


        E[][] result =
                (E[][]) new Number[matrix1.length][matrix1[0].length];
        // Perform addition
        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        return result;
    }

    
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        // Check bounds
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException(
                    "The matrices do not have compatible size");
        }
        // Create result matrix
        E[][] result =
                (E[][]) new Number[matrix1.length][matrix2[0].length];
        // Perform multiplication of two matrices
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j],
                            multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }
        return result;
    }

    
    public static void printResult(
            Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + m1[i][j]);
            if (i == m1.length / 2)
                System.out.print(" " + op + " ");
            else
                System.out.print(" ");
            for (int j = 0; j < m2.length; j++)
                System.out.print(" " + m2[i][j]);
            if (i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print(" ");
            for (int j = 0; j < m3.length; j++)

                System.out.print(m3[i][j] + " ");
            System.out.println();
        }
    }
}


class ComplexMatrix extends GenericMatrix<Complex> {

    @Override
    protected Complex add(Complex c1, Complex c2) {
        return new Complex(c1.add(c2));
    }

    @Override
    protected Complex multiply(Complex c1, Complex c2) {
        return new Complex(c1.multiply(c2));
    }

    @Override
    protected Complex zero() {
        return new Complex(0.0);
    }

    @Override
    public Complex[][] multiplyMatrix(Complex[][] c1s, Complex[][] c2s) {
        if (c1s[0].length != c2s.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }

        Complex[][] result = new Complex[c1s.length][c2s[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < c1s[0].length; k++) {
                    result[i][j] = add(result[i][j],
                            multiply(c1s[i][k], c2s[k][j]));
                }
            }
        }
        return result;
    }

    @Override
    public Complex[][] addMatrix(Complex[][] c1s, Complex[][] c2s) {
        if ((c1s.length != c2s.length) || (c1s[0].length != c2s[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }
        Complex[][] result = new Complex[c1s.length][c1s[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(c1s[i][j], c2s[i][j]);
            }
        }
        return result;
    }

    public static void printResult(
            Complex[][] m1, Complex[][] m2, Complex[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                System.out.print(" " + m1[i][j]);
            if (i == m1.length / 2)
                System.out.print(" " + op + " ");
            else
                System.out.print(" ");
            for (int j = 0; j < m2.length; j++)
                System.out.print(" " + m2[i][j]);
            if (i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print(" ");
            for (int j = 0; j < m3.length; j++)

                System.out.print(m3[i][j] + " ");
            System.out.println();
        }
    }

}


class Complex extends Number implements Cloneable {

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

    @Override
    public String toString() {
        return "( " + a + " + " + b + "(" + i + ")" + " )";
    }
}
