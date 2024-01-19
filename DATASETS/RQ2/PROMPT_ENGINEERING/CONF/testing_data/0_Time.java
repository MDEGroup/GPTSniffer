// Let's create our Time class
public class Time {
    private int hour;
    private int minute;
    private int second;

    // First, we'll create a no-arg constructor
    public Time() {
        // We need to get the current time in milliseconds
        long currentTimeInMillis = System.currentTimeMillis();

        // Let's calculate the hour, minute, and second
        this.hour = (int) (currentTimeInMillis / 3600000) % 24;
        this.minute = (int) (currentTimeInMillis / 60000) % 60;
        this.second = (int) (currentTimeInMillis / 1000) % 60;
    }

    // Now, we'll create a constructor that takes elapsed time in milliseconds
    public Time(long elapsedTime) {
        // Similar to the no-arg constructor, let's calculate the time components
        this.hour = (int) (elapsedTime / 3600000) % 24;
        this.minute = (int) (elapsedTime / 60000) % 60;
        this.second = (int) (elapsedTime / 1000) % 60;
    }

    // We'll create another constructor for specifying hour, minute, and second
    public Time(int hour, int minute, int second) {
        // Here, we'll just set the provided values
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Now, let's create getter methods for hour, minute, and second
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // We also need a method to set the time using elapsed time
    public void setTime(long elapsedTime) {
        this.hour = (int) (elapsedTime / 3600000) % 24;
        this.minute = (int) (elapsedTime / 60000) % 60;
        this.second = (int) (elapsedTime / 1000) % 60;
    }

    // Now, let's display the time in the format "hour:minute:second"
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Finally, let's create a test program
    public static void main(String[] args) {
        // Create Time objects using different constructors
        Time currentTime = new Time();
        Time elapsed = new Time(555550000);
        Time specified = new Time(5, 23, 55);

        // Display their time values
        System.out.println("Current Time: " + currentTime);
        System.out.println("Elapsed Time: " + elapsed);
        System.out.println("Specified Time: " + specified);
    }
}