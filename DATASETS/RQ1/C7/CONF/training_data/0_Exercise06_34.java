
public class PrintCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter full year (e.g., 2022): ");
        int year = input.nextInt();
        System.out.print("Enter month in number between 1 and 12: ");
        int month = input.nextInt();

        
        printMonth(year, month);
    }

    public static void printMonth(int year, int month) {
        
        printMonthTitle(year, month);

        
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        System.out.println("        " + getMonthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static void printMonthBody(int year, int month) {
        
        int startDay = zellersAlgo(1, month, year);

        
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static String getMonthName(int month) {
        String monthName = "";

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }

        return monthName;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return isLeapYear(year) ? 29 : 28;
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year
