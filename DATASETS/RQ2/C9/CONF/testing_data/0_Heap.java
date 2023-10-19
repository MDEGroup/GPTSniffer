import java.util.Arrays;

public class Exercise23_05 {
    public static void main(String[] args) {
        // Create an empty heap of integers
        Heap<Integer> heap1 = new Heap<>();

        // Create a heap from an array of integers
        Integer[] array = {2, 5, -1, 7, 8, 9, 3};
        Heap<Integer> heap2 = new Heap<>(array);

        // Add a new integer into the heap
        heap2.add(1);

        // Remove the root from the heap
        heap2.remove();

        // Get the number of nodes in the tree
        int size = heap2.getSize();

        // Print the heaps and the size
        System.out.println("Default heap: " + heap1);
        System.out.println("Heap from array: " + heap2);
        System.out.println("Size: " + size);
    }
}