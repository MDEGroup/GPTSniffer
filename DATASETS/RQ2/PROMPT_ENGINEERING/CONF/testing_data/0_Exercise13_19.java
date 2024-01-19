import java.util.Scanner;
import java.math.BigInteger;

public class DecimalToFractionConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        double decimalNumber = scanner.nextDouble();

        // Convert the decimal number to a string to extract integer and fractional parts
        String decimalStr = Double.toString(decimalNumber);

        int integerPart = (int) decimalNumber;
        String fractionalPartStr = decimalStr.substring(decimalStr.indexOf('.') + 1);

        int fractionalPart = Integer.parseInt(fractionalPartStr);
        int powerOfTen = (int) Math.pow(10, fractionalPartStr.length());

        // Use BigInteger to simplify the fraction
        BigInteger numerator = BigInteger.valueOf(integerPart * powerOfTen + fractionalPart);
        BigInteger denominator = BigInteger.valueOf(powerOfTen);

        // Calculate the greatest common divisor (GCD) to simplify the fraction
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        System.out.println("The fraction number is " + numerator + "/" + denominator);
    }
}