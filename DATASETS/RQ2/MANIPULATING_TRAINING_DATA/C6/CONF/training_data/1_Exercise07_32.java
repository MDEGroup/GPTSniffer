

import java.util.Arrays;
import java.util.Scanner;


public class PartitionTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter list: ");
        int length = in.nextInt();
        int[] list = new int[length];

        for (int i = 0; i < list.length; i++) {
            list[i] = in.nextInt();

        }
        int indexOfPivot = partition(list);
        System.out.println("After the partition the list is ");
        for (int j : list) {
            System.out.print(j + " ");
        }
        System.out.println("Pivot point is " + indexOfPivot);


    }

    public static int partition(int[] list) {
        int pivotPoint = 0;
        int pivot = list[0];

        while (true) {
            boolean partitioned = true;
            for (int j = 0; j < list.length; j++) {
                if (j == pivotPoint) {
                    continue;
                }

                if (list[j] < pivot) {
                    if (j > pivotPoint) {
                        partitioned = false;
                        int tmp = list[j];
                        list[j] = pivot;
                        list[pivotPoint] = tmp;
                        pivotPoint = j;
                    }

                } else if (list[j] > pivot) {
                    if (j < pivotPoint) {
                        partitioned = false;
                        int tmp = list[j];
                        list[j] = pivot;
                        list[pivotPoint] = tmp;
                        pivotPoint = j;
                    }

                }

            }
            if (partitioned) break;
        }
        return pivotPoint;

    }

}

