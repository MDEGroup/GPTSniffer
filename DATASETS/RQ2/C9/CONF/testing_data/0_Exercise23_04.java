import java.util.Arrays;

public class QuickSortImproved {
    public static void main(String[] args) {
        // Sample data
        int[] array = {9, 2, 4, 7, 5, 1, 6, 8, 3};

        // Sort the array using the improved quicksort algorithm
        improvedQuickSort(array, 0, array.length - 1);

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Sorts an array using the improved quicksort algorithm
    public static void improvedQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            improvedQuickSort(array, low, pivotIndex - 1);
            improvedQuickSort(array, pivotIndex + 1, high);
        }
    }

    // Partitions the array and returns the pivot index
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && array[left] <= pivot) {
                left++;
            }

            while (array[right] >= pivot && right >= left) {
                right--;
            }

            if (right < left) {
                break;
            }

            // Swap array[left] and array[right]
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        // Swap array[low] and array[right]
        array[low] = array[right];
        array[right] = pivot;

        return right;
    }
}