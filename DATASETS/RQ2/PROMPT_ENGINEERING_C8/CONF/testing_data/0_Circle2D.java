public class Circle2D {    // Data fields    private double x; // x-coordinate of the center    private double y; // y-coordinate of the center    private double radius; // radius of the circle        // Default constructor    public Circle2D() {        this.x = 0;        this.y = 0;        this.radius = 1;    }        // Constructor with specified x, y, and radius    public Circle2D(double x, double y, double radius) {        this.x = x;        this.y = y;        this.radius = radius;    }        // Getter for x-coordinate    public double getX() {        return x;    }        // Getter for y-coordinate    public double getY() {        return y;    }        // Getter for radius    public double getRadius() {        return radius;    }        // Method to calculate the area of the circle    public double getArea() {        return Math.PI * radius * radius;    }        // Method to calculate the perimeter of the circle    public double getPerimeter() {        return 2 * Math.PI * radius;    }        // Method to check if a point is inside the circle    public boolean contains(double x, double y) {        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));        return distance < radius;    }        // Method to check if a circle is inside this circle    public boolean contains(Circle2D circle) {        double distance = Math.sqrt(Math.pow(this.x - circle.getX(), 2) + Math.pow(this.y - circle.getY(), 2));        return distance + circle.getRadius() <= this.radius;    }        // Method to check if a circle overlaps with this circle    public boolean overlaps(Circle2D circle) {        double distance = Math.sqrt(Math.pow(this.x - circle.getX(), 2) + Math.pow(this.y - circle.getY(), 2));        return distance < this.radius + circle.getRadius();    }}