import java.util.*;

public class TwelveHourClock {
    public static void main(String[] args) {
        // Create a scanner to get input from the user
        Scanner input = new Scanner(System.in);

        // Get the time zone offset from the user
        System.out.print("Enter the time zone offset to GMT: ");
        int offset = input.nextInt();

        // Get the current time
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.add(Calendar.HOUR_OF_DAY, offset);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        // Display the current time in 12-hour format
        System.out.printf("The current time is %d:%02d:%02d %s\n", hour, minute, second, ampm);
    }
}