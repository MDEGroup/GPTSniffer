import java.util.Comparator;

public class QuickSort {
    /**
     * Sorts the elements in the given array using the Comparable interface.
     *
     * @param list the array of elements to be sorted
     */
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    /**
     * Sorts the elements in the given array using the Comparator interface.
     *
     * @param list       the array of elements to be sorted
     * @param comparator the comparator used to compare the elements
     */
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <E extends Comparable<E>> void quickSort(E[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static <E> void quickSort(E[] list, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] list, int low, int high) {
        E pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list[j].compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);

        return i + 1;
    }

    private static <E> int partition(E[] list, int low, int high, Comparator<? super E> comparator) {
        E pivot = list[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list[j], pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);

        return i + 1;
    }

    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}