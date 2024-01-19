public class DateTest {
    public static void main(String[] args) {
        // Creating a MyDate object using the default constructor
        MyDate date1 = new MyDate();
        
        // Creating a MyDate object with a specific elapsed time
        MyDate date2 = new MyDate(34355555133101L);
        
        // Displaying the year, month, and day for date1
        System.out.println("Date 1 - Year: " + date1.getYear() + ", Month: " + date1.getMonth() + ", Day: " + date1.getDay());
        
        // Displaying the year, month, and day for date2
        System.out.println("Date 2 - Year: " + date2.getYear() + ", Month: " + date2.getMonth() + ", Day: " + date2.getDay());
    }
}
public class MyDate {
    private long elapsedTime;

    public MyDate() {
        this.elapsedTime = System.currentTimeMillis();
    }

    public MyDate(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getYear() {
        // Calculating the year from elapsed time
        // This may not be very accurate, but it's a simple way to do it
        long totalDays = elapsedTime / (1000 * 60 * 60 * 24);
        int year = 1970; // The epoch year
        int daysInYear;
        
        while (true) {
            daysInYear = isLeapYear(year) ? 366 : 365;
            if (totalDays < daysInYear) {
                break;
            }
            totalDays -= daysInYear;
            year++;
        }
        
        return year;
    }

    public int getMonth() {
        // Calculating the month from elapsed time
        // This is a very simplified approach and may not be very accurate
        int month = 1;
        long totalDays = elapsedTime / (1000 * 60 * 60 * 24);
        int daysInMonth;

        while (true) {
            daysInMonth = getDaysInMonth(getYear(), month);
            if (totalDays < daysInMonth) {
                break;
            }
            totalDays -= daysInMonth;
            month++;
        }

        return month;
    }

    public int getDay() {
        // Calculating the day from elapsed time
        // This is also a simplified approach
        long totalDays = elapsedTime / (1000 * 60 * 60 * 24);
        int month = getMonth();
        int year = getYear();
        int daysInMonth = getDaysInMonth(year, month);

        return (int) (totalDays + 1);
    }

    // Helper method to check if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Helper method to get the number of days in a specific month of a year
    private int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // Invalid month
        }
    }
}
