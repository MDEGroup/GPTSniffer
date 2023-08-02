public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}



// This program defines a function bubbleSort() which takes an integer array as input and sorts it using the bubble sort algorithm. The outer loop runs for n-1 iterations, where n is the number of elements in the array, and the inner loop runs for n-i-1 iterations. In each iteration, the program compares the current element with the next element. If the current element is greater than the next element, the two elements are swapped.

// In the main method, an array is taken as input and passed to the bubbleSort() function to sort the array, then the sorted array is printed using the printArray() function.

// The time complexity of bubble sort is O(n^2) in worst and average case but it has the advantage of being easy to understand and implement.
