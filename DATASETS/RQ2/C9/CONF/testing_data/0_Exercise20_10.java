import java.util.PriorityQueue;

public class PriorityQueueOperations {
    public static void main(String[] args) {
        PriorityQueue<String> firstSet = new PriorityQueue<>();
        firstSet.add("George");
        firstSet.add("Jim");
        firstSet.add("John");
        firstSet.add("Blake");
        firstSet.add("Kevin");
        firstSet.add("Michael");

        PriorityQueue<String> secondSet = new PriorityQueue<>();
        secondSet.add("George");
        secondSet.add("Katie");
        secondSet.add("Kevin");
        secondSet.add("Michelle");
        secondSet.add("Ryan");

        // Union
        PriorityQueue<String> unionSet = new PriorityQueue<>(firstSet);
        unionSet.addAll(secondSet);
        System.out.println("Union: " + unionSet);

        // Difference
        PriorityQueue<String> differenceSet = new PriorityQueue<>(firstSet);
        differenceSet.removeAll(secondSet);
        System.out.println("Difference: " + differenceSet);

        // Intersection
        PriorityQueue<String> intersectionSet = new PriorityQueue<>(firstSet);
        intersectionSet.retainAll(secondSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}