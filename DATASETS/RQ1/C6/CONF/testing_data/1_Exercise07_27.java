

import java.util.Arrays;
import java.util.Scanner;


public class IdenticalArrays{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter list 1: ");
        int l1Size = in.nextInt();

        int[] l1 = new int[l1Size];
        for (int i = 0; i < l1.length; i++) {
            l1[i] = in.nextInt();
        }

        System.out.print("\nEnter list 2: ");
        int l2Size = in.nextInt();
        int[] l2 = new int[l2Size];

        for (int i = 0; i < l2.length; i++) {
            l2[i] = in.nextInt();
        }

        if (equals(l1, l2)) {
            System.out.println("The Two lists are identical.");
        } else {
            System.out.println("The two lists are not identical.");
        }
        in.close();
    }

    public static boolean equals(int[] list1, int[] list2) {
        Arrays.sort(list1);
        Arrays.sort(list2);

        if (list1.length != list2.length) {
            return false;
        }
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }
        return true;
    }
}
