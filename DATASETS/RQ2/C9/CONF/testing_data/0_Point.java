public class Point implements Comparable<Point> {
    private double xCoordinate;
    private double yCoordinate;

    public Point(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public double getX() {
        return xCoordinate;
    }

    public double getY() {
        return yCoordinate;
    }

    @Override
    public int compareTo(Point other) {
        int xComparison = Double.compare(this.xCoordinate, other.xCoordinate);

        if (xComparison != 0) {
            return xComparison;
        } else {
            return Double.compare(this.yCoordinate, other.yCoordinate);
        }
    }

    @Override
    public String toString() {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }

    public static void main(String[] args) {
        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(2.0, 5.0);
        Point point3 = new Point(3.0, 2.0);

        System.out.println("Comparing points:");
        System.out.println("Point1: " + point1);
        System.out.println("Point2: " + point2);
        System.out.println("Point3: " + point3);

        int comparison1_2 = point1.compareTo(point2);
        int comparison1_3 = point1.compareTo(point3);

        System.out.println("Comparison 1 to 2: " + comparison1_2);
        System.out.println("Comparison 1 to 3: " + comparison1_3);
    }
}