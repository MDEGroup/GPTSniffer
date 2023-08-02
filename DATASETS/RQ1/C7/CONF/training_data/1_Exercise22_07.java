



public class ClosetPoint{
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
        
        Point[] pts = new Point[points.length];
        int idx = 0;
        for (double[] pt : points) {
            pts[idx] = new Point(pt[0], pt[1]);
            idx++;
        }
        
        return getClosestPair(pts);
    }

    
    public static Pair getClosestPair(Point[] pointsOrderedOnX) {
        
        Arrays.sort(pointsOrderedOnX);
        
        Point[] pointsOrderedOnY = pointsOrderedOnX.clone();
        
        Arrays.sort(pointsOrderedOnY, new CompareY());
        
        return distance(pointsOrderedOnX, 0, pointsOrderedOnX.length - 1, pointsOrderedOnY);

    }

    
    public static Pair distance(Point[] pointsOrderedOnX,
                                int low, int high, Point[] pointsOrderedOnY) {
        if (low >= high) {
            return null;
        } else if (low + 1 == high) { 
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        } else {
            
            int mid = (low + high) / 2;
            
            Pair S1 = distance(pointsOrderedOnX, low, mid, pointsOrderedOnY); 
            Pair S2 = distance(pointsOrderedOnX, mid + 1, high, pointsOrderedOnY); 
            
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
            
            for (Point point : pointsOrderedOnY) {
                
                if (point.getX() <= pointsOrderedOnX[mid].getX() && pointsOrderedOnX[mid].getX() - point.getX() <= d) {
                    stripL.add(point);
                    
                } else if (point.getX() > pointsOrderedOnX[mid].getX() && point.getX() - pointsOrderedOnX[mid].getX() <= d) {
                    stripR.add(point);
                }
            }

            int r = 0; 
            for (Point point : stripL) {
                
                while (r < stripR.size() && stripR.get(r).getY() <= point.getY() - d) {
                    r++;
                }
                int r1 = r;
                while (r1 < stripR.size() && Math.abs(stripR.get(r1).getY() - point.getY()) <= d) {
                    
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
