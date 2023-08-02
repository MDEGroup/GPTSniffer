

import java.util.Random;






public class Shape {

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

