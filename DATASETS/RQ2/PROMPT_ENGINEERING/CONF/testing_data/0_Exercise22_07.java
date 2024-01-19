import java.util.Arrays;

public class ClosestPairOfPoints {
    // Class to represent a point
    class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Class to represent a pair of points
    class Pair {
        Point p1, p2;

        public Pair(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        // Method to calculate the distance between two points
        public double getDistance() {
            double deltaX = p1.x - p2.x;
            double deltaY = p1.y - p2.y;
            return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }

    // Method to find the closest pair of points using a divide-and-conquer approach
    public Pair getClosestPair(Point[] points) {
        // Ensure at least 2 points
        if (points.length < 2) {
            return null;
        }

        // Sort the points based on x-coordinates (primary) and y-coordinates (secondary)
        Arrays.sort(points, (a, b) -> {
            if (a.x != b.x) {
                return Double.compare(a.x, b.x);
            } else {
                return Double.compare(a.y, b.y);
            }
        });

        // Find the closest pair recursively
        return closestPair(points, 0, points.length - 1);
    }

    // Recursive method to find the closest pair
    private Pair closestPair(Point[] points, int low, int high) {
        if (low >= high) {
            return null;
        }

        if (low + 1 == high) {
            return new Pair(points[low], points[high]);
        }

        // Calculate mid-point
        int mid = (low + high) / 2;

        // Find closest pairs in left and right halves
        Pair leftClosest = closestPair(points, low, mid);
        Pair rightClosest = closestPair(points, mid + 1, high);

        // Find the minimum distance between left and right pairs
        Pair minPair = (leftClosest.getDistance() < rightClosest.getDistance()) ? leftClosest : rightClosest;

        // Find the closest pair with one point in the left and one point in the right
        Pair stripClosest = stripClosest(points, low, mid, high, minPair.getDistance());

        // Return the closest pair among left, right, and strip
        return (stripClosest == null) ? minPair : stripClosest;
    }

    // Method to find the closest pair with one point in the left and one point in the right strip
    private Pair stripClosest(Point[] points, int low, int mid, int high, double minDistance) {
        Point midPoint = points[mid];
        Point[] strip = new Point[high - low + 1];
        int stripSize = 0;

        // Create a strip of points within the minDistance of the midPoint
        for (int i = low; i <= high; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDistance) {
                strip[stripSize++] = points[i];
            }
        }

        // Sort the strip based on y-coordinates
        Arrays.sort(strip, 0, stripSize, (a, b) -> Double.compare(a.y, b.y));

        // Compare each point in the strip with its neighbors
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < minDistance; j++) {
                double distance = strip[i].getDistance(strip[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    return new Pair(strip[i], strip[j]);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ClosestPairOfPoints closestPairFinder = new ClosestPairOfPoints();

        // Sample points
        Point[] points = {
            closestPairFinder.new Point(2, 3),
            closestPairFinder.new Point(12, 30),
            closestPairFinder.new Point(40, 50),
            closestPairFinder.new Point(5, 1),
            closestPairFinder.new Point(12, 10),
            closestPairFinder.new Point(3, 4)
        };

        Pair closestPair = closestPairFinder.getClosestPair(points);

        if (closestPair != null) {
            System.out.println("The closest pair of points are (" + closestPair.p1.x + ", " + closestPair.p1.y + ") and (" + closestPair.p2.x + ", " + closestPair.p2.y + ")");
            System.out.println("The distance between them is " + closestPair.getDistance());
        } else {
            System.out.println("No closest pair found.");
        }
    }
}
