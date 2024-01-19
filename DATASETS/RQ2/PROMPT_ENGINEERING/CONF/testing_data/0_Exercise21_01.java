import java.util.LinkedHashSet;

public class SetOperations {

    public static void main(String[] args) {
        // Create the first linked hash set
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        // Create the second linked hash set
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        // Clone the sets to preserve the original sets
        LinkedHashSet<String> set1Clone = new LinkedHashSet<>(set1);
        LinkedHashSet<String> set2Clone = new LinkedHashSet<>(set2);

        // Calculate and display the union of the sets
        set1Clone.addAll(set2Clone);
        System.out.println("Union of the sets: " + set1Clone);

        // Restore the cloned sets
        set1Clone = new LinkedHashSet<>(set1);
        set2Clone = new LinkedHashSet<>(set2);

        // Calculate and display the difference between set1 and set2
        set1Clone.removeAll(set2Clone);
        System.out.println("Difference (set1 - set2): " + set1Clone);

        // Restore the cloned sets
        set1Clone = new LinkedHashSet<>(set1);
        set2Clone = new LinkedHashSet<>(set2);

        // Calculate and display the intersection of the sets
        set1Clone.retainAll(set2Clone);
        System.out.println("Intersection of the sets: " + set1Clone);
    }
}