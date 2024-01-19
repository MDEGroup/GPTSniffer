import java.awt.Point;

public class Pair {
    private Point point1;
    private Point point2;

    // Constructor to initialize the Pair with two points
    public Pair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    // Method to calculate and return the distance between point1 and point2
    public double getDistance() {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point2.getX();
        double y2 = point2.getY();

        // Calculate the Euclidean distance using the distance formula
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        return distance;
    }

    public static void main(String[] args) {
        // Example usage
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);

        Pair pair = new Pair(point1, point2);
        double distance = pair.getDistance();

        System.out.println("Distance between point1 and point2: " + distance);
    }
}