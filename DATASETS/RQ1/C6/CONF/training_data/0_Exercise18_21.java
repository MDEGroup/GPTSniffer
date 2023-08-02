import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();
        String binary = dec2Bin(decimal);
        System.out.printf("The binary equivalent of %d is %s%n", decimal, binary);
    }

    public static String dec2Bin(int value) {
        if (value == 0) {
            return "0";
        } else if (value == 1) {
            return "1";
        } else {
            int quotient = value / 2;
            int remainder = value % 2;
            return dec2Bin(quotient) + remainder;
        }
    }
}
