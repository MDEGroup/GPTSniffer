package ch_09.exercise09_09;


//|_____________________________UML Diagram_____________________________________|
/*																				|
 * 					   		    RegularPolygon								    |
 * _____________________________________________________________________________|
 * 																				|
 *     + n:int          (defines # of sides default 3)							|
 *     + side:double    (length of side default 1)            					|
 * 	   + x:double		  (x of center coordinate default 0)    				|
 * 	   + y:double		  (y of center coordinate default 0)    				|
 * _____________________________________________________________________________|
 *		RegularPolygon()									  					|
 *		RegularPolygon(sides:int,lengthSide:double) (at (0,0))					|
 *		RegularPolygon(sides:int,lengthSide:double,x:double,y:double) (x,y)		|
 *		getSide(): double														|
 * 	    setSide(side: double) :void												|
 *		getNumSides(): double													|
 * 		setNumSides(numSides:int) :void											|
 * 		setCenterX(newX:int) :void													|
 * 		getCenterX(): double															|
 * 		setTopLeftY(newY:int) :void													|
 * 		getCenterY(): double															|
 *  	getPerimeter()															|
 * 		getArea() : double														|
 * 																				|
 * 																				|
 * 																				|
 *______________________________________________________________________________*/



public class RegularPolygon {

    private int n;
    private double side;
    private double x;
    private double y;

    RegularPolygon() {

        n = 3;
        side = 1;
        x = 0;
        y = 0;

    }

    RegularPolygon(int numSides, double sideLength) {

        n = numSides;
        side = sideLength;

    }

    RegularPolygon(int numSides, double sideLength, double ex, double why) {

        n = numSides;
        side = sideLength;
        x = ex;
        y = why;

    }

    public void setNumSides(int newNum) {

        n = newNum;

    }

    public int getNumSides() {

        return n;
    }

    public void setSide(double newLength) {

        side = newLength;
    }

    public double getSide() {
        return side;
    }

    public void setX(int newX) {

        x = newX;
    }

    public double getX() {
        return x;

    }

    public void setY(double newY) {

        y = newY;
    }

    public double getY() {
        return y;
    }

    public double getPerimeter() {

        return n * side;

    }

    public double getArea() {

        return n * (Math.pow(side, 2) / 4 * Math.tan(Math.PI / n));
    }
}
