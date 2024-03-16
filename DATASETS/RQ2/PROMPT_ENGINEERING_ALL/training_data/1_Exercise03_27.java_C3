

import java.util.*;


public class Exercise03_27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a point's x- and y-coordinates: ");
        double x = in.nextDouble();
        double y = in.nextDouble();

        double x1 = 0, y1 = 0, x2 = 200, y2 = 0, x3 = 0, y3 = 100; //Vertex coordinates for the given triangle

        double Dx, Dy, minD, maxD;

        String result = "";
        double determinant = (y2 - y3) * (x1 - x3) - (x3 - x2) * (y3 - y1);
        minD = Math.min(determinant, 0);
        maxD = Math.max(determinant, 0);
        Dx = x - x3;
        Dy = y - y3;

        double a = y2 - y3 * Dx + (x3 - x2) * Dy;
        if (a < minD || a > maxD) {
            result += "The point is not in the triangle.";

        }
        double b = (y3 - y1) * Dx + (x1 - x3) * Dy;
        if (b < minD || b > maxD) {
            result += "The point is not in the triangle.";

        }
        double c = determinant - a - b;
        if (c < minD || c > maxD) {
            result += "The point is not in the triangle.";

        } else {
            result += "The point is in the triangle.";
        }
        System.out.println(result);

    }
}