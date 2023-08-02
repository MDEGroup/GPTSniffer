
public class MonthDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        System.out.print("Enter the first three letters of a month name (with the first letter in uppercase): ");
        String month = scanner.next();
        
        int numDays = getNumDays(year, month);
        
        System.out.println(month + " " + year + " has " + numDays + " days.");
    }
    
    public static int getNumDays(int year, String month) {
        int numDays;
        
        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                numDays = 31;
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                numDays = 30;
                break;
            case "Feb":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            default:
                numDays = 0;
                break;
        }
        
        return numDays;
    }
}
