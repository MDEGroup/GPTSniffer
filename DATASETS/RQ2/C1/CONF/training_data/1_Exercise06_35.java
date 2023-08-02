package ch_06;

import java.util.*;


public class Exercise06_35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the side: ");
        double s = in.nextDouble();
        System.out.println("The area of the pentagon is " + area(s));
    }

    public static double area(double side) {
        return 5 * Math.pow(side, 2) / (4 * Math.tan(Math.PI / 5));

    }
}