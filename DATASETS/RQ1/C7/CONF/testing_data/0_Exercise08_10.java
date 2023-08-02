
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int maxRow = 0;
        int maxColumn = 0;
        int maxCountRow = 0;
        int maxCountColumn = 0;

        
        for (int i = 0; i < matrix.length; i++) {
            int countRow = 0;
            int countColumn = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    countRow++;
                }
                if (matrix[j][i] == 1) {
                    countColumn++;
                }
            }
            if (countRow > maxCountRow) {
                maxCountRow = countRow;
                maxRow = i;
            }
            if (countColumn > maxCountColumn) {
                maxCountColumn = countColumn;
                maxColumn = i;
            }
        }

        
        System.out.println("The largest row index: " + maxRow);
        System.out.println("The largest column index: " + maxColumn);
    }
}
