
public class LunarMonthDays {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the lunar month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the lunar year: ");
        int year = scanner.nextInt();

        
        ChineseCalendar calendar = new ChineseCalendar();
        calendar.set(ChineseCalendar.EXTENDED_YEAR, year + 2637); 
        calendar.set(ChineseCalendar.MONTH, month - 1); 

        
        int days = calendar.getActualMaximum(ChineseCalendar.DAY_OF_MONTH);

        
        System.out.println("The number of days in the lunar month is " + days);
    }
}


