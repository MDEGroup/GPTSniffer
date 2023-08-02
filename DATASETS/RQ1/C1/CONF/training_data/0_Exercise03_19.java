import java.util.Scanner;

public class TrianglePerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the lengths of three edges of a triangle: ");
        double edge1 = input.nextDouble();
        double edge2 = input.nextDouble();
        double edge3 = input.nextDouble();
        
        if (edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1) {
            double perimeter = edge1 + edge2 + edge3;
            System.out.println("The perimeter of the triangle is " + perimeter);
        } else {
            System.out.println("Invalid input: the input values do not form a valid triangle.");
        }
    }
}
