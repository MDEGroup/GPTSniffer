



                                    
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon(){super();}

    public Octagon(double side){
        this.side = side;
    }



    @Override
    public Octagon clone() throws CloneNotSupportedException {
        return (Octagon) super.clone();

    }

    @Override
    public String toString() {
        return "Octagon{" +
                "side=" + side +
                '}';
    }

    @Override
    public double getArea() {
        return (2 + (4 / 22)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        return Double.compare(this.side,o.side);
    }

}
