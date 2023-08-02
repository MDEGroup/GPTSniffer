

import java.util.Scanner;


public class Exercise02_08 {
    public static void main(String[] arsg) {

        System.out.print("To display the time, enter the time zone offset to GMT now: ");

        Scanner input = new Scanner(System.in);

        int offset = input.nextInt();

        long totalMilliseconds = System.currentTimeMillis();

        long totalSeconds = totalMilliseconds / 1000;

        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;

        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;

        long currentHour = totalHours % 24;

        currentHour += offset;

        System.out.println("Your current time is " + currentHour + ":"
                + currentMinute + ":" + currentSecond);
    }

}
