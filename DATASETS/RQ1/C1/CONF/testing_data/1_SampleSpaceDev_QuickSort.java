import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void main(String[] args) {
        int size = args.length >= 1 ? Integer.parseInt(args[0]) : 10;
        int[] numbers = getRandomArray(size);

        System.out.printf("Array before: %s%n", Arrays.toString(numbers));
        
        Instant start = Instant.now();
        quickSort(numbers, 0, numbers.length - 1);
        Instant end = Instant.now();
        
        System.out.printf("Array after: %s%n", Arrays.toString(numbers));

        long nanos = Duration.between(start, end).toNanos();
        System.out.printf("Took %,2dμs (%.3fms)%n", nanos / 1000, (float) nanos / 1000000);
    }

    /**
     * Swaps two elements in an array with the use of a temporary variable.
     * 
     * @param array        The array
     * @param leftMarker   The index of the first element
     * @param rightMarker  The index of the second element
     */
    public static void swap(int[] array, int leftMarker, int rightMarker) {
        int temp = array[leftMarker];
        array[leftMarker] = array[rightMarker];
        array[rightMarker] = temp;
    }

    /**
     * Performs the quick sort algorithm on an array. Works by partitioning an
     * array into two sub-arrays around a pivot element, and then recursively
     * sorting the two sub-arrays.
     *  
     * If the array is too large it will use the {@link Main#insertionSort(int[], int, int)}
     * instead. This prevents what I can only assume is a {@link StackOverflowError} because
     * the code just does not run on arrays of around size 14 or higher.
     * 
     * @param array  The array to sort
     * @param left   The index of the leftmost element of the array
     * @param right  The index of the rightmost element of the array.
     */
    public static int[] quickSort(int[] array, int left, int right) {
        int recursionThreshold = 12;

        if (array.length > recursionThreshold) {
            insertionSort(array, left, right); 
        } else {
            while (left < right) {
                int pivotIndex = partition(array, left, right);
                if (pivotIndex - left < right - pivotIndex) {
                    quickSort(array, left, pivotIndex - 1); 
                    left = pivotIndex + 1;
                } else {
                    quickSort(array, pivotIndex + 1, right);
                    right = pivotIndex - 1;
                }
            }
        }
        return array;
    }

    /**
     * Performs the insertion sort algorithm on an array. Works by iterating 
     * over the array, comparing each element to the previous elements,
     * and swapping them if necessary to maintain the order.
     * 
     * @param array  The array to sort.
     * @param left   The index of the leftmost element of the sub-array.
     * @param right  The index of the rightmost element of the sub-array.
     */
    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Partitions an array into two subarrays around a pivot element
     * and rearranges the array such that all the elements less than 
     * the pivot are to its left and all the elements greater are to 
     * the right.
     * 
     * @param array  The array to be partitioned.
     * @param left   The index of the leftmost element of the sub-array.
     * @param right  The index of the rightmost element of the sub-array.
     */
    private static int partition(int[] array, int left, int right) {
        int leftMarker = left;
        int rightMarker = right;

        int pivot = array[leftMarker];
        while (leftMarker < rightMarker) {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            swap(array, leftMarker, rightMarker);
        }
        return leftMarker;
    }

    /**
     * Generates an array of random numbers of a given size.
     * 
     * @param size  The size of the array to generate.
     */
    private static int[] getRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(100);
        }

        return array;
    }
}