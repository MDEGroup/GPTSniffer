import java.util.ArrayList;
import java.util.Collections;

public class SortArrayList {

    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(4.0);
        numbers.add(1);
        numbers.add(3.0);
        numbers.add(2.0f);

        System.out.println("Original ArrayList: " + numbers);
        sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);
    }

    public static void sort(ArrayList<Number> list) {
        int size = list.size();

        // Bubble sort algorithm (a very simple sorting method)
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < size; i++) {
                if (list.get(i - 1).doubleValue() > list.get(i).doubleValue()) {
                    // Swap elements at i-1 and i
                    Number temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
        
        System.out.println("Sorting complete!");
    }
}