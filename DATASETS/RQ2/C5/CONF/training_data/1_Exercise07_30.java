

import java.util.Scanner;


public class DisplayFourEqual {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
        int len = in.nextInt();
        int[] nums = new int[len];

        System.out.print("Enter the values: ");
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        if (isConsecutiveFour(nums)) {
            System.out.println("The list has consecutive fours.");
        } else {
            System.out.println("The list does not have consecutive fours.");
        }
    }

    
    public static boolean isConsecutiveFour(int[] values) {
        int lastNum = values[0];
        int count = 1;
        for (int j = 1; j < values.length; j++) {
            if (lastNum == values[j]) {
                count++;
            } else {
                lastNum = values[j];
                count = 1;
            }
            if (count == 4) {
                return true;
            }
        }
        return false;

    }

}
