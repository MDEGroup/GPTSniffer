import java.util.ArrayList;
import java.util.List;

public class NearestNeighbor {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(5, 1));
        points.add(new Point(4, 6));
        points.add(new Point(7, 2));
        
        Point query = new Point(3, 4);
        Point nearest = findNearestNeighbor(points, query);
        
        System.out.println("Nearest neighbor of " + query + " is " + nearest);
    }
    
    /**
     * Finds the nearest neighbor of a query point in a list of points.
     */
    private static Point findNearestNeighbor(List<Point> points, Point query) {
        double minDistance = Double.MAX_VALUE;
        Point nearest = null;
        for (Point point : points) {
            double distance = query.distanceTo(point);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = point;
            }
        }
        return nearest;
    }
    
    /**
     * Represents a point in 2D space.
     */
    private static class Point {
        private final double x;
        private final double y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        /**
         * Calculates the Euclidean distance between this point and another point.
         */
        public double distanceTo(Point other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            return Math.sqrt(dx*dx + dy*dy);
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}

