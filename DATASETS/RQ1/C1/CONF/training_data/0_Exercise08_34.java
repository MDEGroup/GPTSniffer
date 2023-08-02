public static double[] getRightmostLowestPoint(double[][] points) {
    double[] result = points[0]; // initialize result to the first point
    for (int i = 1; i < points.length; i++) {
        double[] currentPoint = points[i];
        if (currentPoint[1] < result[1] || (currentPoint[1] == result[1] && currentPoint[0] > result[0])) {
            result = currentPoint;
        }
    }
    return result;
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] points = new double[6][2];

        // Prompt the user to enter six points
        System.out.print("Enter 6 points: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        // Find the rightmost lowest point
        double[] rightmostLowestPoint = getRightmostLowestPoint(points);

        // Display the result
        System.out.printf("The rightmost lowest point is (%.1f, %.1f)", rightmostLowestPoint[0], rightmostLowestPoint[1]);
    }
}