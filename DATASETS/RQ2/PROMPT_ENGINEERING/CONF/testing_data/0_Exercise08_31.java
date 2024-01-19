import java.util.Scanner;

public class IntersectingPointCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] points = new double[4][2];

        System.out.print("Enter x1 and y1: ");
        points[0][0] = input.nextDouble();
        points[0][1] = input.nextDouble();

        System.out.print("Enter x2 and y2: ");
        points[1][0] = input.nextDouble();
        points[1][1] = input.nextDouble();

        System.out.print("Enter x3 and y3: ");
        points[2][0] = input.nextDouble();
        points[2][1] = input.nextDouble();

        System.out.print("Enter x4 and y4: ");
        points[3][0] = input.nextDouble();
        points[3][1] = input.nextDouble();

        double[] intersectingPoint = calculateIntersectingPoint(points);

        if (intersectingPoint != null) {
            System.out.println("The intersecting point is at (" + intersectingPoint[0] + ", " + intersectingPoint[1] + ")");
        } else {
            System.out.println("The lines are parallel. No intersecting point exists.");
        }

        input.close();
    }

    public static double[] calculateIntersectingPoint(double[][] points) {
        double x1 = points[0][0];
        double y1 = points[0][1];
        double x2 = points[1][0];
        double y2 = points[1][1];
        double x3 = points[2][0];
        double y3 = points[2][1];
        double x4 = points[3][0];
        double y4 = points[3][1];

        double a = y1 - y2;
        double b = x2 - x1;
        double c = y3 - y4;
        double d = x4 - x3;
        double e = a * x1 + b * y1;
        double f = c * x3 + d * y3;

        double determinant = a * d - b * c;

        if (determinant == 0) {
            return null; // Lines are parallel
        } else {
            double[] intersectingPoint = new double[2];
            intersectingPoint[0] = (e * d - b * f) / determinant;
            intersectingPoint[1] = (a * f - e * c) / determinant;
            return intersectingPoint;
        }
    }
}