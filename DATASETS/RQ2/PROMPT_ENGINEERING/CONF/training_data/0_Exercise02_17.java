import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the temperature (in degrees Fahrenheit): ");
        double ta = scanner.nextDouble();
        
        if (ta < -58 || ta > 41) { // check if ta is within valid range
            System.out.println("Temperature must be between -58 ºF and 41ºF.");
            System.exit(1);
        }
        
        System.out.print("Enter the wind speed (in miles per hour): ");
        double v = scanner.nextDouble();
        
        if (v < 2) { // check if v is within valid range
            System.out.println("Wind speed must be greater than or equal to 2 mph.");
            System.exit(1);
        }
        
        // Calculate wind-chill temperature
        double twc = 35.74 + 0.6215*ta - 35.75*Math.pow(v, 0.16) + 0.4275*ta*Math.pow(v, 0.16);
        
        // Output result
        System.out.printf("The wind-chill temperature is: %.2f ºF", twc);
    }
}