import java.util.Scanner;

public class ConsecutiveNumbersChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] values = new int[rows][cols];

        System.out.println("Enter the values in the array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = scanner.nextInt();
            }
        }

        boolean result = isConsecutiveFour(values);

        if (result) {
            System.out.println("The array contains four consecutive numbers with the same value.");
        } else {
            System.out.println("The array does not contain four consecutive numbers with the same value.");
        }
    }

    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        // Check horizontally
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (values[i][j] == values[i][j + 1] &&
                    values[i][j] == values[i][j + 2] &&
                    values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < cols; j++) {
                if (values[i][j] == values[i + 1][j] &&
                    values[i][j] == values[i + 2][j] &&
                    values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        // Check diagonally (top-left to bottom-right)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (values[i][j] == values[i + 1][j + 1] &&
                    values[i][j] == values[i + 2][j + 2] &&
                    values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        // Check diagonally (top-right to bottom-left)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = cols - 1; j >= 3; j--) {
                if (values[i][j] == values[i + 1][j - 1] &&
                    values[i][j] == values[i + 2][j - 2] &&
                    values[i][j] == values[i + 3][j - 3]) {
                    return true;
                }
            }
        }

        return false; // No consecutive four numbers found
    }
}