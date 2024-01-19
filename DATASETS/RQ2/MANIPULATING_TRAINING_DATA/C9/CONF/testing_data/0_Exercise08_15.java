public class SameLineChecker {
    public static void main(String[] args) {
        double[][] points = new double[5][2];

        // Read coordinates for five points from the user
        System.out.print("Enter the x and y coordinates for five points: ");
        for (int i = 0; i < 5; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // Check if all five points are on the same line
        if (arePointsOnSameLine(points)) {
            System.out.println("All five points are on the same line.");
        } else {
            System.out.println("The five points are not on the same line.");
        }
    }

    // Check if all points are collinear (on the same line)
    public static boolean arePointsOnSameLine(double[][] points) {
        if (points.length < 3) {
            // If we have fewer than three points, they are always on the same line
            return true;
        }

        // Calculate the slope between the first two points
        double slope = calculateSlope(points[0], points[1]);

        // Check if the remaining points have the same slope as the first two
        for (int i = 2; i < points.length; i++) {
            double currentSlope = calculateSlope(points[0], points[i]);
            if (currentSlope != slope) {
                // If any point has a different slope, they are not on the same line
                return false;
            }
        }

        // If all points have the same slope, they are on the same line
        return true;
    }

    // Calculate the slope between two points
    public static double calculateSlope(double[] point1, double[] point2) {
        return (point2[1] - point1[1]) / (point2[0] - point1[0]);
    }
}