import com.ibm.icu.util.ChineseCalendar;
import java.util.Scanner;

public class LunarMonthDays {
    public static void main(String[] args) {
        // Create a scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the lunar month and year
        System.out.print("Enter the lunar month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the lunar year: ");
        int year = scanner.nextInt();

        // Create a Chinese Calendar object for the given year and month
        ChineseCalendar calendar = new ChineseCalendar();
        calendar.set(ChineseCalendar.EXTENDED_YEAR, year + 2637); // Convert from the lunar year to the Gregorian year
        calendar.set(ChineseCalendar.MONTH, month - 1); // ChineseCalendar.MONTH is 0-based

        // Compute the number of days in the lunar month
        int days = calendar.getActualMaximum(ChineseCalendar.DAY_OF_MONTH);

        // Output the result
        System.out.println("The number of days in the lunar month is " + days);
    }
}


