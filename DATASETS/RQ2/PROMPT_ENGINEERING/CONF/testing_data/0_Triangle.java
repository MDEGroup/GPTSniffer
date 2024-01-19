import java.util.Scanner;

public class TriangleConstructor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for triangle sides
        System.out.println("Enter the length of side A:");
        double sideA = scanner.nextDouble();

        System.out.println("Enter the length of side B:");
        double sideB = scanner.nextDouble();

        System.out.println("Enter the length of side C:");
        double sideC = scanner.nextDouble();

        // Check if the sides can form a triangle
        if (isValidTriangle(sideA, sideB, sideC)) {
            // Construct the triangle
            System.out.println("Triangle constructed successfully!");
        } else {
            System.out.println("Invalid sides. Cannot construct a triangle.");
        }

        scanner.close();
    }

    // Method to check if the sides can form a triangle
    private static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}