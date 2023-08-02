public static int partition(int[] list) {
    int pivot = list[0];
    int low = 1;
    int high = list.length - 1;
    
    while (high > low) {
        while (low <= high && list[low] <= pivot) {
            low++;
        }
        while (low <= high && list[high] > pivot) {
            high--;
        }
        if (high > low) {
            int temp = list[high];
            list[high] = list[low];
            list[low] = temp;
        }
    }
    while (high > 0 && list[high] >= pivot) {
        high--;
    }
    if (pivot > list[high]) {
        list[0] = list[high];
        list[high] = pivot;
        return high;
    } else {
        return 0;
    }
}
import java.util.Scanner;

public class PartitionTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list: ");
        int size = input.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = input.nextInt();
        }
        partition(list);
        System.out.print("After the partition, the list is ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}