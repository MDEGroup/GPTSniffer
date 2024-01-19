public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        // Ensure sides are non-negative
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Sides must be positive.");
        }

        // Check the triangle inequality rule
        if (!isValidTriangle(side1, side2, side3)) {
            throw new IllegalTriangleException("Invalid triangle: The sum of any two sides must be greater than the other side.");
        }

        // Initialize the triangle sides
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Method to check if the sides can form a triangle
    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Other methods and properties of the Triangle class
    // ...
}

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String message) {
        super(message);
    }
}