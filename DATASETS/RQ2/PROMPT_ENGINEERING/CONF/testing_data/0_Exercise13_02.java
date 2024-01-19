import java.util.ArrayList;
import java.util.Random;

public class ShuffleArrayList {

    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.0);
        numbers.add(3.0f);
        numbers.add(4L);

        System.out.println("Original ArrayList: " + numbers);
        shuffle(numbers);
        System.out.println("Shuffled ArrayList: " + numbers);
    }

    public static void shuffle(ArrayList<Number> list) {
        int size = list.size();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(size);

            // Swap elements at i and randomIndex
            Number temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }

        System.out.println("Shuffling complete!");
    }
}
