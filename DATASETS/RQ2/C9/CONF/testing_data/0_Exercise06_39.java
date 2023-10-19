import java.util.Scanner;

public class PointPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Point Position Checker");
        System.out.println("----------------------");

        System.out.print("Enter coordinates for three points (x0 y0 x1 y1 x2 y2): ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        String position = getPositionRelativeToLine(x0, y0, x1, y1, x2, y2);

        System.out.println("(" + x2 + ", " + y2 + ") is " + position + " the line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    }

    private static String getPositionRelativeToLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double crossProduct = calculateCrossProduct(x0, y0, x1, y1, x2, y2);

        if (Math.abs(crossProduct) < 1e-10) {
            return "on the same line as";
        } else if (crossProduct > 0) {
            return "on the left side of";
        } else {
            return "on the right side of";
        }
    }

    private static double calculateCrossProduct(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }
}