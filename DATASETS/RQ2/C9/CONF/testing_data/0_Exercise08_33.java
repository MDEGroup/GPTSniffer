import java.util.Scanner;
import java.util.Arrays;

public class PolygonAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter coordinates of four vertices
        double[][] vertices = new double[4][2];
        System.out.print("Please enter the x and y coordinates of four vertices: ");
        for (int i = 0; i < 4; i++) {
            vertices[i][0] = input.nextDouble();
            vertices[i][1] = input.nextDouble();
        }

        // Calculate the areas of the four triangles
        double[] triangleAreas = new double[4];
        triangleAreas[0] = calculateTriangleArea(vertices[0], vertices[1], vertices[2]);
        triangleAreas[1] = calculateTriangleArea(vertices[0], vertices[1], vertices[3]);
        triangleAreas[2] = calculateTriangleArea(vertices[1], vertices[2], vertices[3]);
        triangleAreas[3] = calculateTriangleArea(vertices[2], vertices[3], vertices[0]);

        // Sort the areas in ascending order
        Arrays.sort(triangleAreas);

        // Display the areas of the four triangles
        System.out.print("The areas of the four triangles in increasing order are: ");
        for (double area : triangleAreas) {
            System.out.printf("%.2f ", area);
        }
        System.out.println();
    }

    // Calculate the area of a triangle using the cross product
    public static double calculateTriangleArea(double[] point1, double[] point2, double[] point3) {
        double sideA = calculateDistance(point1, point2);
        double sideB = calculateDistance(point2, point3);
        double sideC = calculateDistance(point3, point1);
        double s = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC);
        return area;
    }

    // Calculate the Euclidean distance between two points
    public static double calculateDistance(double[] point1, double[] point2) {
        double deltaX = point2[0] - point1[0];
        double deltaY = point2[1] - point1[1];
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}