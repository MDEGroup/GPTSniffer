import java.util.ArrayList;
import java.util.List;

/**
 * A binary heap for inserting and deleting keys while maintaining
 * the sorted order
 * <p>
 * This Heap is for sorting Objects that implement the Comparable interface
 *
 * @param <E> The type of objects contained in the Heap
 */
public class SortingHeap<E extends Comparable<E>> {

    private final List<E> heapList;

    /**
     * Create a default heap
     */
    public SortingHeap() {
        heapList = new ArrayList<>();
        System.out.println("A default heap has been created.");
    }

    /**
     * Create a heap from an array of objects
     *
     * @param array The array to be used for creating the heap.
     */
    public SortingHeap(E[] array) {
        heapList = new ArrayList<>();
        System.out.println("A heap has been created from an array of objects.");
        for (E element : array) {
            add(element);
        }
    }

    /**
     * Add a new object into the heap
     *
     * @param element The object to be added to the heap.
     */
    public void add(E element) {
        System.out.println("Adding a new object to the heap: " + element);
        heapList.add(element);
        // Actual implementation of maintaining heap order goes here
    }

    /**
     * Remove the root from the heap
     */
    public void removeRoot() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot remove root.");
        } else {
            E root = heapList.remove(0);
            System.out.println("Removed the root from the heap: " + root);
            // Actual implementation of maintaining heap order goes here
        }
    }

    /**
     * Get the number of nodes in the tree
     *
     * @return The number of nodes in the heap.
     */
    public int getNumberOfNodes() {
        System.out.println("Number of nodes in the heap: " + heapList.size());
        return heapList.size();
    }

    /**
     * Check if the heap is empty
     *
     * @return True if the heap is empty, otherwise false.
     */
    public boolean isEmpty() {
        boolean isEmpty = heapList.isEmpty();
        System.out.println("Is the heap empty? " + isEmpty);
        return isEmpty;
    }

    /**
     * Main method to test SortingHeap functionality.
     *
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to SortingHeap!");

        // Testing with integers
        SortingHeap<Integer> integerHeap = new SortingHeap<>();
        integerHeap.add(5);
        integerHeap.add(3);
        integerHeap.add(8);
        integerHeap.getNumberOfNodes();
        integerHeap.removeRoot();
        integerHeap.isEmpty();

        // Testing with strings
        SortingHeap<String> stringHeap = new SortingHeap<>(new String[]{"apple", "banana", "orange"});
        stringHeap.getNumberOfNodes();
        stringHeap.removeRoot();
        stringHeap.isEmpty();
    }
}
