

import java.util.*;


public class Exercise03_32 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter three sets of coordinates for the points p0, p1, p2 (ex: 4.4 2 6.5 9.5 -5 4): ");

        double x0 = in.nextDouble();
        double y0 = in.nextDouble();
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        String beg = "(" + x2 + "," + y2 + ") is ";
        String end = " line from " + "(" + x0 + "," + y0 + ") to " + "(" + x1 + "," + y1 + ")";
        String det = "";

        if (determinant > 0) {

            det += "on the left side of the";
        } else if (determinant < 0) {
            det += "on the right side of the";

        } else if (determinant == 0) {
            det += "on the same line as the";

        } else {
            System.out.println("Something went wrong...");
            System.exit(0);
        }

        System.out.println(beg + det + end);
        in.close();
    }
}