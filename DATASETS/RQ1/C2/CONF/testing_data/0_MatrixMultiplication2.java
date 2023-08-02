public class MultiplyMatrices {
    public static void main(String[] args) {
        int[][] firstMatrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] secondMatrix = {{7, 8}, {9, 10}, {11, 12}};

        int rowsInFirstMatrix = firstMatrix.length;
        int columnsInFirstMatrix = firstMatrix[0].length;
        int rowsInSecondMatrix = secondMatrix.length;
        int columnsInSecondMatrix = secondMatrix[0].length;

        if (columnsInFirstMatrix != rowsInSecondMatrix) {
            System.out.println("The matrices can't be multiplied with each other.");
        } else {
            int[][] result = new int[rowsInFirstMatrix][columnsInSecondMatrix];
            for (int i = 0; i < rowsInFirstMatrix; i++) {
                for (int j = 0; j < columnsInSecondMatrix; j++) {
                    for (int k = 0; k < columnsInFirstMatrix; k++) {
                        result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            System.out.println("Product of the matrices:");
            for (int[] row : result) {
                for (int column : row) {
                    System.out.print(column + " ");
                }
                System.out.println();
            }
        }
    }
}

