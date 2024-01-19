package ch_10.exercise10_04;

//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  MyPoint  								|
 *------------------------------------------------------------------|
 *                     	   -x : int	                           		|
 * 															 		|
 *                         -y : int									|
 *------------------------------------------------------------------|
 *                     -MyPoint()          	    					|
 *                     -MyPoint(int, int)            		    	|
 * 	 																|
 * 					+distance(MyPoint):double	                    |
 * 						                                        	|
 * 					+distance(int,int):double						|
 *  																|
 * 																	|
 * 	                      +getCenterX() : int	    						|
 * 			    													|
 * 	                      +getCenterY() : int   							|
 * 	 																|
 * 																	|
 *__________________________________________________________________|  */



public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint point) {
        return distance(point.x, point.y);

    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


}
