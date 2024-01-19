









public class 1_Exercise11_01.java {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three sides of the triangle:");

        double one = input.nextDouble();
        double two = input.nextDouble();
        double three = input.nextDouble();

        Triangle triangle = new Triangle(one, two, three);

        System.out.print("What color is the triangle?");

        String color = input.next();

        System.out.print("Is the triangle filled? (Enter Yes or No):");

        String fill = input.next();

        triangle.setColor(color);

        boolean filled;

        filled = !"No".matches(fill);

        triangle.setFilled(filled);

        System.out.println("For " + triangle.toString() + " the area is " + triangle.getArea()
                + " square units, " + "\nThe perimeter is " + triangle.getPerimeter());

        System.out.println("The current color is " + triangle.getColor() + " \nAnd "
                + "is the triangle filled is: " + triangle.isFilled());

        input.close();
    }
}




