import java.util.Scanner;

/**
 * This program finds and displays the rightmost lowest point among a set of user-entered coordinates.
 */
public class RightmostLowestPointFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] points = new double[6][2];

        // Prompt the user to enter coordinates for six points.
        System.out.print("Enter the coordinates of 6 points: ");
        for (int i = 0; i < 6; i++) {
            points[i][0] = input.nextDouble(); // x-coordinate
            points[i][1] = input.nextDouble(); // y-coordinate
        }

        // Find and display the rightmost lowest point.
        double[] rightmostLowest = findRightmostLowestPoint(points);
        System.out.println("The rightmost lowest point is at (" + rightmostLowest[0] + ", " + rightmostLowest[1] + ")");
    }

    /**
     * Finds the rightmost lowest point among a set of points.
     *
     * @param points A 2D array of points where each point is represented as {x, y}.
     * @return The rightmost lowest point.
     */
    public static double[] findRightmostLowestPoint(double[][] points) {
        if (points.length == 0) {
            return null; // Handle the case where the input array is empty
        }

        // Initialize with the first point.
        double[] rightmostLowest = points[0];

        for (int i = 1; i < points.length; i++) {
            double[] currentPoint = points[i];
            if (currentPoint[1] < rightmostLowest[1] || (currentPoint[1] == rightmostLowest[1] && currentPoint[0] > rightmostLowest[0])) {
                rightmostLowest = currentPoint;
            }
        }

        return rightmostLowest;
    }
}