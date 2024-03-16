package ch_09.exercise09_10;


//|_______________________UML Diagram________________________|
/*														   	 |
 * 			   		  QuadraticEquation		        		 |
 * __________________________________________________________|
 * 												   		     |
 *        			- a:double                               |
 * 	   	 			- b:double                               |
 * 	   	 			- c:double                               |
 * __________________________________________________________|
 *		QuadraticEquation(a:double,b:double,c:double)	     |
 *		getRoot1(): double								     |
 * 	    getRoot2(): double								     |
 *		getDiscriminant(): double							 |
 * 		getA(): double										 |
 * 		getB(): double										 |
 * 		getC(): double  ss									 |
 * 															 |
 *___________________________________________________________*/



public class QuadraticEquation {
    /*  ■ Private data fields a, b, and c that represent three coefficients.*/
    private double a;
    private double b;
    private double c;

    /* ■ A constructor for the arguments for a, b, and c. */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* ■ The methods named getRoot1() and getRoot2() for returning two roots of the equation */
    protected double getRoot1() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
    }

    protected double getRoot2() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
    }

    /* ■ A method named getDiscriminant() that returns the discriminant, which is b2 - 4ac.*/
    protected double getDiscriminant() {
        return (b * 2) - (4 * a * c);
    }


    /* ■ Three getter methods for a, b, and c. */
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


}
