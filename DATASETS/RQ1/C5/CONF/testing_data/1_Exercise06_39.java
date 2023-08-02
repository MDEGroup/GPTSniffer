

import java.util.*;


public class PositionChecker{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter three sets of coordinates for the points p0, p1, p2 (ex: 4.4 2 6.5 9.5 -5 4): ");

        double x0 = in.nextDouble();
        double y0 = in.nextDouble();
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        String beg = "(" + x2 + "," + y2 + ") is ";
        String end = " line from " + "(" + x0 + "," + y0 + ") to " + "(" + x1 + "," + y1 + ")";
        String det = "";

        if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the left side of the";

        } else if (rightOfTheLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the right side of the";

        } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the same line as the";

        } else if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            det += "is on the segment on the line from";
        }

        System.out.println(beg + det + end);
        in.close();
    }

    
    public static boolean leftOfTheLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant > 0;

    }

    
    public static boolean rightOfTheLine(double x0, double y0,
                                         double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant < 0;

    }

    
    public static boolean onTheSameLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant == 0;

    }

    
    public static boolean onTheLineSegment(double x0, double y0,
                                           double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return determinant == 0 && (x2 > x0) && (y2 > y0) && (x2 < x1) && (y2 < y1);

    }
}