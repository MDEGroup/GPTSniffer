

import java.util.*;


public class Main{
    public static void main(String[] args) {

        int n = 1;
        while (Math.pow(n, 3) < 12000) {
            if (Math.pow(n + 1, 3) > 12000) {
                break;
            } else {
                n++;
            }
        }
        System.out.println(n + " * " + n + " * " + n + " = " + (int) Math.pow(n, 3));

    }
}