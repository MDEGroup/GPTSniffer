

import java.util.ArrayList;
import java.util.Arrays;


public class nan {
    public static void main(String[] args) {
        
        ArrayList<Double> doubleList =
                new ArrayList<>(Arrays.asList(4400.0, 2.2, 6.6, 4400.1, 4.4, 7.7, 1.1, 8.8, 3.3, 5.5, 1203.3, 4400.2,
                        4400.6, 55.2));
        
        ArrayList<Integer> integerList =
                new ArrayList<>(Arrays.asList(55, 66, 33, 11, 77, 44, 88, 22));

        System.out.println("The max(ArrayList<E> list) method with a list Doubles returned: " + max(doubleList));
        System.out.println("The max(ArrayList<E> list) method with a list of Integers returned: " + max(integerList));

    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (!list.isEmpty()) {
            E maxValue = list.get(0); 
            for (int i = 1; i < list.size(); i++) {
                E nextValue = list.get(i); 
                if (maxValue.compareTo(nextValue) < 0) { 
                    maxValue = list.get(i); 
                }
            }
            return maxValue;
        }
        throw new IllegalArgumentException("public static <E extends Comparable<E>> E max(ArrayList<E> list) must be " +
                "passed a NON-empty list.");
    }
}



