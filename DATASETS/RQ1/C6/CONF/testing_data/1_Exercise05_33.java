

import java.util.*;


public class Main{
    public static void main(String[] args) {
        for (int number = 6; number <= 10000; number++) {
            int total = 0;
            int divisor = number - 1;

            while (divisor > 0) {

                if (number % divisor == 0) {
                    total += divisor;
                }
                divisor--;
            }

            if (number == total) {
                System.out.println(number);
            }

        }
    }
}