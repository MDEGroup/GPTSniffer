import java.awt.Point;

public class CirclePointTest {
    
    public static void main(String[] args) {
        Point center = new Point(0, 0); 
        int radius = 5; 
        Point testPoint = new Point(3, 4); 
        
        if (isInsideCircle(center, radius, testPoint)) {
            System.out.println("The point is inside the circle.");
        } else {
            System.out.println("The point is outside the circle.");
        }
    }
    
    public static boolean isInsideCircle(Point center, int radius, Point testPoint) {
        int distanceSquared = (testPoint.x - center.x) * (testPoint.x - center.x)
                            + (testPoint.y - center.y) * (testPoint.y - center.y);
        return distanceSquared < radius * radius;
    }
}

