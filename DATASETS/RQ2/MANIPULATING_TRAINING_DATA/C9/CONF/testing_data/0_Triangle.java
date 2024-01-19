import java.util.Scanner;

public class TriangleConstructor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the length of the first side: ");
        double side1 = input.nextDouble();
        
        System.out.print("Enter the length of the second side: ");
        double side2 = input.nextDouble();
        
        System.out.print("Enter the length of the third side: ");
        double side3 = input.nextDouble();
        
        if (isValidTriangle(side1, side2, side3)) {
            double perimeter = calculatePerimeter(side1, side2, side3);
            double area = calculateArea(side1, side2, side3);
            
            System.out.println("Triangle is valid.");
            System.out.printf("Perimeter: %.2f%n", perimeter);
            System.out.printf("Area: %.2f%n", area);
        } else {
            System.out.println("Invalid triangle. The sides do not form a triangle.");
        }
    }

    public static boolean isValidTriangle(double side1, double side2, double side3) {
        return (side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2);
    }

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static double calculateArea(double side1, double side2, double side3) {
        double s = calculatePerimeter(side1, side2, side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}