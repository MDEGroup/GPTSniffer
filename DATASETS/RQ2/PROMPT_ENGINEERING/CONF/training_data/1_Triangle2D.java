package ch_10.exercise10_12;

import ch_10.exercise10_04.MyPoint;


public class Triangle2D {
    /*
     * ■ Three points named p1, p2, and p3 of the type MyPoint with getter and
     * setter methods. MyPoint is defined in Programming Exercise 10.4.
     */
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    
    public Triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    
    public double getArea() {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    
    public double getPerimeter() {
        return p1.distance(p2)
                + p2.distance(p3)
                + p3.distance(p1);

    }

    
    public boolean contains(MyPoint p) {
        /* Find determinant of triangle */
        double a = p2.getY() - p3.getY();
        double b = p3.getX() - p2.getX();
        double c = p3.getY() - p1.getY();
        double d = p2.getX() - p3.getX();
        double determinant = a * d - b * c;
        double maxDet = Math.max(determinant, 0);
        double minDet = Math.min(determinant, 0);
        double detOfx = p.getX() - p3.getX();
        double detOfy = p.getY() - p3.getY();
        double s = a * detOfx + b * detOfy;
        double t = c * detOfx + d * detOfy;
        double z = determinant - s - t;
        return !(s < minDet || s > maxDet) ||
                !(t < minDet || t > maxDet) ||
                !(z < minDet || z > maxDet);

    }

    
    public boolean contains(Triangle2D t) {
        return this.contains(t.getP1()) && this.contains(t.getP2()) && this.contains(t.getP3());


    }

    
    public boolean overlaps(Triangle2D t) {
        return this.contains(t.getP1()) || this.contains(t.getP2()) || this.contains(t.getP3());
    }


    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }


}
