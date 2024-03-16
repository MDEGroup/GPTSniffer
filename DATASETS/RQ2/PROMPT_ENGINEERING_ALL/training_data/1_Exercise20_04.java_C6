

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Point{
    private static Point[] points = new Point[100];
    private static CompareY comparator = new CompareY();

    public static void main(String[] args) {
        Random randomPoint = new Random();
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(randomPoint.nextDouble() * randomPoint.nextInt(999), randomPoint.nextDouble() * randomPoint.nextInt(999));
        }
        System.out.println("Created 100 Random Points: ");
        for (Point point : points) {
            System.out.print(point.toString());
        }

        System.out.println("Increasing order by the x-coordinates: ");
        Arrays.sort(points);
        for (Point point : points) {
            System.out.print(point.toString());
        }

        System.out.println("Increasing order by the y-coordinates: ");
        Arrays.sort(points, comparator);
        for (Point point : points) {
            System.out.print(point.toString());
        }
    }
}
