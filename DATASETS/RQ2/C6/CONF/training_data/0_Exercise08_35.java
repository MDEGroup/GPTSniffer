import java.util.Scanner;public class MaximumSquareSubmatrix {  public static void main(String[] args) {    Scanner input = new Scanner(System.in);    System.out.print("Enter the number of rows in the matrix: ");    int n = input.nextInt();    int[][] matrix = new int[n][n];    System.out.println("Enter the elements of the matrix (0 or 1):");    for (int i = 0; i < n; i++) {      for (int j = 0; j < n; j++) {        matrix[i][j] = input.nextInt();      }    }    int[] result = findLargestBlock(matrix);    System.out.println("The maximum square submatrix starts at (" + result[0] + ", " + result[1] + ")");    System.out.println("It has " + result[2] + " rows.");  }  public static int[] findLargestBlock(int[][] m) {    int maxBlockSize = 0;    int[] maxBlockLocation = new int[2];    int n = m.length;    int[][] dp = new int[n][n];    