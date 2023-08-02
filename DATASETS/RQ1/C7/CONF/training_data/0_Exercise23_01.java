
public class BubbleSort {
    
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped = true;
        int lastUnsorted = list.length - 1;
        
        while (swapped) {
            swapped = false;
            for (int i = 0; i < lastUnsorted; i++) {
                if (list[i].compareTo(list[i+1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    swapped = true;
                }
            }
            lastUnsorted--;
        }
    }
    
    
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped = true;
        int lastUnsorted = list.length - 1;
        
        while (swapped) {
            swapped = false;
            for (int i = 0; i < lastUnsorted; i++) {
                if (comparator.compare(list[i], list[i+1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    swapped = true;
                }
            }
            lastUnsorted--;
        }
    }
}
