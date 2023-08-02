

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConvexHull{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int numPoints = scanner.nextInt();
        System.out.print("Enter " + numPoints + " points: ");

        double[][] points = new double[numPoints][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();
        System.out.println("The convex hull is " + getConvexHull(points));

    }


    public static ArrayList<Point2D> getConvexHull(double[][] s) {
        int n = s.length;
        
        List<Point2D> S = Arrays.stream(s).map(points -> new Point2D(points[0], points[1])).collect(Collectors.toList());
        
        ArrayList<Point2D> H = new ArrayList<>();
        
        int l = 0;
        for (int i = 1; i < n; i++)
            if (S.get(i).getX() < S.get(l).getX()) {
                l = i;
            }

        int p = l, q;
        do {
            H.add(S.get(p));

            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (getOrientation(S.get(p), S.get(i), S.get(q)) == -1) {
                    q = i;
                }
            }
            p = q;

        } while (p != l);

        return H;
    }

    public static int getOrientation(Point2D p, Point2D q, Point2D r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0) return 0;
        return (val > 0) ? 1 : -1;
    }
}
