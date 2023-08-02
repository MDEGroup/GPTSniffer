
public class LocalityOfReferenceSearch {

    private static final int CACHE_SIZE = 3; 

    public static int search(int[] arr, int x) {
        int cache[] = new int[CACHE_SIZE]; 
        Arrays.fill(cache, -1);

        int n = arr.length;
        int i = 0;
        while (i < n) {
            boolean found = false;
            for (int j = 0; j < CACHE_SIZE; j++) {
                if (cache[j] == arr[i]) { 
                    return i;
                }
            }
            for (int j = 0; j < CACHE_SIZE - 1; j++) {
                cache[j] = cache[j + 1]; 
            }
            cache[CACHE_SIZE - 1] = arr[i]; 
            i++;
        }
        return -1; 
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

