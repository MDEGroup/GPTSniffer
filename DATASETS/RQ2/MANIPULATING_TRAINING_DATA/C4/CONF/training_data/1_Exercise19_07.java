

import java.util.Arrays;


public class Exercise19_07 {
    public static void main(String[] args) {
        Double searchKey = 111.11;
        Double[] values = new Double[]{4400.1, 1203.3, 3100.0, 18700.8, 4100.6, 111.11, 2222.21, 4529.21};

        System.out.println("Generic Binary Search method found the search key value: " + searchKey + " at index: " + binarySearch(values,
                searchKey) + " in the above array.");

    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        System.out.println("Sorting the array to ensure binarySearch is supported: ");
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int lowIdx = 0; 
        int highIdx = list.length - 1; 
        while (highIdx >= lowIdx) {
            int midIdx = (lowIdx + highIdx) / 2;
            int compare = key.compareTo(list[midIdx]); 
            if (compare < 0) { 
                highIdx = midIdx - 1; 
            } else if (compare == 0) { 
                return midIdx; 
            } else { 
                lowIdx = midIdx + 1; 
            }
        }
        return -1; 
    }
}
