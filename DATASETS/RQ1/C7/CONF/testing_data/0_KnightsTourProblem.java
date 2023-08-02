
public class KnightsTour {
    private static int[][] board;
    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the board:");
        int n = sc.nextInt();
        
        board = new int[n][n];
        
        System.out.println("Enter the starting position:");
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        
        if (solve(startX, startY, 1)) {
            System.out.println("The solution is:");
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
    
    private static boolean solve(int x, int y, int move) {
        if (move == board.length * board.length + 1) {
            return true;
        }
        
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (isValid(nextX, nextY)) {
                board[nextX][nextY] = move;
                
                if (solve(nextX, nextY, move + 1)) {
                    return true;
                }
                
                board[nextX][nextY] = 0;
            }
        }
        
        return false;
    }
    
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == 0;
    }
    
    private static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


