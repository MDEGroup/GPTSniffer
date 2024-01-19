import java.util.Scanner;

public class LatinSquareChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number n: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter " + n + " rows of letters separated by spaces:");

        char[][] square = new char[n][n];
        for (int i = 0; i < n; i++) {
            String rowInput = scanner.nextLine();
            String[] letters = rowInput.split(" ");

            if (letters.length != n || !validateLetters(letters, n)) {
                System.out.println("Wrong input: the letters must be from A to " + (char)('A' + n - 1));
                return;
            }

            for (int j = 0; j < n; j++) {
                square[i][j] = letters[j].charAt(0);
            }
        }

        boolean isLatinSquare = checkLatinSquare(square, n);
        if (isLatinSquare) {
            System.out.println("The input array is a Latin square");
        } else {
            System.out.println("The input array is not a Latin square");
        }
    }

    private static boolean validateLetters(String[] letters, int n) {
        for (String letter : letters) {
            char current = letter.charAt(0);
            if (current < 'A' || current > (char)('A' + n - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLatinSquare(char[][] square, int n) {
        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (rowCheck[square[i][j] - 'A'] || colCheck[square[j][i] - 'A']) {
                    return false;
                }
                rowCheck[square[i][j] - 'A'] = true;
                colCheck[square[j][i] - 'A'] = true;
            }
        }
        return true;
    }
}