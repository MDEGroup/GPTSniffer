import java.util.LinkedHashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        // Create the first LinkedHashSet
        Set<String> set1 = createLinkedHashSet("George", "Jim", "John", "Blake", "Kevin", "Michael");

        // Create the second LinkedHashSet
        Set<String> set2 = createLinkedHashSet("George", "Katie", "Kevin", "Michelle", "Ryan");

        // Clone the sets to preserve the original sets
        Set<String> cloneSet1 = new LinkedHashSet<>(set1);
        Set<String> cloneSet2 = new LinkedHashSet<>(set2);

        // Union (combine both sets)
        cloneSet1.addAll(cloneSet2);
        System.out.println("Union: " + cloneSet1);

        // Difference (elements in set1 but not in set2)
        cloneSet1 = new LinkedHashSet<>(set1);
        cloneSet1.removeAll(cloneSet2);
        System.out.println("Difference (set1 - set2): " + cloneSet1);

        // Intersection (common elements in both sets)
        cloneSet1 = new LinkedHashSet<>(set1);
        cloneSet1.retainAll(cloneSet2);
        System.out.println("Intersection: " + cloneSet1);
    }

    // Helper method to create a LinkedHashSet from an array of elements
    private static Set<String> createLinkedHashSet(String... elements) {
        Set<String> set = new LinkedHashSet<>();
        for (String element : elements) {
            set.add(element);
        }
        return set;
    }
}