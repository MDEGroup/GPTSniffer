import java.util.ArrayList;
import java.util.Scanner;

public class LargestRowsColumns {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int n = input.nextInt();
        
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int)(Math.random() * 2);
            }
        }
        
        
        System.out.println("The random array is");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        
        
        ArrayList<Integer> largestRows = new ArrayList<>();
        int maxRowCount = 0;
        for (int i = 0; i < n; i++) {
            int rowCount = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowCount++;
                }
            }
            if (rowCount > maxRowCount) {
                maxRowCount = rowCount;
                largestRows.clear();
                largestRows.add(i);
            } else if (rowCount == maxRowCount) {
                largestRows.add(i);
            }
        }
        
        
        ArrayList<Integer> largestColumns = new ArrayList<>();
        int maxColumnCount = 0;
        for (int j = 0; j < n; j++) {
            int columnCount = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 1) {
                    columnCount++;
                }
            }
            if (columnCount > maxColumnCount) {
                maxColumnCount = columnCount;
                largestColumns.clear();
                largestColumns.add(j);
            } else if (columnCount == maxColumnCount) {
                largestColumns.add(j);
            }
        }
        
        
        System.out.print("The largest row index: ");
        for (int i = 0; i < largestRows.size(); i++) {
            System.out.print(largestRows.get(i) + " ");
        }
        System.out.println();
        System.out.print("The largest column index: ");
        for (int i = 0; i < largestColumns.size(); i++) {
            System.out.print(largestColumns.get(i) + " ");
        }
        System.out.println();
    }
    
}
