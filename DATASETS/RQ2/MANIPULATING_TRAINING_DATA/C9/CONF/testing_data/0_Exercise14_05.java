import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FontMetrics;

public class CircleString extends JPanel {
    private int centerX = 200;
    private int centerY = 200;
    private int radius = 100;
    private String message = "Welcome to Java";
    
    public CircleString() {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawCircle(g);
        drawMessageInCircle(g);
    }
    
    private void drawCircle(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
    
    private void drawMessageInCircle(Graphics g) {
        g.setColor(Color.BLUE);
        Font font = new Font("Serif", Font.PLAIN, 12);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int messageWidth = metrics.stringWidth(message);
        int messageHeight = metrics.getHeight();

        double angleStep = 2 * Math.PI / message.length();
        double angle = 0;
        
        for (int i = 0; i < message.length(); i++) {
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));
            g.drawString(String.valueOf(message.charAt(i)), x - messageWidth / 2, y + messageHeight / 4);
            angle += angleStep;
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle with Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CircleString panel = new CircleString();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}