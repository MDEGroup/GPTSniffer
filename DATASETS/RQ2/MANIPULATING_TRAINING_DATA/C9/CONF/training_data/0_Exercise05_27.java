import java.util.Scanner;

public class FirstDayOfMonth {
    public static void main(String[] args) {
        // Prompt the user to enter the year and first day of the year
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, etc.): ");
        int firstDay = input.nextInt();

        // Define a list of month names and the number of days in each month
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28 + (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Display the first day of each month in the year
        for (int i = 0; i < 12; i++) {
            // Determine the first day of the current month
            int firstDayOfMonth = (firstDay + ((i == 0) ? 0 : daysInMonth[i - 1])) % 7;

            // Display the first day of the current month
            System.out.printf("%s 1, %d is %s\n", monthNames[i], year, getDayName(firstDayOfMonth));

            // Update the first day for the next month
            firstDay = firstDayOfMonth;
        }
    }

    // Returns the name of a day given its number (0 = Sunday, 1 = Monday, etc.)
    private static String getDayName(int day) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[day];
    }
}