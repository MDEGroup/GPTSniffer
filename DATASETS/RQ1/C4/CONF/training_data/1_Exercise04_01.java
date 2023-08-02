

import java.util.Scanner;


public class Exercise04_01 {
    public static void main(String[] args) {

        double r, s, area;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length from the center of the pentagon"
                + " to the vertex: ");

        r = input.nextDouble();

        s = 2 * r * Math.sin(Math.PI / 5);

        area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));

        System.out.printf("The area of the pentagon is: %2.2f ", area);


    }

}