

import java.util.*;


public class ExpApprox {
    static double e;

    public static void main(String[] args) {
        double e = 1;
        int item = 10000;
        while (item <= 100000) {
            double denominator = 0;
            for (double i = 1; i <= item; i++) {
                denominator += i * (i - 1);
            }
            e += 1 / denominator;
            System.out.println("e is " + e + " when i is " + item);
            item += 10000;
        }
    }
}

