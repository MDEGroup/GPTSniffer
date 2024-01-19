public class DivisibleNumbersFinder {
    public static void main(String[] args) {
        // Problem 5.11
        System.out.println("Numbers divisible by 5 or 6, but not both, from 100 to 200:");

        int count1 = 0; // Counter for line break after every ten numbers

        for (int number1 = 100; number1 <= 200; number1++) {
            if ((number1 % 5 == 0 || number1 % 6 == 0) && !(number1 % 5 == 0 && number1 % 6 == 0)) {
                System.out.print(number1 + " "); // Print the number

                count1++; // Increment the counter

                if (count1 == 10) {
                    System.out.println(); // Line break after every ten numbers
                    count1 = 0; // Reset the counter
                }
            }
        }

        System.out.println(); // Separate the output of two problems

        // Problem 5.10
        System.out.println("Numbers divisible by 5 and 6 from 100 to 1000:");

        int count2 = 0; // Counter for line break after every ten numbers

        for (int number2 = 100; number2 <= 1000; number2++) {
            if (number2 % 5 == 0 && number2 % 6 == 0) {
                System.out.print(number2 + " "); // Print the number

                count2++; // Increment the counter

                if (count2 == 10) {
                    System.out.println(); // Line break after every ten numbers
                    count2 = 0; // Reset the counter
                }
            }
        }
    }
}