import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class ConvexHull {
    public static ArrayList<Point2D> findConvexHull(double[][] points) {
        ArrayList<Point2D> convexHull = new ArrayList<>();
        int pointCount = points.length;

        if (pointCount < 3) {
            // Convex hull not possible with less than 3 points
            return convexHull;
        }

        int startingPointIndex = findStartingPointIndex(points);
        int currentPointIndex = startingPointIndex;

        do {
            convexHull.add(createPoint2DFromCoordinates(points[currentPointIndex]));

            int nextPointIndex = findNextPointIndex(points, currentPointIndex);
            currentPointIndex = nextPointIndex;
        } while (currentPointIndex != startingPointIndex);

        return convexHull;
    }

    private static int findStartingPointIndex(double[][] points) {
        int startPointIndex = 0;
        int pointCount = points.length;

        for (int i = 1; i < pointCount; i++) {
            if (isSmallerPoint(points[i], points[startPointIndex])) {
                startPointIndex = i;
            }
        }

        return startPointIndex;
    }

    private static boolean isSmallerPoint(double[] point1, double[] point2) {
        if (point1[1] < point2[1] || (point1[1] == point2[1] && point1[0] < point2[0])) {
            return true;
        }
        return false;
    }

    private static int findNextPointIndex(double[][] points, int currentPointIndex) {
        int nextPointIndex = (currentPointIndex + 1) % points.length;

        for (int i = 0; i < points.length; i++) {
            if (isCounterClockwise(points[currentPointIndex], points[i], points[nextPointIndex])) {
                nextPointIndex = i;
            }
        }

        return nextPointIndex;
    }

    private static boolean isCounterClockwise(double[] point1, double[] point2, double[] point3) {
        double val = (point2[1] - point1[1]) * (point3[0] - point2[0]) -
                     (point2[0] - point1[0]) * (point3[1] - point2[1]);

        if (val == 0) {
            return false; // Collinear
        } else if (val > 0) {
            return true; // Counterclockwise
        } else {
            return false; // Clockwise
        }
    }

    private static Point2D createPoint2DFromCoordinates(double[] coordinates) {
        return new Point2D.Double(coordinates[0], coordinates[1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int pointCount = input.nextInt();

        double[][] points = new double[pointCount][2];
        System.out.print("Enter " + pointCount + " points: ");
        for (int i = 0; i < pointCount; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        ArrayList<Point2D> convexHull = findConvexHull(points);

        System.out.println("The convex hull is:");
        for (Point2D point : convexHull) {
            System.out.println("(" + point.getX() + ", " + point.getY() + ")");
        }
    }
}