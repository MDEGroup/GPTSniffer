// Stopwatch class to measure elapsed time in milliseconds
public class StopWatch {
    private long startTime; // Variable to hold start time
    private long endTime;   // Variable to hold end time

    // No-arg constructor initializes startTime with the current time
    public StopWatch() {
        startTime = System.currentTimeMillis(); // Set start time
    }

    // Method to reset startTime to the current time
    public void start() {
        startTime = System.currentTimeMillis(); // Reset start time
    }

    // Method to set endTime to the current time
    public void stop() {
        endTime = System.currentTimeMillis(); // Set end time
    }

    // Method to calculate elapsed time in milliseconds
    public long getElapsedTime() {
        return endTime - startTime; // Calculate and return elapsed time
    }
}