import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TicTacToeBoard extends JFrame {
    public TicTacToeBoard() {
        setTitle("Tic-Tac-Toe Board");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3));

        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            int randomValue = random.nextInt(3); // 0 for empty, 1 for X, 2 for O
            JLabel cell = new JLabel();
            cell.setHorizontalAlignment(JLabel.CENTER);

            if (randomValue == 1) {
                cell.setIcon(new ImageIcon("x.gif"));
            } else if (randomValue == 2) {
                cell.setIcon(new ImageIcon("o.gif"));
            } else {
                cell.setText("");
            }

            panel.add(cell);
        }

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeBoard board = new TicTacToeBoard();
            board.setVisible(true);
        });
    }
}