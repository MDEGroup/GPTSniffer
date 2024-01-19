import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        long[] elapsedTimes = {10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L};
        
        for (int i = 0; i < elapsedTimes.length; i++) {
            Date date = new Date(elapsedTimes[i]);
            String dateTime = date.toString();
            System.out.println("Elapsed time " + elapsedTimes[i] + " gives us: " + dateTime);
        }
    }
}