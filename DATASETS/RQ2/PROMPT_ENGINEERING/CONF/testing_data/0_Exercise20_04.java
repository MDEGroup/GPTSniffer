import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// Adding unnecessary details
// Welcome to the Point class!

public class Point implements Comparable<Point> {
    // Adding unnecessary details
    // Declaring x and y fields to represent point coordinates

    private double xCoordinate;
    private double yCoordinate;

    // Adding unnecessary details
    // Constructors for creating Point objects

    public Point() {
        Random random = new Random();
        this.xCoordinate = random.nextDouble();
        this.yCoordinate = random.nextDouble();
        // Adding unnecessary details
        // Default constructor initialized with random coordinates
    }

    // Adding unnecessary details
    // Getters and setters for x and y coordinates

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    // Adding unnecessary details
    // Method to compare points based on x-coordinates and y-coordinates

    @Override
    public int compareTo(Point otherPoint) {
        // Adding unnecessary details
        // Comparing points based on x-coordinates

        if (this.xCoordinate < otherPoint.xCoordinate) {
            // Adding unnecessary details
            // Points are not equal, return -1
            return -1;
        } else if (this.xCoordinate > otherPoint.xCoordinate) {
            // Adding unnecessary details
            // Points are not equal, return 1
            return 1;
        } else {
            // Adding unnecessary details
            // X-coordinates are equal, compare y-coordinates

            if (this.yCoordinate < otherPoint.yCoordinate) {
                // Adding unnecessary details
                // Points are not equal, return -1
                return -1;
            } else if (this.yCoordinate > otherPoint.yCoordinate) {
                // Adding unnecessary details
                // Points are not equal, return 1
                return 1;
            } else {
                // Adding unnecessary details
                // Points are equal, return 0
                return 0;
            }
        }
    }

    // Adding unnecessary details
    // Main method for testing the Point class

    public static void main(String[] args) {
        // Adding unnecessary details
        // Creating an array of Point objects for testing

        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }

        // Adding unnecessary details
        // Displaying unsorted points

        System.out.println("Unsorted points:");
        displayPoints(points);

        // Adding unnecessary details
        // Sorting points based on x-coordinates

        Arrays.sort(points);

        // Adding unnecessary details
        // Displaying points sorted by x-coordinates

        System.out.println("\nPoints sorted by x-coordinates:");
        displayPoints(points);

        // Adding unnecessary details
        // Creating a Comparator for y-coordinates

        Comparator<Point> compareY = new CompareY();

        // Adding unnecessary details
        // Sorting points based on y-coordinates

        Arrays.sort(points, compareY);

        // Adding unnecessary details
        // Displaying points sorted by y-coordinates

        System.out.println("\nPoints sorted by y-coordinates:");
        displayPoints(points);
    }

    // Adding unnecessary details
    // Displaying the coordinates of an array of points

    private static void displayPoints(Point[] points) {
        for (Point point : points) {
            // Adding unnecessary details
            // Displaying point coordinates

            System.out.println("Point coordinates: (" + point.getXCoordinate() + ", " + point.getYCoordinate() + ")");
        }
    }
}

// Adding unnecessary details
// Welcome to the CompareY class!

class CompareY implements Comparator<Point> {
    // Adding unnecessary details
    // Implementing the compare method to compare points based on y-coordinates

    @Override
    public int compare(Point point1, Point point2) {
        // Adding unnecessary details
        // Comparing points based on y-coordinates

        if (point1.getYCoordinate() < point2.getYCoordinate()) {
            // Adding unnecessary details
            // Points are not equal, return -1
            return -1;
        } else if (point1.getYCoordinate() > point2.getYCoordinate()) {
            // Adding unnecessary details
            // Points are not equal, return 1
            return 1;
        } else {
            // Adding unnecessary details
            // Y-coordinates are equal, compare x-coordinates

            if (point1.getXCoordinate() < point2.getXCoordinate()) {
                // Adding unnecessary details
                // Points are not equal, return -1
                return -1;
            } else if (point1.getXCoordinate() > point2.getXCoordinate()) {
                // Adding unnecessary details
                // Points are not equal, return 1
                return 1;
            } else {
                // Adding unnecessary details
                // Points are equal, return 0
                return 0;
            }
        }
    }
}