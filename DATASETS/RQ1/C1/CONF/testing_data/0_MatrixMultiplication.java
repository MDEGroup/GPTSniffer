public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] firstMatrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] secondMatrix = { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
        int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("The result of matrix multiplication is: ");
        for (int[] row : resultMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

