import java.util.Scanner;

public class NumberCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] counts = new int[101]; // array to hold counts of each number

        // read integers from user until 0 is entered
        int number;
        do {
            System.out.print("Enter an integer between 1 and 100 (0 to stop): ");
            number = input.nextInt();
            if (number >= 1 && number <= 100) {
                counts[number]++; // increment count for the entered number
            }
        } while (number != 0);

        // display the counts for each number
        for (int i = 1; i <= 100; i++) {
            if (counts[i] > 0) {
                System.out.println(i + " occurs " + counts[i] + " times");
            }
        }
    }
}
