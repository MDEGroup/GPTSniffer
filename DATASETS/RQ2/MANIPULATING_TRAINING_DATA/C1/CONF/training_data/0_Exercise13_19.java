import java.util.Scanner;

public class DecimalToFraction {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        String decimal = input.next();
        
        int integerPart = Integer.parseInt(decimal.split("\\.")[0]);
        String fractionalPart = decimal.split("\\.")[1];
        int denominator = (int) Math.pow(10, fractionalPart.length());
        int numerator = Integer.parseInt(fractionalPart) + integerPart * denominator;
        
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        
        System.out.println(decimal + " = " + numerator + "/" + denominator);
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}