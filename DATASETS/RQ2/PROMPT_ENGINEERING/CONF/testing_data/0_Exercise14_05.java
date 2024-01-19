import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharactersAroundCircle extends JFrame {
    private String text = "Welcome to Java";

    public CharactersAroundCircle() {
        setTitle("Characters Around Circle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        CirclePanel circlePanel = new CirclePanel();
        add(circlePanel);

        Timer timer = new Timer(100, new ActionListener() {
            double angle = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                circlePanel.setAngle(angle);
                angle += Math.PI / 18; // Rotate by 10 degrees
                repaint();
            }
        });
        timer.start();
    }

    private class CirclePanel extends JPanel {
        private double angle = 0;

        public void setAngle(double angle) {
            this.angle = angle;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 100;

            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                double x = centerX + radius * Math.cos(angle);
                double y = centerY + radius * Math.sin(angle);

                g.drawString(String.valueOf(character), (int) x, (int) y);

                angle += Math.PI / 9; // Rotate by 20 degrees for the next character
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharactersAroundCircle frame = new CharactersAroundCircle();
            frame.setVisible(true);
        });
    }
}