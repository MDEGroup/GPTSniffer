import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FunctionDiagram extends JPanel {
    private int centerX = 200;
    private int centerY = 200;
    private int scaleX = 40;
    private int scaleY = 40;
    private int maxX = 5;
    private int minX = -5;
    private int maxY = 25;
    private int minY = 0;
    
    public FunctionDiagram() {
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        g.setColor(Color.BLACK);
        g.drawLine(centerX + minX * scaleX, centerY, centerX + maxX * scaleX, centerY);
        g.drawLine(centerX, centerY - maxY * scaleY, centerX, centerY - minY * scaleY);
        
        
        g.setColor(Color.BLUE);
        for (double x = minX; x <= maxX; x += 0.1) {
            double y = x * x;
            int xPixel = (int)(centerX + x * scaleX);
            int yPixel = (int)(centerY - y * scaleY);
            g.fillOval(xPixel, yPixel, 2, 2);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Function Diagram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FunctionDiagram panel = new FunctionDiagram();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
