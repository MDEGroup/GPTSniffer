package ch_11.exercise11_01;

import java.util.Scanner;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						 GeometricObject							|
 *-------------------------------------------------------------------|
 *    -color: String													|
 *    -filled: boolean												|
 *    -dateCreated: java.util.Date									|
 *    																|
 *																	|
 *-------------------------------------------------------------------|
 * 	 +GeometricObject()												|
 * 	 																|
 * 	 +GeometricObject(color: String, filled: boolean)				|
 * 																	|
 * 	 +getColor(): String  											|
 * 	 																|
 * 	 +setColor(color: String): void									|
 *  																	|
 *    +isFilled(): boolean											|
 * 																	|
 * 	 +setFilled(filled: boolean): void								|
 * 																	|
 *  	+getDateCreated(): java.util.Date								|
 * 																	|
 * 	+toString(): String												|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * __________________________________________________________________|  */

/*_________________________________________________________________
|					     GeometricObject						   |  
|__________________________________________________________________|
								^
								|
 __________________________UML DIAGRAM______________________________
/*																	|																															
* 							  Triangle2D 								|
*-------------------------------------------------------------------|
* 	-side1 : double													|
* 																	|	
*   -side2 : double													|
* 																	|
* 	-side3 : double													|
* 																	|											
*-------------------------------------------------------------------|
* 	 +Triangle2D()													|
* 	 																|
* 	 +Triangle2D(side1:double,side2: double,side3:double)				|
* 																	|
* 	 +getSide1 : double												|
*    +getSide2 : double												|
*    +getSide3 : double												|
*																	| 
* 																	|
* 	 +getArea() : double											|
* 	 +getPerimeter() : double										|
* 																	|
* 	 																|
* 	+toString() : String ("Triangle2D: side1 = " + side1 + 			|
* 		" side2 = " + side2 + "  side3 = " + side3)					|			 																	
* 																	|	
*___________________________________________________________________|  */



public class Exercise11_01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three sides of the triangle:");

        double one = input.nextDouble();
        double two = input.nextDouble();
        double three = input.nextDouble();

        Triangle triangle = new Triangle(one, two, three);

        System.out.print("What color is the triangle?");

        String color = input.next();

        System.out.print("Is the triangle filled? (Enter Yes or No):");

        String fill = input.next();

        triangle.setColor(color);

        boolean filled;

        filled = !"No".matches(fill);

        triangle.setFilled(filled);

        System.out.println("For " + triangle.toString() + " the area is " + triangle.getArea()
                + " square units, " + "\nThe perimeter is " + triangle.getPerimeter());

        System.out.println("The current color is " + triangle.getColor() + " \nAnd "
                + "is the triangle filled is: " + triangle.isFilled());

        input.close();
    }
}




