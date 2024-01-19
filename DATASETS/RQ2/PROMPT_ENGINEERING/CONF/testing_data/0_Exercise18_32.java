import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KnightsTourGame extends JFrame {

    private static final int BOARD_SIZE = 8;
    private static final int CELL_SIZE = 50;
    private int[][] board;
    private int currentRow;
    private int currentCol;
    private boolean solved;

    public KnightsTourGame() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        currentRow = 0;
        currentCol = 0;
        solved = false;

        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                JButton cell = new JButton();
                cell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                cell.addActionListener(new CellClickListener(i, j));
                add(cell);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new SolveClickListener());
        add(solveButton);
    }

    private void solveKnightsTour(int row, int col, int moveNumber) {
        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0) {
            board[row][col] = moveNumber;

            if (moveNumber == BOARD_SIZE * BOARD_SIZE) {
                solved = true;
                return;
            }

            solveKnightsTour(row - 2, col + 1, moveNumber + 1);
            solveKnightsTour(row - 1, col + 2, moveNumber + 1);
            solveKnightsTour(row + 1, col + 2, moveNumber + 1);
            solveKnightsTour(row + 2, col + 1, moveNumber + 1);
            solveKnightsTour(row + 2, col - 1, moveNumber + 1);
            solveKnightsTour(row + 1, col - 2, moveNumber + 1);
            solveKnightsTour(row - 1, col - 2, moveNumber + 1);
            solveKnightsTour(row - 2, col - 1, moveNumber + 1);

            if (!solved) {
                board[row][col] = 0;
            }
        }
    }

    private void displaySolution() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                JButton cell = (JButton) getContentPane().getComponent(i * BOARD_SIZE + j);
                cell.setText(Integer.toString(board[i][j]));
            }
        }
    }

    private class CellClickListener implements ActionListener {
        private int row;
        private int col;

        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!solved) {
                currentRow = row;
                currentCol = col;
                solveKnightsTour(currentRow, currentCol, 1);
                displaySolution();
            }
        }
    }

    private class SolveClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!solved) {
                solveKnightsTour(currentRow, currentCol, 1);
                displaySolution();
            }
        }
    }

    public static void main(String[] args) {
        KnightsTourGame game = new KnightsTourGame();
        game.setSize(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}