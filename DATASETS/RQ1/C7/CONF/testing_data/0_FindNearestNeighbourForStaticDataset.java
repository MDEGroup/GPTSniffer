
public class NearestNeighborSearch {
    public static void main(String[] args) {
        
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(2, 4),
            new Point(5, 2),
            new Point(6, 7),
            new Point(8, 3)
        };
        
        Point query = new Point(4, 5);
        Point nearest = findNearestNeighbor(points, query);
        
        System.out.println("Nearest neighbor to " + query + " is " + nearest);
    }
    
    
    private static Point findNearestNeighbor(Point[] points, Point query) {
        Point nearest = null;
        double minDistance = Double.POSITIVE_INFINITY;
        
        for (Point point : points) {
            double distance = point.distance(query);
            if (distance < minDistance) {
                nearest = point;
                minDistance = distance;
            }
        }
        
        return nearest;
    }
    
    
    private static class Point {
        private final double x;
        private final double y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        public double distance(Point other) {
            double dx = x - other.x;
            double dy = y - other.y;
            return Math.sqrt(dx*dx + dy*dy);
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}

