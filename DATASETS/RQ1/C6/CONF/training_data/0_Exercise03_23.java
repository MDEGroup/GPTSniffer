import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a point (x, y): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        
        if (Math.abs(x) <= 5 && Math.abs(y) <= 2.5) {
            System.out.println("The point is inside the rectangle.");
        } else {
            System.out.println("The point is outside the rectangle.");
        }

        scanner.close();
    }
}