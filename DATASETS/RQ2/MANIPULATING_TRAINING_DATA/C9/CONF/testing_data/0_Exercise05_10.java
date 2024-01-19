public class NumbersDivisibleBy5And6 {
    public static void main(String[] args) {
        final int LOWER_LIMIT = 100;
        final int UPPER_LIMIT = 1000;
        final int NUMBERS_PER_LINE = 10;

        int count = 0;
        for (int number = LOWER_LIMIT; number <= UPPER_LIMIT; number++) {
            if (isDivisibleBy5And6(number)) {
                System.out.print(number + " ");
                count++;

                if (count % NUMBERS_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }
    }

    // Check if a number is divisible by both 5 and 6
    private static boolean isDivisibleBy5And6(int number) {
        return (number % 5 == 0) && (number % 6 == 0);
    }
}