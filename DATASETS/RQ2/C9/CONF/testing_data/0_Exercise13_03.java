import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSorter {

    public static void sortList(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        System.out.println("Original List: " + numbers);
        sortList(numbers);
        System.out.println("Sorted List: " + numbers);
    }
}