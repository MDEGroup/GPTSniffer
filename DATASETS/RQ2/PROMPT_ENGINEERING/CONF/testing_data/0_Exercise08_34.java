import java.util.Scanner;

public class RightmostLowestPointFinder {

    public static double[] getRightmostLowestPoint(double[][] points) {
        double[] rightmostLowestPoint = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i][1] < rightmostLowestPoint[1] ||
                    (points[i][1] == rightmostLowestPoint[1] && points[i][0] > rightmostLowestPoint[0])) {
                rightmostLowestPoint = points[i];
            }
        }

        return rightmostLowestPoint;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] userPoints = new double[6][2];

        System.out.print("Enter 6 points: ");
        for (int i = 0; i < 6; i++) {
            userPoints[i][0] = input.nextDouble();
            userPoints[i][1] = input.nextDouble();
        }

        double[] result = getRightmostLowestPoint(userPoints);
        System.out.println("The rightmost lowest point is (" + result[0] + ", " + result[1] + ")");
    }
}