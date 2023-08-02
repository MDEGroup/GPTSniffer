import java.util.ArrayList;
import java.util.List;

public class PointInPolygon {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));
        
        Point query = new Point(5, 5);
        boolean isInside = isInsidePolygon(polygon, query);
        
        System.out.println(query + " is inside the polygon: " + isInside);
    }
    
    /**
     * Determines whether a point is inside a polygon using the winding number algorithm.
     */
    private static boolean isInsidePolygon(List<Point> polygon, Point query) {
        int wn = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i+1)%polygon.size());
            if (p1.y <= query.y) {
                if (p2.y > query.y && isLeft(p1, p2, query) > 0) {
                    wn++;
                }
            } else {
                if (p2.y <= query.y && isLeft(p1, p2, query) < 0) {
                    wn--;
                }
            }
        }
        return wn != 0;
    }
    
    /**
     * Computes the sign of the cross product of vectors p1p2 and p1q.
     */
    private static double isLeft(Point p1, Point p2, Point q) {
        return (p2.x - p1.x) * (q.y - p1.y) - (q.x - p1.x) * (p2.y - p1.y);
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
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}

