package ch_11;

import java.util.ArrayList;
import java.util.Scanner;


public class Exercise11_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int numPoints = in.nextInt();

        ArrayList<double[]> pts = new ArrayList<>();

        System.out.print("Enter the coordinates of the points in the convex polygon: ");

        for (int i = 0; i < numPoints; i++) {
            double[] pt = new double[2];
            for (int xy = 0; xy < 2; xy++) {
                pt[xy] = in.nextDouble();
            }
            pts.add(pt);
        }

        System.out.print("The area of the convex polygon is ");
        System.out.println(getAreaConvexPolygon(pts) + "");

        in.close();

    }

    static double getAreaConvexPolygon(ArrayList<double[]> pts) {
        double[] lastPoint = pts.get(pts.size() - 1);
        double[] firstPoint = pts.get(0);
        double operand1 = lastPoint[0] * firstPoint[1]; // xn * y1
        for (int i = 0; i < pts.size() - 1; i++) {
            double[] pt = pts.get(i);
            double[] nextPt = pts.get(i + 1);
            operand1 += pt[0] * nextPt[1]; // x1 * y2 + x2 * y3 + x(n) * y(n+1) + {x(n) * y1}
        }
        double operand2 = lastPoint[1] * firstPoint[0]; // yn * x1
        for (int i = 0; i < pts.size() - 1; i++) {
            double[] pt = pts.get(i);
            double[] nextPt = pts.get(i + 1);
            operand2 += pt[1] * nextPt[0]; // y1 * x2 + y2 * x3 + y(n) + x(n+1) + {y(n) * x1}

        }
        return Math.abs((operand1 - operand2) * 0.5);

    }

}
