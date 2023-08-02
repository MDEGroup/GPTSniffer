package ch_09;

import java.util.GregorianCalendar;


public class Exercise09_05 {

    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH);
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("Display the current year, month, and day: ");
        System.out.println("Year: " + year + ", Month: " + month + ", Day of month: " + day);

        System.out.println("Setting GregorianCalendar.setTimeInMillis(long) to 1234567898765L");

        gregorianCalendar.setTimeInMillis(1234567898765L);
        year = gregorianCalendar.get(GregorianCalendar.YEAR);
        month = gregorianCalendar.get(GregorianCalendar.MONTH);
        day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + ", Month: " + month + ", Day of month: " + day);

    }
}
