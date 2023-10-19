import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        int numIntegers = 5_000_000;

        // Create a LinkedList and populate it with integers
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numIntegers; i++) {
            linkedList.add(i);
        }

        // Test traversal with an iterator
        long startTimeIterator = System.nanoTime();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            // You can perform some operation with the value here
        }
        long endTimeIterator = System.nanoTime();
        long iteratorTime = endTimeIterator - startTimeIterator;

        // Test traversal with the get(index) method
        long startTimeGetIndex = System.nanoTime();
        for (int i = 0; i < numIntegers; i++) {
            int value = linkedList.get(i);
            // You can perform some operation with the value here
        }
        long endTimeGetIndex = System.nanoTime();
        long getIndexTime = endTimeGetIndex - startTimeGetIndex;

        System.out.println("Time taken using an iterator: " + iteratorTime / 1_000_000 + " ms");
        System.out.println("Time taken using get(index) method: " + getIndexTime / 1_000_000 + " ms");
    }
}