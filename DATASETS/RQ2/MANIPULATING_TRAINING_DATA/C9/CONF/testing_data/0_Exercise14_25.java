import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class CirclePolygon extends JPanel {
    private int centerX = 200;
    private int centerY = 200;
    private int radius = 100;
    private int numPoints = 5;
    private int[] xPoints = new int[numPoints];
    private int[] yPoints = new int[numPoints;
    
    public CirclePolygon() {
        generateRandomPointsOnCircle();
    }
    
    private void generateRandomPointsOnCircle() {
        Random random = new Random();
        for (int i = 0; i < numPoints; i++) {
            double angle = i * 2 * Math.PI / numPoints;
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));
            xPoints[i] = x;
            yPoints[i] = y;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawCircle(g);
        drawPolygon(g);
    }
    
    private void drawCircle(Graphics g) {
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
    
    private void drawPolygon(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(xPoints, yPoints, numPoints);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle and Polygon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePolygon panel = new CirclePolygon();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}