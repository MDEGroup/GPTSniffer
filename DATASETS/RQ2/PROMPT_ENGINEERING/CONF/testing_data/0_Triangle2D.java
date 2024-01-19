public class Triangle2D {
    // Three points of the triangle
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    // No-arg constructor with default points
    public Triangle2D() {
        this.p1 = new MyPoint(0, 0);
        this.p2 = new MyPoint(1, 1);
        this.p3 = new MyPoint(2, 5);
    }

    // Constructor with specified points
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Calculate the area of the triangle
    public double getArea() {
        // Calculation code for area goes here
        // You need to implement this
        return 0.0;
    }

    // Calculate the perimeter of the triangle
    public double getPerimeter() {
        // Calculation code for perimeter goes here
        // You need to implement this
        return 0.0;
    }

    // Check if a point is inside the triangle
    public boolean contains(MyPoint p) {
        // Check if p is inside the triangle
        // You need to implement this
        return false;
    }

    // Check if a triangle is inside this triangle
    public boolean contains(Triangle2D t) {
        // Check if t is inside this triangle
        // You need to implement this
        return false;
    }

    // Check if a triangle overlaps with this triangle
    public boolean overlaps(Triangle2D t) {
        // Check if t overlaps this triangle
        // You need to implement this
        return false;
    }
}