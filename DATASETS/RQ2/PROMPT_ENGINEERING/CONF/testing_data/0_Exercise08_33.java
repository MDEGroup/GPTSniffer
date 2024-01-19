import java.util.Scanner;

public class PolygonAreas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double area1 = calculateTriangleArea(x1, y1, x2, y2, x3, y3);
        double area2 = calculateTriangleArea(x1, y1, x3, y3, x4, y4);
        double area3 = calculateTriangleArea(x1, y1, x2, y2, x4, y4);
        double area4 = calculateTriangleArea(x2, y2, x3, y3, x4, y4);

        double[] areas = { area1, area2, area3, area4 };
        sortAreas(areas);

        System.out.print("The areas are ");
        for (double area : areas) {
            System.out.printf("%.2f ", area);
        }
    }

    public static double calculateTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public static void sortAreas(double[] areas) {
        int n = areas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (areas[j] > areas[j + 1]) {
                    double temp = areas[j];
                    areas[j] = areas[j + 1];
                    areas[j + 1] = temp;
                }
            }
        }
    }
}