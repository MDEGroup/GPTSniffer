

import java.util.*;


public class SmallestFactorsCalculator{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = in.nextInt();

        for (int i = 2; num / i != 1; ) {

            if (num % i == 0) {
                System.out.print(i + ",");
                num = num / i; 
            } else {
                
                i++;
            }


        }
        
        System.out.print(num);

        in.close();


    }
}