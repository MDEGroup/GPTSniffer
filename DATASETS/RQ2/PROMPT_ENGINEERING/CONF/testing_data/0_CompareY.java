// Welcome to the CompareY class!

// Defining a class named CompareY that implements Comparator<Point>
public class CompareY implements Comparator<Point> {

    // Implementing the compare method to compare two points on their y-coordinates
    @Override
    public int compare(Point point1, Point point2) {
        // Comparing points based on y-coordinates
        double y1 = point1.getYCoordinate();
        double y2 = point2.getYCoordinate();

        // If two points have the same y-coordinates, compare their x-coordinates
        if (y1 < y2) {
            // Points are not equal, return -1
            return -1;
        } else if (y1 > y2) {
            // Points are not equal, return 1
            return 1;
        } else {
            // Y-coordinates are equal, compare their x-coordinates
            double x1 = point1.getXCoordinate();
            double x2 = point2.getXCoordinate();

            if (x1 < x2) {
                // Points are not equal, return -1
                return -1;
            } else if (x1 > x2) {
                // Points are not equal, return 1
                return 1;
            } else {
                // Points are equal, return 0
                return 0;
            }
        }
    }
}
