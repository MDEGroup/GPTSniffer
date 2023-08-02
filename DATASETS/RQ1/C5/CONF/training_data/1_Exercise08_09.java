

import java.util.*;


public class nan{
    private static final String USER_X_ID = "X";
    private static final String USER_O_ID = "O";
    static final String IN_PROMPT_ROW = "Enter a row (0, 1, or 2) for player";
    static final String IN_PROMPT_COLUMN = "Enter a column (0, 1, or 2) for player";
    static String[][] boxes;
    static String nextMove;
    static String currentMove;
    static boolean blank;
    static final String verticalLine = "——————-——————\r\n";
    static String status;
    static String winner;
    static int totalMoves = 9;

    static {
        boxes = new String[][]{{"", "", ""},
                {"", "", ""},
                {"", "", ""}}; 
        nextMove = USER_X_ID;
        status = "continue";
        blank = true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = 0, col = 0;
        System.out.print("Welcome to Tic Tac Toe!\n");
        while (status.equals("continue")) {
            if (blank) {
                printBlankBoard();
                blank = false;
            } else {
                printGameBoard();
            }
            System.out.print(IN_PROMPT_ROW + " " + nextMove + ":");
            row = in.nextInt();
            System.out.print(IN_PROMPT_COLUMN + " " + nextMove + ":");
            col = in.nextInt();
            if ((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
                addMove(row, col);
            } else {
                System.out.println("You entered an invalid character player " + nextMove + " enter a 0, 1, or 2 next time...");
            }
        }
        if (status.equals("win")) {
            
            printGameBoard();
            System.out.print("\nPlayer " + winner + " won!");
        } else {
            
            System.out.println("The match is a draw!!");
        }

    }

    
    static void addMove(int markRow, int markCol) {
        if (boxes[markRow][markCol].equals("")) {
            boxes[markRow][markCol] = nextMove;
            totalMoves--;
        } else {
            System.out.println("Nice try, you can only enter your mark in an empty box...");
        }

        if (checkWinner()) {
            status = "win";
        } else if (totalMoves < 1) {
            status = "draw";
        }
    }

    private static void printGameBoard() {

        for (int i = 0; i < 3; i++) {
            System.out.print(verticalLine);
            for (int j = 0; j < 3; j++) {
                if (boxes[i][j].equals("")) {
                    System.out.print("|   ");
                } else {
                    System.out.print("| ");
                    System.out.print(boxes[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.print("|\r\n"); 
        }
        System.out.println(verticalLine);

        nextMove = nextMove.equals(USER_X_ID) ? USER_O_ID : USER_X_ID;
    }

    
    static void printBlankBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print(verticalLine);
            for (int j = 0; j < 3; j++) {
                System.out.print("|   ");
            }
            System.out.print("|\r\n");
        }
        System.out.println(verticalLine);
    }

    
    static boolean checkWinner() {
        boolean won = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(boxes[i][j].equals(""))) {
                    if (boxes[i][j].equals("X")) {
                        if (boxes[0][0].equals("X") && boxes[0][1].equals("X") && boxes[0][2].equals("X") ||
                                boxes[1][0].equals("X") && boxes[1][1].equals("X") && boxes[1][2].equals("X") ||
                                boxes[2][0].equals("X") && boxes[2][1].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][0].equals("X") && boxes[1][0].equals("X") && boxes[2][0].equals("X") ||
                                boxes[0][1].equals("X") && boxes[1][1].equals("X") && boxes[2][1].equals("X") ||
                                boxes[0][2].equals("X") && boxes[1][2].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][0].equals("X") && boxes[1][1].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][2].equals("X") && boxes[1][1].equals("X") && boxes[2][0].equals("X")) {
                            winner = "X";
                            won = true;
                        }

                    } else {
                        if (boxes[0][0].equals("O") && boxes[0][1].equals("O") && boxes[0][2].equals("O") ||
                                boxes[1][0].equals("O") && boxes[1][1].equals("O") && boxes[1][2].equals("O") ||
                                boxes[2][0].equals("O") && boxes[2][1].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][0].equals("O") && boxes[1][0].equals("O") && boxes[2][0].equals("O") ||
                                boxes[0][1].equals("O") && boxes[1][1].equals("O") && boxes[2][1].equals("O") ||
                                boxes[0][2].equals("O") && boxes[1][2].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][0].equals("O") && boxes[1][1].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][2].equals("O") && boxes[1][1].equals("O") && boxes[2][0].equals("O")) {
                            winner = "O";
                            won = true;
                        }


                    }


                }

            }
        }

        return won;

    }

} 