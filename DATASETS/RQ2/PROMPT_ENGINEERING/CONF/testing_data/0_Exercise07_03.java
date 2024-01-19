import java.util.Scanner;

public class NumberOccurrenceCounter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] occurrences = new int[101]; // Array to store occurrences, index 0 is not used

        System.out.println("Please enter integers between 1 and 100 (enter 0 to exit):");

        int number = input.nextInt();
        while (number != 0) {
            if (number >= 1 && number <= 100) {
                occurrences[number]++; // Increment occurrence for the entered number
            } else {
                System.out.println("Number out of range (1-100). Ignoring...");
            }
            number = input.nextInt();
        }

        System.out.println("Occurrences of each number:");
        for (int i = 1; i <= 100; i++) {
            if (occurrences[i] != 0) {
                System.out.println(i + " occurs " + occurrences[i] + " time(s)");
            }
        }

        input.close();
    }
}