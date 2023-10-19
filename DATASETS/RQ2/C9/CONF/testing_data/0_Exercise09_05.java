import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

    public static void main(String[] args) {
        // Create a GregorianCalendar instance to represent the current date and time.
        GregorianCalendar currentDate = new GregorianCalendar();

        // Display the current year, month, and day.
        int currentYear = currentDate.get(GregorianCalendar.YEAR);
        int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1; // Months are zero-based, so we add 1.
        int currentDay = currentDate.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("Current Date:");
        System.out.println("Year: " + currentYear);
        System.out.println("Month: " + currentMonth);
        System.out.println("Day: " + currentDay);

        // Create a GregorianCalendar instance for a specific date and time (1234567898765 milliseconds since January 1, 1970).
        GregorianCalendar specificDate = new GregorianCalendar();
        specificDate.setTimeInMillis(1234567898765L);

        // Display the year, month, and day for the specific date.
        int specificYear = specificDate.get(GregorianCalendar.YEAR);
        int specificMonth = specificDate.get(GregorianCalendar.MONTH) + 1; // Months are zero-based, so we add 1.
        int specificDay = specificDate.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("\nSpecific Date (1234567898765 milliseconds since January 1, 1970):");
        System.out.println("Year: " + specificYear);
        System.out.println("Month: " + specificMonth);
        System.out.println("Day: " + specificDay);
    }
}