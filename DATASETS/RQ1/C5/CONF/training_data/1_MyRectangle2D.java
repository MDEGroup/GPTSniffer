

import ch_10.exercise10_04.MyPoint;




public class MyRectangle2D {
    private double x;
    private double y;
    private double height;
    private double width;

    public MyRectangle2D() {
        x = 0;
        y = 0;
        height = 1;
        width = 1;
    }

    public MyRectangle2D(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    public boolean contains(double x, double y) {
        
        MyPoint A = new MyPoint(this.x - width / 2, this.y + height / 2);  
        MyPoint B = new MyPoint(this.x + width / 2, this.y - height / 2);  

        return x > A.getX() && y < A.getY() && x < B.getX() && y > B.getY();

    }

    public boolean contains(MyRectangle2D r) {
        if (r.getArea() > this.getArea()) {
            return false;
        }
        return ((r.getX() + r.getWidth() / 2) <= (this.getX() + this.getWidth() / 2)) &&
                ((r.getX() - r.getWidth() / 2) >= (this.getX() - this.getWidth() / 2)) &&
                ((r.getY() + r.getHeight() / 2) <= (this.getY() + this.getHeight() / 2)) &&
                ((r.getY() - r.getHeight() / 2) >= (this.getY() - this.getHeight() / 2));
    }

    public boolean overlaps(MyRectangle2D r) {
        
        MyPoint rec1TopLeft = new MyPoint(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2);
        MyPoint rec1BottomRight = new MyPoint(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2);
        
        MyPoint rec2TopLeft = new MyPoint(this.getX() - this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        MyPoint rec2BottomRight = new MyPoint(this.getX() + r.getWidth() / 2, this.getY() - this.getHeight() / 2);

        return (rec1TopLeft.getX() < rec2BottomRight.getX() && rec2TopLeft.getX() < rec1BottomRight.getX()) &&
                (rec1TopLeft.getY() > rec2BottomRight.getY() && rec2TopLeft.getY() > rec1BottomRight.getY());

    }

    public double getX() {
        return x;
    }

    public MyRectangle2D setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public MyRectangle2D setY(double y) {
        this.y = y;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public MyRectangle2D setHeight(double height) {
        this.height = height;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public MyRectangle2D setWidth(double width) {
        this.width = width;
        return this;
    }
}