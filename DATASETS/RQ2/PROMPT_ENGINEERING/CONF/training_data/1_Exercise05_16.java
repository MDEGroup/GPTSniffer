package ch_05;

import java.util.*;


public class Exercise05_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = in.nextInt();

        for (int i = 2; num / i != 1; ) {

            if (num % i == 0) {
                System.out.print(i + ",");
                num = num / i; //Remove the factor from num
            } else {
                //Iterate to next possible factor
                i++;
            }


        }
        //Print number as it has been reduced to the remaining factor
        System.out.print(num);

        in.close();


    }
}