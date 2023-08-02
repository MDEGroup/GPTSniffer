import java.util.Scanner;

public class NineHeadsAndTails {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number between 0 and 511
        System.out.print("Enter a number between 0 and 511: ");
        int number = input.nextInt();

        // Convert the decimal number to a binary string with leading zeros
        String binaryString = String.format("%9s", Integer.toBinaryString(number)).replace(' ', '0');

        // Display the corresponding matrix with characters H and T
        for (int i = 0; i < binaryString.length(); i++) {
            if (i % 3 == 0) {
                System.out.println(); // Start a new row
            }
            if (binaryString.charAt(i) == '0') {
                System.out.print("H "); // Heads
            } else {
                System.out.print("T "); // Tails
            }
        }
    }
}