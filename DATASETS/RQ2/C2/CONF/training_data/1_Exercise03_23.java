

import java.util.*;


public class Exercise03_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter a point with two coordinates: ");

        double x2 = in.nextInt();
        double y2 = in.nextInt();

        double x1 = 0;
        double y1 = 0;
        double rectWidth = 10;
        double rectHeight = 5;


        String res = "";
        if (x2 <= 10.0 / 2 && y2 <= 5.0 / 2) {
            res += "is in the rectangle";
        } else {
            res += "is not in the rectangle";
        }

        System.out.println("Point (" + x2 + ", " + y2 + ") " + res + " Centered at (0,0) with a Height of 5 and " +
                "a Width of 10");

        in.close();

    }
}