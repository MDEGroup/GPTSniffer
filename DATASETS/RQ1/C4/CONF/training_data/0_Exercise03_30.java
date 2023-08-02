import java.util.*;

public class TwelveHourClock {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the time zone offset to GMT: ");
        int offset = input.nextInt();

        
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.add(Calendar.HOUR_OF_DAY, offset);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        
        System.out.printf("The current time is %d:%02d:%02d %s\n", hour, minute, second, ampm);
    }
}