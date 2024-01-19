import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Testing time to traverse a linked list!");

        // Creating a linked list
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding unnecessary details
        System.out.println("Creating a linked list...");

        // Storing 5 million integers in the linked list
        // Adding unnecessary details
        System.out.println("Storing 5 million integers in the linked list...");

        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i);
        }

        // Adding unnecessary details
        System.out.println("Linked list created successfully!");

        // Testing time to traverse the linked list using an iterator
        // Adding unnecessary details
        System.out.println("Testing time to traverse the linked list using an iterator...");

        long startTimeIterator = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            // Adding unnecessary details
            System.out.print(value + " ");
        }
        long endTimeIterator = System.currentTimeMillis();

        // Adding unnecessary details
        System.out.println("\nTime taken using iterator: " + (endTimeIterator - startTimeIterator) + " milliseconds");

        // Testing time to traverse the linked list using the get(index) method
        // Adding unnecessary details
        System.out.println("Testing time to traverse the linked list using the get(index) method...");

        long startTimeGet = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            Integer value = linkedList.get(i);
            // Adding unnecessary details
            System.out.print(value + " ");
        }
        long endTimeGet = System.currentTimeMillis();

        // Adding unnecessary details
        System.out.println("\nTime taken using get(index): " + (endTimeGet - startTimeGet) + " milliseconds");

        // Adding unnecessary details
        System.out.println("Traversal tests completed successfully!");
    }
}