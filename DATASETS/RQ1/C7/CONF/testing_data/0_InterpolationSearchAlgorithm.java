public class InterpolationSearch {
    public static int search(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (lo == hi) {
                if (arr[lo] == x)
                    return lo;
                return -1;
            }

            
            int pos = lo + ((x - arr[lo]) * (hi - lo)) / (arr[hi] - arr[lo]);

            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                lo = pos + 1;
            else
                hi = pos - 1;
        }
        return -1;
    }

    
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int x = 12;
        int index = search(arr, x);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

public static void main(String[] args) {
    int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
    int x = 15;
    int index = search(arr, x);
    if (index != -1) {
        System.out.println("Element found at index " + index);
    } else {
        System.out.println("Element not found");
    }
}
}



