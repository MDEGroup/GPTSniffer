

import java.awt.*;
import java.util.*;


public class TwelveHourClock{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the time zone offset to GMT: ");
        int offset = in.nextInt();
        boolean pm = false;

        long timeInMillis = System.currentTimeMillis();
        long secondsSinceJan1st1970 = timeInMillis / 1000;
        long second = secondsSinceJan1st1970 % 60;
        long minutesSinceJan1st1970 = secondsSinceJan1st1970 / 60;
        long minute = minutesSinceJan1st1970 % 60;
        long hoursSinceJan1st1970 = minutesSinceJan1st1970 / 60;

        System.out.println(hoursSinceJan1st1970);

        long hour = hoursSinceJan1st1970 % 24;
        hour += offset;

        if (hour > 12) {
            pm = true;
            hour -= 12;
        }

        System.out.println("Your current time is " + hour + ":" + minute + ":" + second + (pm ? " PM" : " AM"));

    }
}