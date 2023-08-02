import java.util.Arrays;

public class SortAndPrintArray {
    public static void main(String[] args) {
        // Create an array of Comparable objects
        Integer[] numbers = {5, 2, 7, 1, 9};

        // Sort the array using the Arrays.sort() method
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println(Arrays.toString(numbers));
    }
}