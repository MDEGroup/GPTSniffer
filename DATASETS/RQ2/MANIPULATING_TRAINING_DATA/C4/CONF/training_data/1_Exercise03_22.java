

import java.util.*;


public class Exercise03_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter a point with two coordinates: ");
        double x2 = in.nextInt();
        double y2 = in.nextInt();

        double x1 = 0;
        double y1 = 0;


        double distanceToZero = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        String res = "";
        if (distanceToZero <= 10) {
            res += "is in the circle";
        } else {
            res += "is not in the circle";
        }

        System.out.println("Point (" + x2 + ", " + y2 + ") " + res);


    }
}