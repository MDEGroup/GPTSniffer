import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class KochSnowflake extends JFrame {
    
    public KochSnowflake() {
        setTitle("Koch Snowflake");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int level = 5; 
        double side = 400.0; 
        double height = Math.sqrt(3.0) / 2.0 * side; 
        Point2D.Double p1 = new Point2D.Double(100, 100 + height); 
        Point2D.Double p2 = new Point2D.Double(p1.x + side / 2.0, p1.y - height); 
        Point2D.Double p3 = new Point2D.Double(p2.x + side / 2.0, p1.y + height); 
        drawKoch(g2d, p1, p2, level); 
        drawKoch(g2d, p2, p3, level);
        drawKoch(g2d, p3, p1, level);
    }
    
    private void drawKoch(Graphics2D g2d, Point2D.Double p1, Point2D.Double p2, int level) {
        if (level == 0) { 
            g2d.draw(new Line2D.Double(p1, p2));
        } else { 
            Point2D.Double p3 = getThirdPoint(p1, p2);
            Point2D.Double p4 = getThirdPoint(p2, p1);
            Point2D.Double p5 = getMidPoint(p1, p2);
            drawKoch(g2d, p1, p5, level - 1);
            drawKoch(g2d, p5, p3, level - 1);
            drawKoch(g2d, p3, p4, level - 1);
            drawKoch(g2d, p4, p2, level - 1);
        }
    }
    
    private Point2D.Double getThirdPoint(Point2D.Double p1, Point2D.Double p2) {
        double distance = p1.distance(p2);
        double angle = Math.atan2(p2.y - p1.y, p2.x - p1.x);
        return new Point2D.Double(p1.x + distance / 3.0 * Math.cos(angle + Math.PI / 3.0),
                p1.y + distance / 3.0 * Math.sin(angle + Math.PI / 3.0));
    }
    
    private Point2D.Double getMidPoint(Point2D.Double p1, Point2D.Double p2) {
        return new Point2D.Double((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
    }
    
    public static void main(String[] args) {
        KochSnowflake kochSnowflake = new KochSnowflake();
        kochSnowflake.setVisible(true);
    }
