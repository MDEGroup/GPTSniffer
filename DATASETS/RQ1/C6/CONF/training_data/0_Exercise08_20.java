import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[6][7]; 
        initializeBoard(board); 
        char player = 'R'; 
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board); 
            int column = getColumn(scanner, player); 
            int row = dropDisk(board, column, player); 
            if (checkWin(board, row, column)) { 
                System.out.println(player + " wins!");
                gameOver = true;
            } else if (isBoardFull(board)) { 
                System.out.println("Draw!");
                gameOver = true;
            } else {
                player = switchPlayer(player); 
            }
        }
    }

    
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
        System.out.println(" 0 1 2 3 4 5 6");
    }

    
    public static int getColumn(Scanner scanner, char player) {
        System.out.print("Drop a " + player + " disk at column (0-6): ");
        int column = scanner.nextInt();
        return column;
    }

    
    public static int dropDisk(char[][] board, int column, char player) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                return i;
            }
        }
        return -1; 
    }

    
    public static char switchPlayer(char player) {
        if (player == 'R') {
            return 'Y';
        } else {
            return 'R';
        }
    }

    
    public static boolean checkWin(char[][] board, int row, int column) {
        char player = board[row][column];

        
        int count = 0;
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        
        count = 0;
        for (int i = 0; i < board.length;