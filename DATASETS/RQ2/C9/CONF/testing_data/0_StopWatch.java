import java.util.concurrent.TimeUnit;

public class StopWatch {
    private long startTimeMillis;
    private long endTimeMillis;

    public StopWatch() {
        // Initialize the start time to the current system time in milliseconds
        startTimeMillis = System.currentTimeMillis();
    }

    public void start() {
        // Reset the start time to the current system time in milliseconds
        startTimeMillis = System.currentTimeMillis();
    }

    public void stop() {
        // Set the end time to the current system time in milliseconds
        endTimeMillis = System.currentTimeMillis();
    }

    public long getElapsedTimeMillis() {
        // Calculate and return the elapsed time in milliseconds
        return endTimeMillis - startTimeMillis;
    }

    public long getElapsedTimeSeconds() {
        // Calculate and return the elapsed time in seconds
        return TimeUnit.MILLISECONDS.toSeconds(getElapsedTimeMillis());
    }

    public long getElapsedTimeMinutes() {
        // Calculate and return the elapsed time in minutes
        return TimeUnit.MILLISECONDS.toMinutes(getElapsedTimeMillis());
    }
}