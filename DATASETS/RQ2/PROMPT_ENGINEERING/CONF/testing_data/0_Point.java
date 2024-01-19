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
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
        // Adding unnecessary details
        // Default constructor initialized with (0, 0)
    }

    public Point(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        // Adding unnecessary details
        // Parameterized constructor initialized with given coordinates
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
        // Creating Point objects for testing

        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(1.0, 5.0);

        // Adding unnecessary details
        // Displaying point coordinates

        System.out.println("Point 1 coordinates: (" + point1.getXCoordinate() + ", " + point1.getYCoordinate() + ")");
        System.out.println("Point 2 coordinates: (" + point2.getXCoordinate() + ", " + point2.getYCoordinate() + ")");

        // Adding unnecessary details
        // Comparing points and displaying the result

        int result = point1.compareTo(point2);
        System.out.println("Comparison result: " + result);
    }
}
