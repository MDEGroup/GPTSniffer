public class DivisibleNumbersFinder {

    public static void main(String[] args) {
        // Loop through numbers from 100 to 1000
        for (int i = 100; i <= 1000; i++) {
            // Check if the number is divisible by both 5 and 6
            if (i % 5 == 0 && i % 6 == 0) {
                // Print the number
                System.out.print(i + " ");

                // Check if ten numbers have been printed and start a new line
                if (i % 500 == 0) {
                    System.out.println();
                }
            }
        }
    }
}