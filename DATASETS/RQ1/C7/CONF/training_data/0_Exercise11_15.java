
public class ConvexPolygonArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        double[][] points = new double[numberOfPoints][2];
        System.out.println("Enter the coordinates of the points:");
        for (int i = 0; i < numberOfPoints; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        double area = getConvexPolygonArea(points);
        System.out.printf("The total area is %.3f\n", area);
    }

    public static double getConvexPolygonArea(double[][] points) {
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            int j = (i + 1) % points.length;
            area += points[i][0] * points[j][1];
            area -= points[i][1] * points[j][0];
        }
        area /= 2.0;
        return Math.abs(area);
    }
}
