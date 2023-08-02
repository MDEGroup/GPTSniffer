import java.util.Calendar;

public class ShowCurrentDateTime {
    public static void main(String[] args) {
        
        Calendar now = Calendar.getInstance();

        
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; 
        int day = now.get(Calendar.DAY_OF_MONTH);

        
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        
        System.out.printf("Current date and time is %04d-%02d-%02d %02d:%02d:%02d%n", year, month, day, hour, minute, second);
    }
}