import java.util.Scanner;

public class RectangleRelationshipChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the center coordinates, width, and height of the first rectangle:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double width1 = scanner.nextDouble();
        double height1 = scanner.nextDouble();

        System.out.println("Enter the center coordinates, width, and height of the second rectangle:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double width2 = scanner.nextDouble();
        double height2 = scanner.nextDouble();

        // Check for overlapping, containment, or no overlap
        if (Math.abs(x1 - x2) <= (width1 + width2) / 2 && Math.abs(y1 - y2) <= (height1 + height2) / 2) {
            if (Math.abs(x1 - x2) <= Math.abs(width1 - width2) / 2 && Math.abs(y1 - y2) <= Math.abs(height1 - height2) / 2) {
                System.out.println("One rectangle is contained in the other.");
            } else {
                System.out.println("The rectangles overlap.");
            }
        } else {
            System.out.println("The rectangles don't overlap.");
        }

        scanner.close();
    }
}