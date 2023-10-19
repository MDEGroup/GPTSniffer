import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CircleConnector extends JFrame {

    public CircleConnector() {
        setTitle("Circle Connector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Create a random number generator
        Random random = new Random();

        // Calculate random center coordinates for the first circle
        int x1 = random.nextInt(getWidth() - 30) + 15;
        int y1 = random.nextInt(getHeight() - 30) + 15;

        // Calculate random center coordinates for the second circle, ensuring they are not too close
        int x2, y2;
        do {
            x2 = random.nextInt(getWidth() - 30) + 15;
            y2 = random.nextInt(getHeight() - 30) + 15;
        } while (Math.abs(x2 - x1) < 30 || Math.abs(y2 - y1) < 30);

        // Draw the first circle
        g.setColor(Color.BLUE);
        g.drawOval(x1 - 15, y1 - 15, 30, 30);

        // Draw the second circle
        g.drawOval(x2 - 15, y2 - 15, 30, 30);

        // Draw the line connecting the circles
        g.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CircleConnector();
        });
    }
}
