import java.util.Random;

public class LargestRowColumn {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        // Fill the matrix with random 0s and 1s
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2); // Randomly assign 0 or 1
            }
        }

        // Print the matrix
        System.out.println("The randomly generated matrix is:");
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }

        int maxRowIndex = 0;
        int maxColumnIndex = 0;
        int maxRowCount = 0;
        int maxColumnCount = 0;

        // Find row with most 1s
        for (int i = 0; i < matrix.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    rowCount++;
                }
            }
            if (rowCount > maxRowCount) {
                maxRowCount = rowCount;
                maxRowIndex = i;
            }
        }

        // Find column with most 1s
        for (int j = 0; j < matrix[0].length; j++) {
            int columnCount = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 1) {
                    columnCount++;
                }
            }
            if (columnCount > maxColumnCount) {
                maxColumnCount = columnCount;
                maxColumnIndex = j;
            }
        }

        // Output the results
        System.out.println("The largest row index with most 1s: " + maxRowIndex);
        System.out.println("The largest column index with most 1s: " + maxColumnIndex);
    }
}