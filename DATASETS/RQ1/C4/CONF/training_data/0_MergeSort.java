import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            } else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }
}

