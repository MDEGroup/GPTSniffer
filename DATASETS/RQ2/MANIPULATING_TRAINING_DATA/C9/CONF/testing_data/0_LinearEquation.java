/**
 * A class representing a 2x2 system of linear equations:
 * 
 * ax + by = e
 * cx + dy = f
 */
public class LinearEquation {
    // Private data fields to store the coefficients of the equations
    private double a, b, c, d, e, f;

    /**
     * Constructs a LinearEquation object with the provided coefficients.
     * 
     * @param a Coefficient for x in the first equation
     * @param b Coefficient for y in the first equation
     * @param c Coefficient for x in the second equation
     * @param d Coefficient for y in the second equation
     * @param e Constant in the first equation
     * @param f Constant in the second equation
     */
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    /**
     * Gets the coefficient 'a' for the first equation (ax + by = e).
     * 
     * @return The coefficient 'a'
     */
    public double getA() {
        return a;
    }

    /**
     * Gets the coefficient 'b' for the first equation (ax + by = e).
     * 
     * @return The coefficient 'b'
     */
    public double getB() {
        return b;
    }

    /**
     * Gets the coefficient 'c' for the second equation (cx + dy = f).
     * 
     * @return The coefficient 'c'
     */
    public double getC() {
        return c;
    }

    /**
     * Gets the coefficient 'd' for the second equation (cx + dy = f).
     * 
     * @return The coefficient 'd'
     */
    public double getD() {
        return d;
    }

    /**
     * Gets the constant 'e' in the first equation (ax + by = e).
     * 
     * @return The constant 'e'
     */
    public double getE() {
        return e;
    }

    /**
     * Gets the constant 'f' in the second equation (cx + dy = f).
     * 
     * @return The constant 'f'
     */
    public double getF() {
        return f;
    }

    /**
     * Checks if the system of linear equations is solvable.
     * It is solvable if the determinant (ad - bc) is not zero.
     * 
     * @return true if the system is solvable, false otherwise
     */
    public boolean isSolvable() {
        return (a * d - b * c) != 0;
    }

    /**
     * Calculates and returns the solution for the x variable in the system of equations.
     * 
     * @return The solution for x
     */
    public double getCenterX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    /**
     * Calculates and returns the solution for the y variable in the system of equations.
     * 
     * @return The solution for y
     */
    public double getCenterY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}