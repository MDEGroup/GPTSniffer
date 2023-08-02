


public class Circle2DGenerator {

    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("Circle2D c1 = new Circle2D(2, 2, 5.5):");
        String area = String.format("%.4f", c1.getArea());
        System.out.println("Circle2D c1's area = " + area);

        String p = String.format("%.4f", c1.getPerimeter());
        System.out.println("perimeter = " + p);

        System.out.println("Result of c1.contains(3,3) = " + c1.contains(3, 3));
        System.out.println("Result of c1.contains(new Circle2D(4,5,10.5)) = " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Result of c1.overlaps(new Circle2D(3,5,2.3)) = " + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}
