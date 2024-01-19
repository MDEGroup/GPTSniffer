

import java.util.*;


public class Exercise07_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");

        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextDouble();
        }
        int x = indexOfSmallestElement(nums);
        System.out.println("Index of the smallest element is " + x + " with a value of " + nums[x]);
    }

    public static int indexOfSmallestElement(double[] array) {

        double smallest = Double.MAX_VALUE;
        int smallIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (smallest > array[i]) {
                smallest = array[i];
                smallIdx = i;
            }

        }
        return smallIdx;
    }
}