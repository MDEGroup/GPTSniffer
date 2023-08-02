



public class TriangleValidator{
    public static void main(String[] args) {
        System.out.println("Test new Triangle with non-compliant values:");
        try {
            Triangle triangle = new Triangle(1.0, 0.1, 0.2);
            System.out.println("The Triangle's area is " + triangle.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }
        System.out.println("Test new Triangle with compliant values:");
        try {
            Triangle triangle = new Triangle(1.0, 1.0, 1.0);
            System.out.println("The Triangle's area is " + triangle.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }

    }


}
