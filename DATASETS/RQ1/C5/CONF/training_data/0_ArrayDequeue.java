import java.util.concurrent.locks.Condition;
import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        
        ArrayDeque<String> deque = new ArrayDeque<>();

        
        deque.add("apple");
        deque.add("banana");
        deque.add("cherry");
        deque.add("date");
        deque.add("elderberry");
        System.out.println("Initial ArrayDeque: " + deque);

        
        System.out.println("Removed element: " + deque.remove());
        System.out.println("Removed first element: " + deque.removeFirst());
        System.out.println("Removed last element: " + deque.removeLast());
        System.out.println("Updated ArrayDeque: " + deque);

        
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        
        System.out.println("Does deque contain 'banana'? " + deque.contains("banana"));
        System.out.println("Does deque contain 'fig'? " + deque.contains("fig"));

        
        System.out.println("Size of deque: " + deque.size());

        
        deque.clear();
        System.out.println("Cleared ArrayDeque: " + deque);
    }
}

