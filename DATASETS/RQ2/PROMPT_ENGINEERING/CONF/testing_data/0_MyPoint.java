public class MyPoint {

    // Data fields to represent the coordinates
    private double xCoordinate;
    private double yCoordinate;

    // A no-arg constructor that creates a point at (0, 0)
    public MyPoint() {
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
    }

    // A constructor to set the coordinates
    public MyPoint(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    // Getter methods for x and y coordinates
    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }

    // Calculate and return distance to another MyPoint
    public double distance(MyPoint otherPoint) {
        double xDiff = this.xCoordinate - otherPoint.getXCoordinate();
        double yDiff = this.yCoordinate - otherPoint.getYCoordinate();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Calculate and return distance to a point with specific coordinates
    public double distance(double x, double y) {
        double xDiff = this.xCoordinate - x;
        double yDiff = this.yCoordinate - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}