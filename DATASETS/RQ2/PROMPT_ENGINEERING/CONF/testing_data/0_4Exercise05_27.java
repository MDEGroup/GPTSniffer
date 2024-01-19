import java.util.Scanner;

public class FirstDayOfMonthProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the First Day of Each Month Program!");

        // Get the year from the user
        System.out.print("Enter the year (e.g., 2013): ");
        int year = input.nextInt();

        // Get the first day of the year from the user
        System.out.print("Enter the first day of the year (1 for Sunday, 2 for Monday, ..., 7 for Saturday): ");
        int firstDay = input.nextInt();

        // Display the first day of each month
        System.out.println("\nFirst day of each month in " + year + ":\n");

        for (int month = 1; month <= 12; month++) {
            // Display the month name
            System.out.print(getMonthName(month) + " 1, " + year + " is ");

            // Display the day of the week
            System.out.println(getDayOfWeek(firstDay));

            // Update the first day for the next month
            firstDay = (firstDay + getNumberOfDaysInMonth(month, year)) % 7;
        }

        // Close the scanner
        input.close();
    }

    // Method to get the month name
    private static String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    // Method to get the day of the week
    private static String getDayOfWeek(int day) {
        String[] dayOfWeek = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        return dayOfWeek[day - 1];
    }

    // Method to get the number of days in a month
    private static int getNumberOfDaysInMonth(int month, int year) {
        if (month == 2) {
            return (isLeapYear(year)) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    // Method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}