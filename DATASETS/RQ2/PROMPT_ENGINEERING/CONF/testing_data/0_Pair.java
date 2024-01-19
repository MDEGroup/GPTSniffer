public class Pair {
    // Data fields to store the coordinates of two points
    private double p1X, p1Y;
    private double p2X, p2Y;

    // Constructor to initialize the points
    public Pair(double p1X, double p1Y, double p2X, double p2Y) {
        this.p1X = p1X;
        this.p1Y = p1Y;
        this.p2X = p2X;
        this.p2Y = p2Y;
    }

    // Method to calculate the distance between two points
    public double getDistance() {
        // Calculate the differences in x and y coordinates
        double deltaX = p2X - p1X;
        double deltaY = p2Y - p1Y;

        // Calculate the distance using the Pythagorean theorem
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        // Return the calculated distance
        return distance;
    }

    public static void main(String[] args) {
        // Create an instance of the Pair class
        Pair pointPair = new Pair(1.0, 2.0, 4.0, 6.0);

        // Calculate and display the distance between the two points
        double distance = pointPair.getDistance();
        System.out.println("The distance between the two points is: " + distance);
    }
}