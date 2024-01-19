import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        
        // Convert Celsius to Fahrenheit
        double fahrenheit = (celsius * 1.8) + 32;
        
        // Output result
        System.out.printf("%.1f Celsius = %.1f Fahrenheit", celsius, fahrenheit);
    }
}