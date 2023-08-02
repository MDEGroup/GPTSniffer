import java.util.Scanner;

public class AverageAcceleration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting velocity in m/s: ");
        double v0 = input.nextDouble();
        System.out.print("Enter the ending velocity in m/s: ");
        double v1 = input.nextDouble();
        System.out.print("Enter the time span in seconds: ");
        double t = input.nextDouble();
        
        
        double acceleration = (v1 - v0) / t;
        
        
        System.out.printf("The average acceleration is %.2f m/s^2.%n", acceleration);
    }
}