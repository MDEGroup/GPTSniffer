import java.util.Scanner;

public class MonthlyFirstDays {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input for year
        System.out.print("Please enter the year (e.g., 2013): ");
        int year = input.nextInt();

        // Get user input for the first day of the year
        System.out.print("Please enter the first day of the year (1 for Sunday, 2 for Monday, ..., 7 for Saturday): ");
        int firstDayOfYear = input.nextInt();

        // Display the first day of each month
        for (int month = 1; month <= 12; month++) {
            int daysInMonth = getDaysInMonth(year, month);
            String monthName = getMonthName(month);

            // Determine the day of the week for the first day of the month
            int dayOfWeek = (firstDayOfYear + getTotalDaysElapsed(year, month)) % 7;

            // Display the result
            System.out.println(monthName + " 1, " + year + " is " + getDayName(dayOfWeek));

            // Update the first day for the next month
            firstDayOfYear = (firstDayOfYear + daysInMonth) % 7;
        }

        input.close();
    }

    // Function to get the number of days in a month
    private static int getDaysInMonth(int year, int month) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else {
            return daysInMonth[month];
        }
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to get the name of a month
    private static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    // Function to get the name of a day of the week
    private static String getDayName(int dayOfWeek) {
        String[] dayNames = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return dayNames[dayOfWeek];
    }

    // Function to get the total number of days elapsed since January 1, 1800
    private static int getTotalDaysElapsed(int year, int month) {
        int totalDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(year, i);
        }
        return totalDays;
    }
}