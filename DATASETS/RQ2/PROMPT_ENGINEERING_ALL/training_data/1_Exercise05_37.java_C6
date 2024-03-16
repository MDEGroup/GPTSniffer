

import java.math.BigInteger;
import java.util.*;


public class DecimalToBinary{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int num = in.nextInt();
        String bin = ""; 
        for (int i = num; i > 0; i /= 2) {
            bin = (i % 2 == 0 ? "0" : "1") + bin;
        }
        System.out.println("Calculated using brute force algorithm: Decimal integer " + num + " is represented by the" +
                " " +
                "binary number: " + bin);

        String check = Integer.toBinaryString(num);
        System.out.println("Check using Java built in Integer methods got: " + check);
        in.close();
    }
}