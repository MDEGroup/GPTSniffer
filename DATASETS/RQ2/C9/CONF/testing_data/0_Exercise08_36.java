import java.util.Scanner;

public class LatinSquareChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size 'n' of the Latin square.
        System.out.print("Enter the size 'n' of the Latin square: ");
        int n = scanner.nextInt();

        // Initialize a 2D array to store the Latin square.
        char[][] latinSquare = new char[n][n];

        System.out.println("Enter " + n + " rows of letters separated by spaces:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Read characters from the user and populate the Latin square.
                latinSquare[i][j] = scanner.next().charAt(0);
            }
        }

        // Check if the input array is a Latin square.
        boolean isLatinSquare = isLatinSquare(latinSquare, n);

        // Provide the appropriate output.
        if (isLatinSquare) {
            System.out.println("The input array is a Latin square.");
        } else {
            System.out.println("Invalid input: The letters must be from 'A' to '" + (char) ('A' + n - 1) + "'.");
        }
    }

    public static boolean isLatinSquare(char[][] square, int n) {
        // Check rows
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[n];
            for (int j = 0; j < n; j++) {
                char current = square[i][j];
                if (current < 'A' || current > 'A' + n - 1 || used[current - 'A']) {
                    return false;
                }
                used[current - 'A'] = true;
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                char current = square[i][j];
                if (current < 'A' || current > 'A' + n - 1 || used[current - 'A']) {
                    return false;
                }
                used[current - 'A'] = true;
            }
        }

        return true;
    }
}