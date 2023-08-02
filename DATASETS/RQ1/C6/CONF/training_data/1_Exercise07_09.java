

import java.util.*;


public class FindSmallestElement{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] a = new double[10];

        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            a[i] = in.nextDouble();
        }
        System.out.println("The minimum number is: " + min(a));
        in.close();
    }

    public static double min(double[] array) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
}