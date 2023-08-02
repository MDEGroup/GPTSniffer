import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int decimal = input.nextInt();
        
        int octal = 0;
        int power = 1;
        while (decimal > 0) {
            int remainder = decimal % 8;
            octal += remainder * power;
            power *= 10;
            decimal /= 8;
        }
        
        System.out.println("The octal representation is: " + octal);
    }
}