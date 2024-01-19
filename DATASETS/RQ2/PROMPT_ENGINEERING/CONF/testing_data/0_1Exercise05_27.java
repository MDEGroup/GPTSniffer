import java.util.Scanner;

public class MonthDaysDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the year from the user
        System.out.print("Enter the year (e.g., 2013): ");
        int year = input.nextInt();

        // Get the first day of the year from the user
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, ..., 6 for Saturday): ");
        int firstDay = input.nextInt();

        // Display the header
        System.out.println("Month\t\tFirst Day");

        // Loop through each month
        for (int month = 1; month <= 12; month++) {
            // Get the first day of the current month
            int dayOfWeek = (firstDay + getTotalDays(year, month - 1)) % 7;

            // Display the result
            System.out.print(getMonthName(month) + " 1, " + year + " is ");
            displayDayOfWeek(dayOfWeek);

            // Set firstDay for the next month
            firstDay = (dayOfWeek + getMonthDays(year, month - 1)) % 7;
        }

        input.close();
    }

    // Function to get the name of the month
    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                               "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

    // Function to get the total number of days from 1800 to the specified month
    private static int getTotalDays(int year, int month) {
        int totalDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            totalDays += getMonthDays(year, i - 1);
        }

        return totalDays;
    }

    // Function to get the number of days in a month
    private static int getMonthDays(int year, int month) {
        if (month == 1) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            int[] daysInMonth = {31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return daysInMonth[month];
        }
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to display the day of the week
    private static void displayDayOfWeek(int dayOfWeek) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println(dayNames[dayOfWeek]);
    }
}