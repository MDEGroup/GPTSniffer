import java.util.Scanner;

public class MarkovMatrixChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        if (isMarkovMatrix(matrix)) {
            System.out.println("It is a Markov matrix");
        } else {
            System.out.println("It is not a Markov matrix");
        }
    }

    public static boolean isMarkovMatrix(double[][] m) {
        // Check if each element is positive
        for (double[] row : m) {
            for (double num : row) {
                if (num <= 0) {
                    return false;
                }
            }
        }

        // Check if the sum of elements in each column is 1
        for (int i = 0; i < m.length; i++) {
            double sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                sum += m[j][i];
            }
            if (Math.abs(sum - 1.0) > 0.0001) {
                return false;
            }
        }

        return true;
    }
}