public class DivisibleNumbersFinder {
    public static void main(String[] args) {
        System.out.println("Numbers divisible by 5 or 6, but not both, from 100 to 200:");

        int count = 0; // Counter for line break after every ten numbers

        for (int number = 100; number <= 200; number++) {
            if ((number % 5 == 0 || number % 6 == 0) && !(number % 5 == 0 && number % 6 == 0)) {
                System.out.print(number + " "); // Print the number

                count++; // Increment the counter

                if (count == 10) {
                    System.out.println(); // Line break after every ten numbers
                    count = 0; // Reset the counter
                }
            }
        }
    }
}