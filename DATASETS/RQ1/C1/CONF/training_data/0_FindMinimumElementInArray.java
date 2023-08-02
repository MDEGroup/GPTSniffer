public class LinearSearchMinElement {
    public static int findMin(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 1, 9, 2 };
        int min = findMin(arr);
        System.out.println("Minimum element in the array is: " + min);
    }
}

