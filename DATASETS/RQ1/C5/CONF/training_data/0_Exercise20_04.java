import java.util.*;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }

    public static class CompareY implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.getY() == p2.getY()) {
                return Integer.compare(p1.getX(), p2.getX());
            }
            return Integer.compare(p1.getY(), p2.getY());
        }
    }

    public static void main(String[] args) {
        
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            points.add(new Point(random.nextInt(100), random.nextInt(100)));
        }

        
        Collections.sort(points);
        System.out.println("Sorted by x-coordinates:");
        for (Point p : points) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }

        
        Collections.sort(points, new CompareY());
        System.out.println("\nSorted by y-coordinates:");
        for (Point p : points) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }
    }
}
