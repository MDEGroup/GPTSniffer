import java.util.Arrays;

// Stopwatch class
class Stopwatch {
    private long startTime;
    private long endTime;

    // Constructor initializing startTime with the current time
    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    // Getter method for startTime
    public long getStartTime() {
        return startTime;
    }

    // Getter method for endTime
    public long getEndTime() {
        return endTime;
    }

    // Method to reset startTime to current time
    public void start() {
        startTime = System.currentTimeMillis();
    }

    // Method to set endTime to current time
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Method to calculate elapsed time in milliseconds
    public long getElapsedTime() {
        return endTime - startTime;
    }
}

// Test program for measuring execution time of selection sort on 100,000 numbers
public class SelectionSortTest {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(100000);
        Stopwatch stopwatch = new Stopwatch();

        selectionSort(numbers);

        stopwatch.stop();

        System.out.println("Execution time for sorting 100,000 numbers using selection sort: "
                + stopwatch.getElapsedTime() + " milliseconds");
    }

    // Selection sort algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to generate an array of random integers
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        return arr;
    }
}