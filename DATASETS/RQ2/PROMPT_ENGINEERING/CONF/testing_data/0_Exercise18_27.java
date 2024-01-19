import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Welcome to the KochSnowflakeFractalDrawer program!

public class KochSnowflakeFractalDrawer extends JFrame {

    // Constants for the frame dimensions
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;

    // Constants for the initial triangle points
    private static final int X1 = 100;
    private static final int Y1 = 500;
    private static final int X2 = 300;
    private static final int Y2 = 100;
    private static final int X3 = 500;
    private static final int Y3 = 500;

    // Current recursion depth
    private int currentDepth;

    // Constructor to set up the frame
    public KochSnowflakeFractalDrawer() {
        setTitle("Koch Snowflake Fractal");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentDepth = 0;
    }

    // Method to draw the Koch snowflake
    public void drawKochSnowflake(Graphics g, int x1, int y1, int x2, int y2, int depth) {
        if (depth == 0) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            int deltaX = x2 - x1;
            int deltaY = y2 - y1;

            int x3 = x1 + deltaX / 3;
            int y3 = y1 + deltaY / 3;

            int x4 = (int) (0.5 * (x1 + x2) + Math.sqrt(3) * (y1 - y2) / 6);
            int y4 = (int) (0.5 * (y1 + y2) + Math.sqrt(3) * (x2 - x1) / 6);

            int x5 = x1 + 2 * deltaX / 3;
            int y5 = y1 + 2 * deltaY / 3;

            drawKochSnowflake(g, x1, y1, x3, y3, depth - 1);
            drawKochSnowflake(g, x3, y3, x4, y4, depth - 1);
            drawKochSnowflake(g, x4, y4, x5, y5, depth - 1);
            drawKochSnowflake(g, x5, y5, x2, y2, depth - 1);
        }
    }

    // Method to paint the component
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);

        // Draw the initial equilateral triangle
        drawKochSnowflake(g, X1, Y1, X2, Y2, currentDepth);
        drawKochSnowflake(g, X2, Y2, X3, Y3, currentDepth);
        drawKochSnowflake(g, X3, Y3, X1, Y1, currentDepth);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Creating the frame
        KochSnowflakeFractalDrawer frame = new KochSnowflakeFractalDrawer();
        frame.setVisible(true);
    }
}
