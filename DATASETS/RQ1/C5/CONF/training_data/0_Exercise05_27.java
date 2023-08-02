import java.util.Scanner;

public class FirstDayOfMonth {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, etc.): ");
        int firstDay = input.nextInt();

        
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28 + (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        
        for (int i = 0; i < 12; i++) {
            
            int firstDayOfMonth = (firstDay + ((i == 0) ? 0 : daysInMonth[i - 1])) % 7;

            
            System.out.printf("%s 1, %d is %s\n", monthNames[i], year, getDayName(firstDayOfMonth));

            
            firstDay = firstDayOfMonth;
        }
    }

    
    private static String getDayName(int day) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[day];
    }
}