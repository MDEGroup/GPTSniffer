import java.util.Scanner;

public class PoundsToKilograms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a weight in pounds: ");
        double pounds = input.nextDouble();
        
        
        double kilograms = pounds * 0.454;
        
        
        System.out.printf("%.2f pounds is %.2f kilograms.%n", pounds, kilograms);
    }
}