// Welcome to the FibonacciSeriesCalculator program!

public class FibonacciSeriesCalculator {

    // Static variable to keep track of the number of times the fib method is called
    private static int fibMethodCallCount = 0;

    public static void main(String[] args) {
        // Prompting the user to enter the index for Fibonacci series
        System.out.print("Enter an index for the Fibonacci series: ");

        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Reading the entered index
        int index = scanner.nextInt();

        // Calculating and displaying the Fibonacci number at the specified index
        long result = fib(index);
        System.out.println("The Fibonacci number at index " + index + " is: " + result);

        // Displaying the number of times the fib method is called
        System.out.println("The fib method was called " + fibMethodCallCount + " times.");

        // Closing the Scanner
        scanner.close();
    }

    // Recursive method to calculate the Fibonacci number at a given index
    public static long fib(int index) {
        // Incrementing the counter for each call to fib method
        fibMethodCallCount++;

        // Base cases
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            // Recursive case: sum of the two previous Fibonacci numbers
            return fib(index - 1) + fib(index - 2);
        }
    }
}
