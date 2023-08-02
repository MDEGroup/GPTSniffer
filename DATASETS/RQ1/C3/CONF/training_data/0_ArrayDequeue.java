import java.util.concurrent.locks.Condition;
import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // Create a new ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add elements to the deque
        deque.add("apple");
        deque.add("banana");
        deque.add("cherry");
        deque.add("date");
        deque.add("elderberry");
        System.out.println("Initial ArrayDeque: " + deque);

        // Remove elements from the deque
        System.out.println("Removed element: " + deque.remove());
        System.out.println("Removed first element: " + deque.removeFirst());
        System.out.println("Removed last element: " + deque.removeLast());
        System.out.println("Updated ArrayDeque: " + deque);

        // Get elements from the deque
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        // Check if the deque contains an element
        System.out.println("Does deque contain 'banana'? " + deque.contains("banana"));
        System.out.println("Does deque contain 'fig'? " + deque.contains("fig"));

        // Get the size of the deque
        System.out.println("Size of deque: " + deque.size());

        // Clear the deque
        deque.clear();
        System.out.println("Cleared ArrayDeque: " + deque);
    }
}

