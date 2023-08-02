public class TernarySearch {
    
    public static int ternarySearch(int[] arr, int x, int left, int right) {
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == x) {
                return mid1;
            } else if (arr[mid2] == x) {
                return mid2;
            } else if (x < arr[mid1]) {
                right = mid1 - 1;
            } else if (x > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 8, 9, 10, 12, 13, 15, 17, 19, 20, 21, 22 };
        int x = 10;
        
        int result = ternarySearch(arr, x, 0, arr.length - 1);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}





