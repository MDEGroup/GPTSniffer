
public class CalendarTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, etc.): ");
        int firstDay = input.nextInt();
        
        for (int month = 1; month <= 12; month++) {
            System.out.print(getMonthName(month) + " " + year + "\n");
            System.out.print("Sun Mon Tue Wed Thu Fri Sat\n");
            
            int numDays = getNumDays(month, year);
            int startDay = (firstDay + getNumDaysInYear(month, year)) % 7;
            int day = 1;
            for (int i = 0; i < startDay; i++) {
                System.out.print("    ");
            }
            for (int i = startDay; i < 7; i++) {
                System.out.printf("%3d ", day);
                day++;
            }
            System.out.println();
            
            while (day <= numDays) {
                for (int i = 0; i < 7 && day <= numDays; i++) {
                    System.out.printf("%3d ", day);
                    day++;
                }
                System.out.println();
            }
            System.out.println();
            
            firstDay = (firstDay + numDays) % 7;
        }
    }
    
    public static String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "";
        }
    }
    
    public static int getNumDays(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
    
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
    public static int getNumDaysInYear(int month, int year) {
        int numDays = 0;
        for (int i = 1; i < month; i++) {
            numDays += getNumDays(i, year);
        }
        return numDays;
    }
}
