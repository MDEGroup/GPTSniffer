

import java.util.*;


public class Exercise03_21 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter year: (e.g., 2012): ");
        int year = in.nextInt();

        System.out.print("\nEnter month: 1-12: ");
        int temp = in.nextInt();

        int m;
        if (temp == 1) {
            m = 13;
            year -= 1;
        } else if (temp == 2) {
            m = 14;
            year -= 1;
        } else {
            m = temp;
        }

        int k = year % 100;
        int j = year / 100;

        System.out.print("\nEnter the day of the month: 1-31:");
        int q = in.nextInt();
        int h = (q + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        String dayOfWeek = "";

        switch (h) {
            case 0:
                dayOfWeek += "Saturday";
                break;
            case 1:
                dayOfWeek += "Sunday";
                break;
            case 2:
                dayOfWeek += "Monday";
                break;
            case 3:
                dayOfWeek += "Tuesday";
                break;

            case 4:
                dayOfWeek += "Wednesday";
                break;

            case 5:
                dayOfWeek += "Thursday";
                break;

            case 6:
                dayOfWeek += "Friday";
                break;
        }
        System.out.print("\nDay of the week is " + dayOfWeek);


        in.close();
    }

}