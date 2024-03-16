

import java.util.Random;


public class Exercise09_06 {
    public static void main(String[] args) {
        int[] testNums = new int[100000];
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            testNums[i] = random.nextInt(10000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Start time: " + stopWatch.getStartTime() + " ms");

        selectionSort(testNums);
        stopWatch.stop();

        System.out.println("End time: " + stopWatch.getEndTime() + " ms");

        System.out.println("Elapsed time for selection sort: " + stopWatch.getElapsedTime() + " ms");


    }

    public static void selectionSort(int[] nums) {
        for (int n = 0; n < nums.length - 1; n++) {
            int min = nums[n];
            int minIdx = n;
            for (int k = n + 1; k < nums.length; k++) {
                if (nums[k] < min) {
                    min = nums[k];
                    minIdx = k;
                }
            }
            // Swap
            if (minIdx != n) {
                nums[minIdx] = nums[n];
                nums[n] = min;
            }
        }
    }
}
