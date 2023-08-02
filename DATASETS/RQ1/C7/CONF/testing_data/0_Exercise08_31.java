
public class IntersectPoint{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] points = new double[4][2];
        System.out.print("Enter four points: ");
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }
        double[] intersectingPoint = getIntersectingPoint(points);
        if (intersectingPoint == null) {
            System.out.println("The two lines are parallel.");
        } else {
            System.out.printf("The intersecting point is at (%.4f, %.4f)\n",
                    intersectingPoint[0], intersectingPoint[1]);
        }
    }

    public static double[] getIntersectingPoint(double[][] points) {
        double x1 = points[0][0], y1 = points[0][1];
        double x2 = points[1][0], y2 = points[1][1];
        double x3 = points[2][0], y3 = points[2][1];
        double x4 = points[3][0], y4 = points[3][1];
        double a = y1 - y2;
        double b = x2 - x1;
        double c = y3 - y4;
        double d = x4 - x3;
        double e = a * x1 + b * y1;
        double f = c * x3 + d * y3;
        double determinant = a * d - b * c;
        if (determinant == 0) {
            return null;
        } else {
            double x = (e * d - b * f) / determinant;
            double y = (a * f - e * c) / determinant;
            return new double[]{x, y};
        }
    }
}
