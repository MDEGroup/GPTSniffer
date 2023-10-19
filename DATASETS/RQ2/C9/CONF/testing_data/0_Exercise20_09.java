import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleBallApp extends JFrame {
    private List<Ball> balls = new ArrayList<>();

    public MultipleBallApp() {
        setTitle("Multiple Balls App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        JButton removeButton = new JButton("Remove Largest Ball");
        buttonPanel.add(removeButton);

        JPanel ballPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Ball ball : balls) {
                    ball.draw(g);
                }
            }
        };

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!balls.isEmpty()) {
                    removeLargestBall();
                    repaint();
                }
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
        add(ballPanel, BorderLayout.CENTER);
        generateRandomBalls(10); // Create 10 random balls
    }

    private void generateRandomBalls(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int radius = random.nextInt(19) + 2; // Random radius between 2 and 20
            int x = random.nextInt(getWidth() - radius * 2);
            int y = random.nextInt(getHeight() - radius * 2);
            balls.add(new Ball(x, y, radius));
        }
    }

    private void removeLargestBall() {
        Ball largestBall = null;
        double largestArea = 0;

        for (Ball ball : balls) {
            double area = Math.PI * Math.pow(ball.getRadius(), 2);
            if (area > largestArea) {
                largestArea = area;
                largestBall = ball;
            }
        }

        if (largestBall != null) {
            balls.remove(largestBall);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultipleBallApp app = new MultipleBallApp();
            app.setVisible(true);
        });
    }

    private class Ball {
        private int x, y, radius;

        public Ball(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillOval(x, y, radius * 2, radius * 2);
        }
    }
}