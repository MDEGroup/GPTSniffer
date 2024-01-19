public class Circle2DTest {

    public static void main(String[] args) {
        
        // Create a Circle2D object c1
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        // Display the area and perimeter of c1
        double areaOfC1 = c1.getArea();
        double perimeterOfC1 = c1.getPerimeter();
        System.out.println("The area of c1 is: " + areaOfC1);
        System.out.println("The perimeter of c1 is: " + perimeterOfC1);

        // Check if point (3, 3) is inside c1
        boolean isInside = c1.contains(3, 3);
        System.out.println("Is point (3, 3) inside c1? " + isInside);

        // Create a new Circle2D object c2
        Circle2D c2 = new Circle2D(4, 5, 10.5);

        // Check if c2 is inside c1
        boolean isC2InsideC1 = c1.contains(c2);
        System.out.println("Is circle c2 inside c1? " + isC2InsideC1);

        // Create another Circle2D object c3
        Circle2D c3 = new Circle2D(3, 5, 2.3);

        // Check if c3 overlaps with c1
        boolean doesC3OverlapC1 = c1.overlaps(c3);
        System.out.println("Do circles c1 and c3 overlap? " + doesC3OverlapC1);
    }
}