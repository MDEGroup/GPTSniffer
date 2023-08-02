

import java.util.Arrays;
import java.util.Comparator;


public class GenericHeapSort{

    
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        System.out.println("Sort using Comparable interface: ");
        heapSort(list);
        System.out.println(Arrays.toString(list));

        Integer[] list2 = {44, 5, -3, 3, 5, 3, 12, -11, -55, 411, 125, 14, -4, 5, 66, 6, -6};
        System.out.println("Sort using Comparator interface: ");
        heapSort(list2, (o1, o2) -> {
            if (o1 > o2) return 1;
            if (o2 > o1) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(list2));
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        ComparableHeap<E> comparableHeap = new ComparableHeap<>();
        for (E e : list)
            comparableHeap.add(e);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = comparableHeap.remove();
    }


    public static <E> void heapSort(E[] list,
                                    Comparator<? super E> comparator) {
        Heap<E> heap = new Heap<>(comparator);

        for (E e : list)
            heap.add(e);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();

    }
}