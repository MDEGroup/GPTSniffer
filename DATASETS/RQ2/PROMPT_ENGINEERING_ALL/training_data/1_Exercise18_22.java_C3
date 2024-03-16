

import java.util.Scanner;


public class Exercise18_22 {
    static String hexValue = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number to convert to hex: ");
        int number = in.nextInt();

        System.out.println(number + " is equivalent to hexadecimal number " + dec2Hex(number));
        in.close();
    }

    public static String dec2Hex(int value) {
        if (value < 16) {
            return getAsHexNumber(value) + hexValue;
        }
        hexValue = getAsHexNumber(value % 16) + hexValue;
        return dec2Hex(value / 16);

    }

    static String getAsHexNumber(int value) {
        switch (value) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return String.valueOf(value);
        }


    }
}
