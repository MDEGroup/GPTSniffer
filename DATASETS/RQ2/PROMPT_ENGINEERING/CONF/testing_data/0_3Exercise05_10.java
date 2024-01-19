// Program to find numbers divisible by 5 and 6 in the range 100 to 1000
public class DivisibleNumbersFinder {

    public static void main(String[] args) {
        // Loop through the numbers from 100 to 1000
        for (int number = 100; number <= 1000; number++) {
            // Check if the number is divisible by both 5 and 6
            if (number % 5 == 0 && number % 6 == 0) {
                System.out.print(number + " "); // Display the number

                // Check if it's the tenth number on the line
                if (number % 10 == 0) {
                    System.out.println(); // Move to the next line
                }
            }
        }
    }
}