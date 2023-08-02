

import java.util.*;


public class Exercise21_01 {
    public static void main(String[] args) {

        LinkedHashSet<String> names1 = new LinkedHashSet<>(); // Creates a LinkedHashSet object with a default capacity
        // of 16
        LinkedHashSet<String> names2 = new LinkedHashSet<>(); // and default load factor of 0.75

        names1.add("George");
        names1.add("Jim");
        names1.add("John");
        names1.add("Blake");
        names1.add("Kevin");
        names1.add("Michael");

        names2.add("George");
        names2.add("Katie");
        names2.add("Kevin");
        names2.add("Michelle");
        names2.add("Ryan");

        LinkedHashSet<String> lhs1 = new LinkedHashSet<>();
        lhs1.addAll(names1);

        LinkedHashSet<String> lhs2 = new LinkedHashSet<>();
        lhs2.addAll(names2);

        // The union is a combination of all unique values from both sets
        names1.addAll(names2);
        System.out.println("Union is: " + names1);

        // The intersection is only the values occur in both sets
        LinkedHashSet<String> copyNames1 = new LinkedHashSet<String>(lhs1);
        copyNames1.retainAll(names2);
        System.out.println("Intersection is: " + copyNames1);

        // The difference is the union excluding common values
        names1.removeAll(copyNames1);
        System.out.println("Difference is: " + names1);


    }

}
