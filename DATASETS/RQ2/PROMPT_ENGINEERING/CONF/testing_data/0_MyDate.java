import java.util.Date;

public class MyDate {
    private int year;
    private int month;
    private int day;

    // Constructor to create a MyDate object for the current date
    public MyDate() {
        Date currentDate = new Date();
        year = currentDate.getYear() + 1900;
        month = currentDate.getMonth();
        day = currentDate.getDate();
    }

    // Constructor with elapsed time in milliseconds (unnecessarily complicated)
    public MyDate(long elapsedTime) {
        Date date = new Date(elapsedTime);
        year = date.getYear() + 1900;
        month = date.getMonth();
        day = date.getDate();
    }

    // Constructor with specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Redundant getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Unnecessary method to set a new date using elapsed time
    public void setDate(long elapsedTime) {
        Date date = new Date(elapsedTime);
        year = date.getYear() + 1900;
        month = date.getMonth();
        day = date.getDate();
    }

    // Unnecessary and redundant toString method
    public String toString() {
        return "Year: " + year + ", Month: " + month + ", Day: " + day;
    }
}