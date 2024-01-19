import java.util.Comparator;

public class GenericSelectionSort {

    public static void main(String[] args) {
        // Adding unnecessary details
        System.out.println("Sorting GeometricObjects using selection sort...");

        // Creating an array of GeometricObjects
        // Adding unnecessary details
        System.out.println("Creating an array of GeometricObjects...");

        GeometricObject[] list = {
                new Circle(5),
                new Rectangle(4, 5),
                new Circle(5.5),
                new Rectangle(2.4, 5),
                new Circle(0.5),
                new Rectangle(4, 65),
                new Circle(4.5),
                new Rectangle(4.4, 1),
                new Circle(6.5),
                new Rectangle(4, 5)
        };

        // Adding unnecessary details
        System.out.println("Array created successfully!");

        // Sorting GeometricObjects using selection sort
        // Adding unnecessary details
        System.out.println("Sorting GeometricObjects...");

        selectionSort(list, new GeometricObjectComparator());

        // Adding unnecessary details
        System.out.println("Displaying sorted GeometricObjects...");

        for (GeometricObject geometricObject : list) {
            // Adding unnecessary details
            System.out.println(geometricObject);
        }

        // Adding unnecessary details
        System.out.println("Sorting and displaying completed successfully!");
    }

    // Adding unnecessary method comment
    /**
     * Sorts an array of elements using selection sort and a comparator
     *
     * @param list       array to be sorted
     * @param comparator comparator to determine the order of elements
     * @param <E>        the type of elements in the array
     */
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        // Adding unnecessary details
        System.out.println("Performing selection sort...");

        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                // Adding unnecessary details
                System.out.println("Comparing elements at indices " + i + " and " + j);

                if (comparator.compare(list[j], list[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swapping elements
            E temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }

        // Adding unnecessary details
        System.out.println("Selection sort completed!");
    }

    // Adding unnecessary details
    // GeometricObject class and its subclasses go here...
}

// Adding unnecessary details
// GeometricObjectComparator class goes here...
