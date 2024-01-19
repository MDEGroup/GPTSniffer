import java.util.Scanner;

public class LargestBlockFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();

        int[][] matrix = new int[rows][rows];

        System.out.println("Enter the elements of the matrix (0s and 1s):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] largestBlockInfo = findLargestBlock(matrix);
        int rowIdx = largestBlockInfo[0];
        int colIdx = largestBlockInfo[1];
        int blockSize = largestBlockInfo[2];

        System.out.println("The maximum square submatrix starts at row " + rowIdx +
                " and column " + colIdx + ".");
        System.out.println("It has a size of " + blockSize + " rows.");
    }

    public static int[] findLargestBlock(int[][] matrix) {
        int[] result = new int[3];
        int maxBlockSize = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    int blockSize = checkBlockSize(matrix, i, j);
                    if (blockSize > maxBlockSize) {
                        maxBlockSize = blockSize;
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
        }

        result[0] = maxRow;
        result[1] = maxCol;
        result[2] = maxBlockSize;

        return result;
    }

    public static int checkBlockSize(int[][] matrix, int row, int col) {
        int size = 1;
        boolean flag = true;

        while (row + size < matrix.length && col + size < matrix[row].length && flag) {
            for (int i = row; i <= row + size; i++) {
                for (int j = col; j <= col + size; j++) {
                    if (matrix[i][j] != 1) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                size++;
            }
        }

        return size;
    }
}