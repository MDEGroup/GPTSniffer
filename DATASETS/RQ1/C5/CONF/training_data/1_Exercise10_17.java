

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;


public class MaxSquareNumberGenerator{
    public static void main(String[] args) {
        BigInteger maxLongVal = BigInteger.valueOf(Long.MAX_VALUE);
        int count = 0;
        long rootNum = (long) Math.sqrt(maxLongVal.doubleValue());
        BigInteger root = BigInteger.valueOf(rootNum);
        BigInteger[] result = new BigInteger[10];
        while (count < 10) {
            root = root.add(BigInteger.ONE);
            BigInteger n2 = root.pow(2);
            if (n2.compareTo(maxLongVal) > 0) {
                result[count] = n2;
                count++;
            }

        }
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("The square numbers greater than Long.MAX_VALUE are: ");
        System.out.println(Arrays.toString(result));


    }
}
