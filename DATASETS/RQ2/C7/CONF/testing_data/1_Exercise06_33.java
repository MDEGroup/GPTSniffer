


public class TimeDisplayer {
    private static final int CURRENT_YEAR = 2021;
    private static final int START_YEAR = 1970;
    private static int daysInCurrentMonth;

    public static void main(String[] args) {
        System.out.println("The current Date and Time is " + getCurrentDateTime("GMT") + "\tGreenwich Mean Time (GMT)");

        System.out.println("The current Date Time is " + getCurrentDateTime("EST") + "\tGreenwich Mean Time (GMT)");
    }

    static String getCurrentDateTime(String timeZone) {
        
        long currentTimeMillis = System.currentTimeMillis();

        
        long totalSeconds = currentTimeMillis / 1000;

        
        long secondNow = totalSeconds % 60;

        String currentTime = ":" + secondNow;

        
        long totalMinutes = totalSeconds / 60;

        
        long minuteNow = totalMinutes % 60;
        currentTime = ":" + minuteNow + currentTime;

        
        long totalHours = totalMinutes / 60;

        
        long hourNow = totalHours % 24;
        currentTime = hourNow + currentTime;

        
        long totalDays = totalHours / 24;

        
        
        long daysAccountLeapYears = totalDays - getNumLeapYears(START_YEAR);
        int currentYearDays = (int) (daysAccountLeapYears % 365);

        
        int monthNow = getMonthFromDays(currentYearDays);
        if (timeZone.equalsIgnoreCase("EST")) {
            return monthName(monthNow) + " " + daysInCurrentMonth + ", " + CURRENT_YEAR + " " + convertGMT2EST(secondNow, minuteNow, hourNow);
        }
        return monthName(monthNow) + " " + daysInCurrentMonth + ", " + CURRENT_YEAR + " " + currentTime;

    }

    private static String convertGMT2EST(long seconds, long minutes, long hours) {
        int hourEst = (int) (hours - 5);
        if (hourEst < 0) {
            hourEst = hourEst + 12;
        }
        if (hourEst > 12) {
            hourEst = hourEst - 12;
        }
        return hourEst + ":" + minutes + ":" + seconds;
    }

    static int getNumLeapYears(int startYear) {
        int totalLeapYears = 0;
        for (int year = startYear; year < CURRENT_YEAR; year++) {
            if (isLeapYear(year)) {
                ++totalLeapYears;
            }
        }
        return totalLeapYears;
    }

    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }


    public static String monthName(int m) {
        switch (m) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "Error";
    }

    static int daysInMonth(int month) {
        switch (month) {
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(CURRENT_YEAR) ? 28 : 29;
        }
        return -1;
    }

    
    static int getMonthFromDays(int days) {
        if (days < 32) {
            daysInCurrentMonth = days;
            return 1;
        }
        int month = 2;
        while (days > 0) {
            daysInCurrentMonth = days; 
            days -= daysInMonth(month++);
        }
        return month;
    }

}
