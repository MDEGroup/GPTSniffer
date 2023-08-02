

import java.util.Scanner;


public class Exercise05_45 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        double mean, std = 0, sum = 0;

        double[] nums = new double[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextDouble();
        }
        for (double num : nums) {
            sum += num;
        }

        mean = sum / 10;
        System.out.println("The mean is " + mean);

        double temp = 0;

        for (double num : nums) {
            temp += Math.pow(num - mean, 2);
        }
        std = Math.sqrt(temp / 9); 

        System.out.printf("The standard deviation is %.5f", std);
    }


}
