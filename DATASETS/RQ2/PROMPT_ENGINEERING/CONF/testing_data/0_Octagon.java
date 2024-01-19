import java.util.Date;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / 22) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon other) {
        if (this.side < other.side) {
            return -1;
        } else if (this.side > other.side) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Octagon clone() {
        try {
            return (Octagon) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Octagon octagon1 = new Octagon(5);
        Octagon octagon2 = octagon1.clone();

        System.out.println("Octagon 1 - Area: " + octagon1.getArea() + ", Perimeter: " + octagon1.getPerimeter());
        System.out.println("Octagon 2 - Area: " + octagon2.getArea() + ", Perimeter: " + octagon2.getPerimeter());

        int comparisonResult = octagon1.compareTo(octagon2);
        if (comparisonResult == 0) {
            System.out.println("Octagon 1 and Octagon 2 are equal.");
        } else if (comparisonResult < 0) {
            System.out.println("Octagon 1 is smaller than Octagon 2.");
        } else {
            System.out.println("Octagon 1 is larger than Octagon 2.");
        }
    }
}

class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        this.color = "white";
        this.filled = false;
        this.dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();
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

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Created on " + dateCreated + "\nColor: " + color + "\nFilled: " + filled;
    }
}