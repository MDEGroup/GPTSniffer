
public class LatinSquareChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = scanner.nextInt();
        
        
        char[][] grid = new char[n][n];
        System.out.println("Enter " + n + " rows of letters separated by spaces:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = scanner.next();
                if (s.length() != 1 || s.charAt(0) < 'A' || s.charAt(0) >= 'A' + n) {
                    System.out.println("Wrong input: the letters must be from A to " + (char)('A' + n - 1));
                    return;
                }
                grid[i][j] = s.charAt(0);
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            boolean[] rowUsed = new boolean[n];
            boolean[] colUsed = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (rowUsed[grid[i][j] - 'A'] || colUsed[grid[j][i] - 'A']) {
                    System.out.println("The input array is not a Latin square");
                    return;
                }
                rowUsed[grid[i][j] - 'A'] = true;
                colUsed[grid[j][i] - 'A'] = true;
            }
        }
        System.out.println("The input array is a Latin square");
    }
}
