import java.util.Arrays;

public class LocalityOfReferenceSearch {

    private static final int CACHE_SIZE = 3; // Size of the cache

    public static int search(int[] arr, int x) {
        int cache[] = new int[CACHE_SIZE]; // Cache to store recently accessed elements
        Arrays.fill(cache, -1);

        int n = arr.length;
        int i = 0;
        while (i < n) {
            boolean found = false;
            for (int j = 0; j < CACHE_SIZE; j++) {
                if (cache[j] == arr[i]) { // If element is in cache, return its index
                    return i;
                }
            }
            for (int j = 0; j < CACHE_SIZE - 1; j++) {
                cache[j] = cache[j + 1]; // Shift the cache
            }
            cache[CACHE_SIZE - 1] = arr[i]; // Add current element to cache
            i++;
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int x = 5;
        int index = search(arr, x);
        if (index != -1) {
            System.out.println("Element " + x + " found at index " + index);
        } else {
            System.out.println("Element " + x + " not found");
        }
    }
}

