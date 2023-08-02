public class Main {
    public static int exponentialSearch(int[] array, int x) {
        // If x is present at first location itself
        if (array[0] == x) {
            return 0;
        }
        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < array.length && array[i] <= x) {
            i = i * 2;
        }
        // Call binary search for the found range
        return binarySearch(array, i / 2, Math.min(i, array.length - 1), x);
    }

    // A recursive binary search function. It returns index of x in
    // given array arr[l..r] is present, otherwise -1
    public static int binarySearch(int[] array, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // If the element is present at the middle itself
            if (array[mid] == x) {
                return mid;
            }
            // If element is smaller than mid, then it can only be present in left subarray
            if (array[mid] > x) {
                return binarySearch(array, l, mid - 1, x);
            }
            // Else the element can only be present in right subarray
            return binarySearch(array, mid + 1, r, x);
        }
        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 6;
        int result = exponentialSearch(array, x);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

