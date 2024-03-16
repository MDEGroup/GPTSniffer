import java.util.LinkedHashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        // Create the first linked hash set
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        // Create the second linked hash set
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        // Find the union of the two sets
        Set<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Find the difference of the two sets (elements in set1 but not in set2)
        Set<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);

        // Find the intersection of the two sets
        Set<String> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
    }
}
