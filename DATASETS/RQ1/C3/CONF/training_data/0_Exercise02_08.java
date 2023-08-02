import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

public class TimeZone {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the time zone offset to GMT: ");
        int offset = scanner.nextInt();

        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        LocalDateTime offsetTime = currentTime.plusHours(offset);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String utcTime = formatter.format(currentTime);
        String offsetTimeStr = formatter.format(offsetTime);

        System.out.println("UTC Time: " + utcTime);
        System.out.println("Time in GMT+" + offset + ": " + offsetTimeStr);
    }
}