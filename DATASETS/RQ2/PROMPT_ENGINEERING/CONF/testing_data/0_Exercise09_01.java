// Defining the Rectangle class
public class Rectangle {
    // Data fields
    private double width;
    private double height;
    
    // Default constructor
    public Rectangle() {
        this.width = 1.0; // Default width
        this.height = 1.0; // Default height
    }
    
    // Constructor with specified width and height
    public Rectangle(double width, double height) {
        this.width = width; // Set width
        this.height = height; // Set height
    }
    
    // Method to get the area of the rectangle
    public double getArea() {
        return width * height; // Calculate area
    }
    
    // Method to get the perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (width + height); // Calculate perimeter
    }
}

// Test program
public class TestRectangle {
    public static void main(String[] args) {
        // Creating two Rectangle objects
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        
        // Displaying details of the rectangles
        System.out.println("Rectangle 1:");
        System.out.println("Width: " + rectangle1.width);
        System.out.println("Height: " + rectangle1.height);
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());
        
        System.out.println("\nRectangle 2:");
        System.out.println("Width: " + rectangle2.width);
        System.out.println("Height: " + rectangle2.height);
        System.out.println("Area: " + rectangle2.getArea());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());
    }
}