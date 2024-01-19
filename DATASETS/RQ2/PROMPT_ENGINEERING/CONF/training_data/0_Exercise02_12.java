import java.util.Scanner;

public class RunwayLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the take-off speed in m/s: ");
        double v = input.nextDouble();
        System.out.print("Enter the acceleration in m/s^2: ");
        double a = input.nextDouble();
        
        // Calculate the minimum runway length
        double length = v * v / (2 * a);
        
        // Display the result
        System.out.printf("The minimum runway length is %.2f meters.%n", length);
    }
}