



public class TrianglePerimeter{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sides of a triangle separated by spaces: ");
        double s1 = in.nextDouble();
        double s2 = in.nextDouble();
        double s3 = in.nextDouble();

        if (s3 > (s1 + s2) || s2 > (s1 + s3) || s1 > (s3 + s2)) {
            System.out.println("Invalid Input.");
        } else {
            System.out.println("Perimeter is " + (s1 + s2 + s3));
        }
        in.close();
    }
}
