import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RectanguloidViewer extends JFrame {

    private int rectWidth = 100;
    private int rectHeight = 50;
    private int rectDepth = 30;

    public RectanguloidViewer() {
        setTitle("Rectanguloid Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentListener(new ResizeListener()); // Register the resize listener

        setSize(400, 400); // Initial window size
        setLocationRelativeTo(null); // Center the window
    }

    private class ResizeListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            // Adjust the rectanguloid dimensions based on window size
            int newWidth = getWidth() / 4;
            int newHeight = getHeight() / 4;
            int newDepth = newWidth / 2;

            rectWidth = newWidth;
            rectHeight = newHeight;
            rectDepth = newDepth;

            repaint(); // Redraw the rectanguloid
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Calculate coordinates for drawing the rectanguloid
        int x = centerX - rectWidth / 2;
        int y = centerY - rectHeight / 2;
        int z = rectDepth / 2;

        g.setColor(Color.BLUE);

        // Draw the rectanguloid's front face
        g.drawRect(x, y, rectWidth, rectHeight);

        // Draw the rectanguloid's edges
        g.drawLine(x, y, x + z, y - z);
        g.drawLine(x + rectWidth, y, x + rectWidth + z, y - z);
        g.drawLine(x, y + rectHeight, x + z, y + rectHeight - z);
        g.drawLine(x + rectWidth, y + rectHeight, x + rectWidth + z, y + rectHeight - z);

        // Draw the rectanguloid's back face
        g.drawLine(x + z, y - z, x + rectWidth + z, y - z);
        g.drawLine(x + z, y - z, x + z, y + rectHeight - z);
        g.drawLine(x + rectWidth + z, y - z, x + rectWidth + z, y + rectHeight - z);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RectanguloidViewer viewer = new RectanguloidViewer();
            viewer.setVisible(true);
        });
    }
}
