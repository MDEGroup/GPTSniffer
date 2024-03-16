

import java.util.*;


public class Exercise05_25 {
    public static void main(String[] args) {

        double pi = 1.0;
        for (int i = 2; i <= 100000; i++) {

            pi += Math.pow(-1, i + 1) / (2 * i - 1.0d);
            if (i % 10000 == 0) {
                System.out.println("For value of i = " + i + " -> PI =  " + (4.0 * pi));
            }
        }
    }
}