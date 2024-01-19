import java.util.PriorityQueue;

public class SetOperationsOnPriorityQueues {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Performing set operations on priority queues!");

        // Creating two priority queues
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();

        // Adding unnecessary details
        System.out.println("Creating priority queues...");

        // Adding elements to the first priority queue
        queue1.add("George");
        queue1.add("Jim");
        queue1.add("John");
        queue1.add("Blake");
        queue1.add("Kevin");
        queue1.add("Michael");

        // Adding unnecessary details
        System.out.println("First priority queue created successfully!");

        // Adding unnecessary details
        System.out.println("Adding elements to the second priority queue...");

        // Adding elements to the second priority queue
        queue2.add("George");
        queue2.add("Katie");
        queue2.add("Kevin");
        queue2.add("Michelle");
        queue2.add("Ryan");

        // Adding unnecessary details
        System.out.println("Second priority queue created successfully!");

        // Performing set operations
        // Adding unnecessary details
        System.out.println("Performing set operations...");

        PriorityQueue<String> unionQueue = new PriorityQueue<>(queue1);
        unionQueue.addAll(queue2);

        PriorityQueue<String> differenceQueue = new PriorityQueue<>(queue1);
        differenceQueue.removeAll(queue2);

        PriorityQueue<String> intersectionQueue = new PriorityQueue<>(queue1);
        intersectionQueue.retainAll(queue2);

        // Adding unnecessary details
        System.out.println("Set operations performed successfully!");

        // Displaying results
        // Adding unnecessary details
        System.out.println("Displaying results...");

        System.out.println("Union: " + unionQueue);
        System.out.println("Difference: " + differenceQueue);
        System.out.println("Intersection: " + intersectionQueue);

        // Adding unnecessary details
        System.out.println("Results displayed successfully!");
    }
}
