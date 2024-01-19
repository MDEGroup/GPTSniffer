import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizableRectanguloid extends JFrame {
    private int cubeWidth = 100;
    private int cubeHeight = 100;

    public ResizableRectanguloid() {
        setTitle("Resizable Rectanguloid");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;

                int halfWidth = cubeWidth / 2;
                int halfHeight = cubeHeight / 2;

                // Draw the front face
                g.drawLine(centerX - halfWidth, centerY - halfHeight, centerX + halfWidth, centerY - halfHeight);
                g.drawLine(centerX - halfWidth, centerY - halfHeight, centerX - halfWidth, centerY + halfHeight);
                g.drawLine(centerX + halfWidth, centerY - halfHeight, centerX + halfWidth, centerY + halfHeight);
                g.drawLine(centerX - halfWidth, centerY + halfHeight, centerX + halfWidth, centerY + halfHeight);

                // Draw the back face
                g.drawLine(centerX, centerY - halfHeight, centerX - halfWidth, centerY - halfHeight);
                g.drawLine(centerX, centerY, centerX - halfWidth, centerY);
                g.drawLine(centerX, centerY - halfHeight, centerX, centerY);
            }
        };

        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                cubeWidth = panel.getWidth() / 2;
                cubeHeight = panel.getHeight() / 2;
                panel.repaint();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResizableRectanguloid rectanguloid = new ResizableRectanguloid();
            rectanguloid.setVisible(true);
        });
    }
}