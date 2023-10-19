import java.util.Calendar;

public class DefaultClock {
    private int hour;
    private int minute;
    private int second;
    private int width;
    private int height;

    /**
     * Constructs a clock with the current time as the default.
     */
    public DefaultClock() {
        setCurrentTime(); // Initialize with the current time.
        width = 100;      // Default width
        height = 100;     // Default height
    }

    /**
     * Constructs a clock with a specific hour, minute, and second.
     *
     * @param hour   The hour (0-23).
     * @param minute The minute (0-59).
     * @param second The second (0-59).
     */
    public DefaultClock(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        width = 100;  // Default width
        height = 100; // Default height
    }

    /**
     * Returns the current hour on the clock.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets a new hour on the clock.
     *
     * @param hour The hour to set (0-23).
     */
    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Hour should be in the range of 0 to 23.");
        }
    }

    /**
     * Returns the current minute on the clock.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets a new minute on the clock.
     *
     * @param minute The minute to set (0-59).
     */
    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Minute should be in the range of 0 to 59.");
        }
    }

    /**
     * Returns the current second on the clock.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets a new second on the clock.
     *
     * @param second The second to set (0-59).
     */
    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Second should be in the range of 0 to 59.");
        }
    }

    /**
     * Returns the width of the clock pane.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the clock pane.
     *
     * @param width The width to set.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the height of the clock pane.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the clock pane.
     *
     * @param height The height to set.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Updates the clock's time to the current time.
     */
    public void setCurrentTime() {
        Calendar now = Calendar.getInstance();
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);
    }
}