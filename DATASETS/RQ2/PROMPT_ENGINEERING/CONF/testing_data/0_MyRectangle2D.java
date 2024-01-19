public class MyRectangle2D {

    // Data fields
    private double x;
    private double y;
    private double width;
    private double height;

    // Constructor
    public MyRectangle2D() {
        x = 0;  // Default x-coordinate
        y = 0;  // Default y-coordinate
        width = 1;  // Default width
        height = 1; // Default height
    }

    // Another constructor
    public MyRectangle2D(double newX, double newY, double newWidth, double newHeight) {
        x = newX;    // Set x-coordinate
        y = newY;    // Set y-coordinate
        width = newWidth;  // Set width
        height = newHeight; // Set height
    }

    // Getter and Setter methods for x and y
    public double getX() {
        return x;
    }

    public void setX(double newX) {
        x = newX;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {
        y = newY;
    }

    // Getter and Setter methods for width and height
    public double getWidth() {
        return width;
    }

    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    // Calculate the area of the rectangle
    public double getArea() {
        return width * height;
    }

    // Calculate the perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Check if a point is inside the rectangle
    public boolean contains(double checkX, double checkY) {
        return (checkX >= x - width / 2 && checkX <= x + width / 2) &&
               (checkY >= y - height / 2 && checkY <= y + height / 2);
    }

    // Check if another rectangle is inside this rectangle
    public boolean contains(MyRectangle2D anotherRect) {
        double x1 = x - width / 2;
        double y1 = y - height / 2;
        double x2 = x + width / 2;
        double y2 = y + height / 2;
        
        double x3 = anotherRect.getX() - anotherRect.getWidth() / 2;
        double y3 = anotherRect.getY() - anotherRect.getHeight() / 2;
        double x4 = anotherRect.getX() + anotherRect.getWidth() / 2;
        double y4 = anotherRect.getY() + anotherRect.getHeight() / 2;

        return (x3 >= x1 && x4 <= x2 && y3 >= y1 && y4 <= y2);
    }

    // Check if another rectangle overlaps with this rectangle
    public boolean overlaps(MyRectangle2D anotherRect) {
        double x1 = x - width / 2;
        double y1 = y - height / 2;
        double x2 = x + width / 2;
        double y2 = y + height / 2;
        
        double x3 = anotherRect.getX() - anotherRect.getWidth() / 2;
        double y3 = anotherRect.getY() - anotherRect.getHeight() / 2;
        double x4 = anotherRect.getX() + anotherRect.getWidth() / 2;
        double y4 = anotherRect.getY() + anotherRect.getHeight() / 2;

        return !(x3 > x2 || x4 < x1 || y3 > y2 || y4 < y1);
    }
}