


import java.util.Arrays;
import java.util.Scanner;



public class nan{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of balls to include in the Galton box experiment: ");
        int balls = in.nextInt();
        System.out.print("\nEnter the number of slots: ");
        int numSlots = in.nextInt();
        int[] slots = new int[numSlots];
        for (int i = 1; i <= balls; i++) { 
            char[] path = simulateRandomPath(numSlots);
            slots = simulateDrop(path, slots, i);
        }
        System.out.println("Where 1 is equal to a ball in the slot, the slots after all balls are dropped is: ");
        System.out.print(Arrays.toString(slots));
    }

    private static int[] simulateDrop(char[] path, int[] slots, int ballNumber) {
        int resultIdx = 0;
        System.out.println("Ball number " + ballNumber + " falls down path: " + Arrays.toString(path));
        for (char c : path) {
            if (c == 'R') {
                resultIdx++;
            }
        }
        System.out.println("And lands in slot number: " + resultIdx);
        slots[resultIdx - 1] += 1;
        return slots;
    }

    private static char[] simulateRandomPath(int numSlots) {
        char[] result = new char[numSlots];
        for (int i = 0; i < result.length; i++) {
            int random = (int) (Math.random() * 2);
            result[i] = (random == 0) ? 'R' : 'L';
        }
        return result;
    }
}
