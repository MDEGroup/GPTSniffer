



public class PolygonAreaCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int numSides = in.nextInt();
        System.out.print("\nEnter the side: ");
        double s = in.nextDouble();
        System.out.println("The area of the polygon is " + area(numSides, s));
    }

    public static double area(int n, double side) {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }
}
