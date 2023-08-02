

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Exercise22_07 {
    private static Point[] S = new Point[]{new Point(65.72438591548975, 167.6922117473909),
            new Point(182.85174298311438, 575.9888358534622),
            new Point(240.22902231427315, 175.37793004083213),
            new Point(317.5674265676426, 278.78240371327325),
            new Point(356.00061370323124, 337.3921411106672),
            new Point(302.54686547351093, 59.079345054498475),
            new Point(163.48579149126033, 749.1901740238649),
            new Point(277.76518877799515, 420.1256294206885),
            new Point(108.51033510595356, 21.982331832110937),
            new Point(108.5270214151543, 160.55324389043895),
    };

    public static void main(String[] args) {
        Pair closestPair = getClosestPair(S);
        System.out.println("Closest Pair is: ");
        System.out.println(closestPair.toString());

    }

    
    public static Pair getClosestPair(double[][] points) {
        /* Convert to Point[] */
        Point[] pts = new Point[points.length];
        int idx = 0;
        for (double[] pt : points) {
            pts[idx] = new Point(pt[0], pt[1]);
            idx++;
        }
        /* Use Point[] method to share common logic */
        return getClosestPair(pts);
    }

    
    public static Pair getClosestPair(Point[] pointsOrderedOnX) {
        /* Sort Points by X first order, see Point.java */
        Arrays.sort(pointsOrderedOnX);
        /* Create deep copy of pointsOrderedOnX array */
        Point[] pointsOrderedOnY = pointsOrderedOnX.clone();
        /* Sort pointsOrderedOnY by Y first order, see CompareY.java*/
        Arrays.sort(pointsOrderedOnY, new CompareY());
        /* Start recursion at low = startIndex, and high = endIndex */
        return distance(pointsOrderedOnX, 0, pointsOrderedOnX.length - 1, pointsOrderedOnY);

    }

    
    public static Pair distance(Point[] pointsOrderedOnX,
                                int low, int high, Point[] pointsOrderedOnY) {
        if (low >= high) {/* Recursive stopping condition */
            return null;
        } else if (low + 1 == high) { /* Only 2 Points possible to pair: pointsOrderedOnX[low], pointsOrderedOnX[high] */
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        } else {
            /* Divide and Conquer */
            int mid = (low + high) / 2;
            /* Split sorted in half into S1 and S2, let d1 and d2 denote the distance of the closest pair in each subset */
            Pair S1 = distance(pointsOrderedOnX, low, mid, pointsOrderedOnY); //d1
            Pair S2 = distance(pointsOrderedOnX, mid + 1, high, pointsOrderedOnY); // d2
            /* Find minDistance = min(d1,d2) distance */
            double d = 0;
            Pair p = null;
            if (S1 != null && S2 != null) {
                double leftPairDistance = S1.getDistance();
                double rightPairDistance = S1.getDistance();
                d = Math.min(leftPairDistance, rightPairDistance);
                p = leftPairDistance == d ? S1 : S2;
            } else if (S1 != null) {
                d = S1.getDistance();
                p = S1;
            } else if (S2 != null) {
                d = S2.getDistance();
                p = S2;
            }

            List<Point> stripL = new ArrayList<>();
            List<Point> stripR = new ArrayList<>();
            /* Obtain stripL and stripR */
            for (Point point : pointsOrderedOnY) {
                /*  if (p is in S1 and mid.x – p.x <= d) */
                if (point.getX() <= pointsOrderedOnX[mid].getX() && pointsOrderedOnX[mid].getX() - point.getX() <= d) {
                    stripL.add(point);
                    /* else if  (p is in S2 and p.x - mid.x <= d) */
                } else if (point.getX() > pointsOrderedOnX[mid].getX() && point.getX() - pointsOrderedOnX[mid].getX() <= d) {
                    stripR.add(point);
                }
            }

            int r = 0; // The index of the point in stripE
            for (Point point : stripL) {
                // Skip the points in stripR below p.y - d
                while (r < stripR.size() && stripR.get(r).getY() <= point.getY() - d) {
                    r++;
                }
                int r1 = r;
                while (r1 < stripR.size() && Math.abs(stripR.get(r1).getY() - point.getY()) <= d) {
                    /* Check if (p, q[r1]) is a possible closest pair */
                    if (new Pair(point, stripR.get(r1)).getDistance() < d) {
                        d = new Pair(point, stripR.get(r1)).getDistance();
                        p.setP1(point);
                        p.setP2(stripR.get(r1));
                    }
                    r1++;
                }
            }
            return p;
        }
    }
}
