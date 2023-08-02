
public class MatrixExplorer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int n = input.nextInt();

        
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        
        for (int i = 0; i < n; i++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on row " + (i + 1));
            } else if (allOnes) {
                System.out.println("All 1s on row " + (i + 1));
            }
        }

        
        for (int j = 0; j < n; j++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on column " + (j + 1));
            } else if (allOnes) {
                System.out.println("All 1s on column " + (j + 1));
            }
        }

        
        boolean allZeros = true;
        boolean allOnes = true;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the major diagonal");
        } else if (allOnes) {
            System.out.println("All 1s on the major diagonal");
        }

        
        allZeros = true;
        allOnes = true;
        for (int i = 0; i < n; i++) {
            if (matrix[i][n - i - 1] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the sub-diagonal");
        } else if (allOnes) {
            System.out.println("All 1s on the sub
