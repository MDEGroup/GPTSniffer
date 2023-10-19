import java.util.Comparator;

public class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point point1, Point point2) {
        // Compare two points based on their y-coordinates
        int yComparison = Double.compare(point1.getY(), point2.getY());

        if (yComparison != 0) {
            return yComparison;
        } else {
            // If y-coordinates are the same, compare based on x-coordinates
            return Double.compare(point1.getX(), point2.getX());
        }
    }
}