

import java.util.Arrays;
import java.util.Scanner;



public class PolygonAreaCalculator{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double[][] pts = new double[4][2];
        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        for (int pt = 0; pt < 4; pt++) {
            for (int xy = 0; xy < 2; xy++) {
                pts[pt][xy] = in.nextDouble();
            }
        }
        double[] areas = new double[4];

        double[] intersectionPoint = solveForIntersectionPoint(pts);
        System.out.println("Intersection Point: " + Arrays.toString(intersectionPoint));

        double[][] t1 = new double[3][3];
        t1[0] = pts[0];
        t1[1] = pts[1];
        t1[2] = intersectionPoint;
        areas[0] = getTriangleArea(t1);

        double[][] t2 = new double[3][3];
        t2[0] = pts[1];
        t2[1] = pts[2];
        t2[2] = intersectionPoint;
        areas[1] = getTriangleArea(t2);

        double[][] t3 = new double[3][3];
        t3[0] = pts[2];
        t3[1] = pts[3];
        t3[2] = intersectionPoint;
        areas[2] = getTriangleArea(t3);

        double[][] t4 = new double[3][3];
        t4[0] = pts[0];
        t4[1] = pts[3];
        t4[2] = intersectionPoint;
        areas[3] = getTriangleArea(t4);

        Arrays.sort(areas);
        System.out.println("The areas are: ");
        for (double val : areas) {
            System.out.printf("%.2f" + " ", val);
        }

        in.close();

    }


    
    static double getTriangleArea(double[][] points) {
        if (onSameLine(points)) {
            return 0;
        }
        double s1 = findSide(points[0][0], points[0][1], points[1][0], points[1][1]);
        double s2 = findSide(points[0][0], points[0][1], points[2][0], points[2][1]);
        double s3 = findSide(points[2][0], points[2][1], points[1][0], points[1][1]);

        double s = (s1 + s2 + s3) / 2;

        return Math.sqrt((s * (s - s1) * (s - s2) * (s - s3)));
    }

    static double[] solveForIntersectionPoint(double[][] pts) {
        
        
        double x1 = pts[0][0];
        double y1 = pts[0][1];
        double x2 = pts[2][0];
        double y2 = pts[2][1];
        
        double x3 = pts[1][0];
        double y3 = pts[1][1];
        double x4 = pts[3][0];
        double y4 = pts[3][1];
        
        double a = y1 - y2;
        double b = -(x1 - x2);
        double c = y3 - y4;
        double d = -(x3 - x4);
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;
        double D = a * d - b * c;
        double Dx = e * d - b * f;
        double Dy = a * f - e * c;
        double x = Dx / D;
        double y = Dy / D;

        return new double[]{x, y};
    }

    public static double findSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static boolean onSameLine(double[][] pts) {
        double determinant =
                (pts[1][0] - pts[0][0]) * (pts[2][1] - pts[0][1]) - (pts[2][0] - pts[0][0]) * (pts[1][1] - pts[0][1]);

        return determinant == 0;

    }
}
