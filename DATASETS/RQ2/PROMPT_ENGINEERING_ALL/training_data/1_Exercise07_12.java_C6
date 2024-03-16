

import java.util.*;


public class nan{
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] t1 = new int[10];
        System.out.println("Exercise25_01 array is: " + Arrays.toString(test));
        reverse(test);
        System.out.println("Exercise25_01 array reversed: " + Arrays.toString(test) + "\n");
        System.out.println("Enter 10 numbers: ");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            t1[i] = in.nextInt();
        }
        reverse(t1);
        System.out.println("Your array reversed is: " + Arrays.toString(t1));
    }

    public static int[] reverse(int[] a) {
        int j = a.length - 1;
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            j--;
        }
        return a;
    }

}