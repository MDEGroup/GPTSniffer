import java.util.PriorityQueue;

public class SetOperationsOnPriorityQueues {
    public static void main(String[] args) {
        // Create two priority queues
        PriorityQueue<String> pq1 = new PriorityQueue<>();
        pq1.add("George");
        pq1.add("Jim");
        pq1.add("John");
        pq1.add("Blake");
        pq1.add("Kevin");
        pq1.add("Michael");

        PriorityQueue<String> pq2 = new PriorityQueue<>();
        pq2.add("George");
        pq2.add("Katie");
        pq2.add("Kevin");
        pq2.add("Michelle");
        pq2.add("Ryan");

        // Union of pq1 and pq2
        PriorityQueue<String> union = new PriorityQueue<>(pq1);
        union.addAll(pq2);
        System.out.println("Union: " + union);

        // Difference of pq1 and pq2
        PriorityQueue<String> difference = new PriorityQueue<>(pq1);
        difference.removeAll(pq2);
        System.out.println("Difference: " + difference);

        // Intersection of pq1 and pq2
        PriorityQueue<String> intersection = new PriorityQueue<>(pq1);
        intersection.retainAll(pq2);
        System.out.println("Intersection: " + intersection);
    }
}
