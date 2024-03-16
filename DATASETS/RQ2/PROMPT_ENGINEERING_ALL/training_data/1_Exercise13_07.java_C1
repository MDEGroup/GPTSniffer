package ch_13.exercise13_07;

import java.util.Random;
//_________________________ UML DIAGRAM ____________________________*
/*																	*
 * 						  GeometricObject 							*
 *------------------------------------------------------------------*
 * -color: String													*
 * -filled: boolean													*
 * -dateCreated : java.util.Date									*
 *																	*
 *------------------------------------------------------------------*
 * 	 #GeometricObject()												*                       _____________________________________
 * 	 #GeometricObject(color:String,filled:boolean)					*                       *	        <<interface>>           *
 * 	 																*                       *             Colorable             *
 * 																	* >>>>>>>>>>>>>>>>>>>>>>*___________________________________*
 * 	+getColor(): String												*                       *	     +howToColor():void         *
 * 	+setColor(color: String): void									*                       *___________________________________*
 * 	+isFilled(): boolean											*
 * 	+setFilled(filled: boolean): void								*
 * 	+getDateCreated(): java.util.Date								*
 *  																*
 *  	+toString(): String											*
 * 	/+getArea()/: double/											*
 * 	/+getPerimeter(): double/										*
 * _________________________________________________________________| */
/*					  ^
				      ^
			    	  ^
					  ^
/*_________________UML Diagram__________________*
 *______________________________________________*
 *                   Square   	        	    *
 *______________________________________________*
 * 							  			 		*
 *  height: double								*
 *  						  					*
 * 	+Square()									*
 * 						  					    *
 *  +Square(newHeight:Double)                   *
 *  											*
 * 	getArea(): double							*
 * 	getPerimeter(): double						*
 * 												*
 * 	+toString(): String							*
 * 	+compareTo():int							*
 * 	+equals(): boolean							*
 * _____________________________________________*
 */



public class Exercise13_07 {

    static Random randomDbl = new Random();

    public static void main(String[] args) {
        GeometricObject[] test = new GeometricObject[5];
        for (int i = 0; i < test.length; i++) {
            test[i] = new Square(randomDbl.nextDouble() * 9);

        }
        for (Object object : test) {
            if (object instanceof Square) {
                Square square = (Square) object;
                System.out.println("Area = " + square.getArea() + " squared");
                System.out.println("How to color method result: ");
                square.howToColor();
            }
        }


    }
}

