import java.util.Arrays;
import java.util.Comparator;

public class OrderChecker {
    public static void main(String[] args) {
        // Sample data
        int[] intArray = {1, 2, 3, 4, 5};
        double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] stringArray = {"apple", "banana", "cherry", "date", "fig"};

        // Check if arrays are ordered in ascending and descending order
        boolean isIntOrderedAsc = isOrdered(intArray);
        boolean isIntOrderedDesc = isOrdered(intArray, false);
        boolean isDoubleOrderedAsc = isOrdered(doubleArray);
        boolean isDoubleOrderedDesc = isOrdered(doubleArray, false);
        boolean isStringOrderedAsc = isOrdered(stringArray);
        boolean isStringOrderedDesc = isOrdered(stringArray, false);

        // Display results
        System.out.println("Integer Array (Ascending): " + isIntOrderedAsc);
        System.out.println("Integer Array (Descending): " + isIntOrderedDesc);
        System.out.println("Double Array (Ascending): " + isDoubleOrderedAsc);
        System.out.println("Double Array (Descending): " + isDoubleOrderedDesc);
        System.out.println("String Array (Ascending): " + isStringOrderedAsc);
        System.out.println("String Array (Descending): " + isStringOrderedDesc);
    }

    // Check if an array of comparable elements is ordered (ascending by default)
    public static <E extends Comparable<E>> boolean isOrdered(E[] array) {
        return isOrdered(array, true);
    }

    // Check if an array of comparable elements is ordered (ascending or descending)
    public static <E extends Comparable<E>> boolean isOrdered(E[] array, boolean ascending) {
        Comparator<E> comparator = ascending ? Comparator.naturalOrder() : Comparator.reverseOrder();
        return Arrays.equals(array, Arrays.stream(array).sorted(comparator).toArray());
    }
}