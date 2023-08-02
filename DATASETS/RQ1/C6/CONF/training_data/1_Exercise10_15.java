

import ch_10.exercise10_13.MyRectangle2D;

import java.util.Scanner;


public class BoundingRectangleTest{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five points:");

        double[][] pts = new double[5][2];
        for (int i = 0; i < pts.length; i++) {
            for (int j = 0; j < pts[i].length; j++) {
                pts[i][j] = in.nextDouble();
            }
        }
        MyRectangle2D rectangle2D = getRectangle(pts);
        System.out.print("\nThe bounding rectangle's center (" + rectangle2D.getX() + "," + rectangle2D.getY() + ")" +
                "," + " width: " + rectangle2D.getWidth() + "," + " height: " + rectangle2D.getHeight() + ")");
    }


    public static MyRectangle2D getRectangle(double[][] points) {
        double[] lowestPoint = lowestPoint(points);
        double[] highestPoint = highestPoint(points);
        double[] leftMostPoint = leftMostPoint(points);
        double[] rightMostPoint = rightMostPoint(points);

        double height = Math.abs(highestPoint[1]) - Math.abs(lowestPoint[1]);
        double width = Math.abs(rightMostPoint[0]) - Math.abs(leftMostPoint[0]);
        MyRectangle2D resultRectangle2D = new MyRectangle2D();
        resultRectangle2D.setHeight(height);
        resultRectangle2D.setWidth(width);
        double centerX = leftMostPoint[0] + (width / 2);
        double centerY = lowestPoint[1] + (height / 2);
        resultRectangle2D.setX(centerX);
        resultRectangle2D.setY(centerY);

        return resultRectangle2D;

    }

    static double[] lowestPoint(double[][] pts) {
        double[] lowPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            lowPt = pts[n][1] < lowPt[1] ? pts[n] : lowPt;
        }
        return lowPt;
    }

    static double[] highestPoint(double[][] pts) {
        double[] hiPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            hiPt = pts[n][1] > hiPt[1] ? pts[n] : hiPt;
        }
        return hiPt;
    }

    static double[] rightMostPoint(double[][] pts) {
        double[] rghtPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            rghtPt = pts[n][0] > rghtPt[0] ? pts[n] : rghtPt;
        }
        return rghtPt;
    }

    static double[] leftMostPoint(double[][] pts) {
        double[] lftPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            lftPt = pts[n][0] < lftPt[0] ? pts[n] : lftPt;
        }
        return lftPt;
    }

}
