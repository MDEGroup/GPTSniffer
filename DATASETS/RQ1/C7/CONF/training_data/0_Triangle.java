
public class TriangleConstructor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of side 1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter the length of side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter the length of side 3: ");
        double side3 = input.nextDouble();
        
        if (isValidTriangle(side1, side2, side3)) {
            double perimeter = side1 + side2 + side3;
            double semiPerimeter = perimeter / 2;
            double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
            System.out.printf("Perimeter: %.2f%n", perimeter);
            System.out.printf("Area: %.2f%n", area);
            System.out.println("The triangle is valid.");
        } else {
            System.out.println("The sides entered do not form a valid triangle.");
        }
    }
    
    public static boolean isValidTriangle(double side1, double side2, double side3) {
        return side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2;
    }
}
