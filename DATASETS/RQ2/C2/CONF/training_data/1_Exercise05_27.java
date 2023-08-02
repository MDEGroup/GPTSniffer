

import java.util.*;


public class Exercise05_27 {
    public static void main(String[] args) {

        int i = 1;
        for (int year = 2001; year <= 2100; year++) {

            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                System.out.print(year + " ");
                if (i % 10 == 0) {
                    System.out.println();
                }
                i++;
            }

        }
    }
}