public class Circle2DTest {
    public static void main(String[] args) {
        // Create a Circle2D object with center at (2, 2) and radius 5.5
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        // Display area and perimeter of c1
        System.out.println("Area of c1: " + c1.getArea());
        System.out.println("Perimeter of c1: " + c1.getPerimeter());

        // Check if c1 contains the point (3, 3)
        System.out.println("c1 contains point (3, 3): " + c1.contains(3, 3));

        // Create a new Circle2D object with center at (4, 5) and radius 10.5
        Circle2D c2 = new Circle2D(4, 5, 10.5);

        // Check if c1 contains c2
        System.out.println("c1 contains c2: " + c1.contains(c2));

        // Create a new Circle2D object with center at (3, 5) and radius 2.3
        Circle2D c3 = new Circle2D(3, 5, 2.3);

        // Check if c1 overlaps c3
        System.out.println("c1 overlaps c3: " + c1.overlaps(c3));
    }
}
