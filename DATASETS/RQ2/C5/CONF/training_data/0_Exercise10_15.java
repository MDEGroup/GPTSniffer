import java.util.Scanner;public class BoundingRectangleTest {  public static void main(String[] args) {    Scanner input = new Scanner(System.in);    double[][] points = new double[5][2];    System.out.print("Enter five points: ");    for (int i = 0; i < 5; i++) {      points[i][0] = input.nextDouble();      points[i][1] = input.nextDouble();    }    MyRectangle2D rectangle = MyRectangle2D.getRectangle(points);    System.out.println("The bounding rectangle's center (" +        rectangle.getX() + ", " + rectangle.getY() + "), width " +        rectangle.getWidth() + ", height " + rectangle.getHeight());  }}class MyRectangle2D {  private double x;  private double y;  private double width;  private double height;  public MyRectangle2D(double x, double y, double width, double height) {    this.x = x;    this.y = y;    this.width = width;    this.height = height;  }  public double getX() {    return x;  }  public double getY() {    return y;  }  public double getWidth() {    return width;  }  public double getHeight() {    return height;  }  public double getArea() {    return width * height;  }  public double getPerimeter() {    return 2 * (width + height);  }  public boolean contains(double x, double y) {    double xDistance = Math.abs(x - this.x);    double yDistance = Math.abs(y - this.y);    return xDistance <= width / 2 && yDistance <= height / 2;  }  public boolean contains(MyRectangle2D r) {    double xDistance = Math.abs(r.getX() - this.x);    double yDistance = Math.abs(r.getY() - this.y);    return xDistance + r.getWidth() / 2 <= width / 2 &&        yDistance + r.getHeight() / 2 <= height / 2 &&        width / 2 >= r.getWidth() / 2 &&        height / 2 >= r.getHeight() / 2;  }  public boolean overlaps(MyRectangle2D r) {    double xDistance = Math.abs(r.getX() - this.x);    double yDistance = Math.abs(r.getY() - this.y);    return xDistance <= (width + r.getWidth()) / 2 &&        yDistance <= (height + r.getHeight()) / 2;  }  public static MyRectangle2D getRectangle(double[][] points) {    double xMin = points[0][0];    double xMax = points[0][0];    double yMin = points[0][1];    double yMax = points[0][1];    for (int i = 1; i < points.length; i++) {      if (points[i][0] < xMin) {        xMin = points[i][0];      }      if (points[i][0] > xMax) {        xMax = points[i][0];      }      if (points[i][1] < yMin) {        yMin = points[i][1];      }      if (points[i][1] > yMax) {        yMax = points[i][1];      }    }    double x = (xMin + xMax) / 2;    double y = (yMin + yMax) / 2;    double width = xMax - xMin;    double height = yMax - yMin;    return new