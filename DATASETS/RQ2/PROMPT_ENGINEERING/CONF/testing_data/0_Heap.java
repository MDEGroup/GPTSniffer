import java.util.ArrayList;
import java.util.List;

/**
 * Heap - A class for heap operations
 *
 * @param <E> Type of Heap nodes
 */
public class Heap<E> {

    private final List<E> heapList; // List to store the elements in the heap

    /**
     * Default constructor to create a heap
     */
    public Heap() {
        heapList = new ArrayList<>();
        System.out.println("Heap - A default heap has been created.");
    }

    /**
     * Constructor to create a heap from an array of objects
     *
     * @param array The array to create the heap from
     */
    public Heap(E[] array) {
        heapList = new ArrayList<>();
        System.out.println("Heap - A heap has been created from an array of objects.");
        for (E element : array) {
            addToHeap(element);
        }
    }

    /**
     * Add a new object into the heap
     *
     * @param element The object to be added
     */
    public void addToHeap(E element) {
        System.out.println("Heap - Adding a new object to the heap: " + element);
        heapList.add(element);
        // Actual implementation of maintaining heap order goes here
    }

    /**
     * Remove the root from the heap
     */
    public void removeRoot() {
        if (isEmpty()) {
            System.out.println("Heap - Heap is empty. Cannot remove root.");
        } else {
            E root = heapList.remove(0);
            System.out.println("Heap - Removed the root from the heap: " + root);
            // Actual implementation of maintaining heap order goes here
        }
    }

    /**
     * Get the number of nodes in the tree
     *
     * @return The number of nodes in the heap
     */
    public int getNumberOfNodes() {
        System.out.println("Heap - Number of nodes in the heap: " + heapList.size());
        return heapList.size();
    }

    /**
     * Check if the heap is empty
     *
     * @return True if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        boolean isEmpty = heapList.isEmpty();
        System.out.println("Heap - Is the heap empty? " + isEmpty);
        return isEmpty;
    }

    /**
     * Main method for testing heap operations
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Heap operations!");

        // Testing with integers
        Heap<Integer> integerHeap = new Heap<>();
        integerHeap.addToHeap(5);
        integerHeap.addToHeap(3);
        integerHeap.addToHeap(8);
        integerHeap.getNumberOfNodes();
        integerHeap.removeRoot();
        integerHeap.isEmpty();

        // Testing with strings
        Heap<String> stringHeap = new Heap<>(new String[]{"apple", "banana", "orange"});
        stringHeap.getNumberOfNodes();
        stringHeap.removeRoot();
        stringHeap.isEmpty();
    }
}