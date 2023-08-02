import java.util.Scanner;

public class PentagonalCoordinates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the bounding circle: ");
        double radius = input.nextDouble();

        double angle = Math.toRadians(18); 
        double x, y;
        System.out.println("The coordinates of five points on the pentagon are");
        for (int i = 0; i < 5; i++) {
            x = radius * Math.sin(i * angle);
            y = radius * Math.cos(i * angle);
            System.out.printf("(%.4f, %.4f)\n", x, y);
        }
    }
}
