import java.util.Random;

public class RandomMonthName {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();

        // Generate a random integer between 1 and 12
        int monthNum = random.nextInt(12) + 1;

        // Map the integer to the corresponding month name
        String monthName;
        switch (monthNum) {
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
                break;
            default:
                monthName = "Invalid month";
                break;
        }

        // Display the month name
        System.out.println("The random month is " + monthName);
    }
}