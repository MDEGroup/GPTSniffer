public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return Math.abs(x - this.x) <= width / 2 && Math.abs(y - this.y) <= height / 2;
    }

    public boolean contains(MyRectangle2D r) {
        return contains(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2) &&
               contains(r.getX() - r.getWidth() / 2, r.getY() - r.getHeight() / 2) &&
               contains(r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2) &&
               contains(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2);
    }

    public boolean overlaps(MyRectangle2D r) {
        double x1 = x - width / 2;
        double y1 = y + height / 2;
        double x2 = x + width / 2;
        double y2 = y - height / 2;

        double rx1 = r.getX() - r.getWidth() / 2;
        double ry1 = r.getY() + r.getHeight() / 2;
        double rx2 = r.getX() + r.getWidth() / 2;
        double ry2 = r.getY() - r.getHeight() / 2;

        return !(rx2 < x1 || rx1 > x2 || ry2 > y1 || ry1 < y2);
    }
}
