import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberShuffler {

    public static void shuffleList(List<Integer> list) {
        int size = list.size();
        Random random = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap elements at indices i and j
            Collections.swap(list, i, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Original List: " + numbers);
        shuffleList(numbers);
        System.out.println("Shuffled List: " + numbers);
    }
}