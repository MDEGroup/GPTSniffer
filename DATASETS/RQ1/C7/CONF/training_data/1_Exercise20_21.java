



public class nan{
    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        selectionSort(list, new GeometricObjectComparator());
        for (int i = 0; i < list.length; i++) {
            System.out.println("Area of GeometricObject @ list[" + i + "] = " + list[i].getArea());
        }
    }

    public static <E> void selectionSort(E[] list,
                                         Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            E currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(currentMin, list[j]) > 0) { 
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}


class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable {
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        if (area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else
            return 1;
    }
}


class Circle extends GeometricObject {

    private double radius;

    public Circle() {

    }

    public Circle(double radius) {

        this.radius = radius;

    }

    public Circle(double radius, String color,
                  boolean filled) {

        this.radius = radius;
        setColor(color);
        setFilled(filled);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRadius: " + getRadius() + "\nArea: "
                + getArea() + "\nPerimeter: " + getPerimeter();
    }

}

class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double newWidth, double newHeight) {

        width = newWidth;
        height = newHeight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = width * height;
        return area;
    }

    @Override
    public double getPerimeter() {

        return (2 * width) + (2 * height);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWidth: " + width + "\nHeight: " + height
                + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }


}

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    
    public String getColor() {
        return color;
    }

    
    public void setColor(String color) {
        this.color = color;
    }

    
    public boolean isFilled() {
        return filled;
    }

    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    
    public abstract double getArea();

    
    public abstract double getPerimeter();
}
