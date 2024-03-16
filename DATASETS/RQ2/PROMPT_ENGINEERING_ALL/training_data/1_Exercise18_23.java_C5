

import java.util.Scanner;


public class nan {
    static int pow = 0;
    static int decimal;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the binary number to convert to decimal: ");
        String binaryNum = in.next();
        System.out.println(binaryNum + " binary number is equivalent to the decimal integer: " + bin2Dec(binaryNum));
        in.close();

    }


    public static int bin2Dec(String binaryString) {
        if (binaryString.length() == 0) {
            return decimal;
        }
        char binaryDigit = binaryString.charAt(binaryString.length() - 1);
        int binaryValue = Integer.parseInt(binaryDigit + "");
        decimal += binaryValue * ((int) Math.pow(2, pow));
        pow += 1;
        return bin2Dec(binaryString.substring(0, binaryString.length() - 1));

    }
}
