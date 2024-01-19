import java.util.Scanner;

public class MyRectangle2D {
    double x;
    double y;
    double width;
    double height;

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static MyRectangle2D getRectangle(double[][] points) {
        double minX = points[0][0];
        double minY = points[0][1];
        double maxX = points[0][0];
        double maxY = points[0][1];

        for (int i = 1; i < points.length; i++) {
            double[] point = points[i];
            double x = point[0];
            double y = point[1];

            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }

        double centerX = (minX + maxX) / 2;
        double centerY = (minY + maxY) / 2;
        double rectWidth = maxX - minX;
        double rectHeight = maxY - minY;

        return new MyRectangle2D(centerX, centerY, rectWidth, rectHeight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[5][2];

        System.out.println("Enter five points (x y):");

        for (int i = 0; i < 5; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i][0] = x;
            points[i][1] = y;
        }

        MyRectangle2D boundingRectangle = getRectangle(points);

        System.out.println("The bounding rectangle's center (" + boundingRectangle.x + ", " + boundingRectangle.y +
                "), width " + boundingRectangle.width + ", height " + boundingRectangle.height);
    }
}