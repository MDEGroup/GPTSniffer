
public class CirclePolygon extends JPanel {
    private int centerX = 200;
    private int centerY = 200;
    private int radius = 100;
    private int numPoints = 5;
    private int[] xPoints = new int[numPoints];
    private int[] yPoints = new int[numPoints];
    
    public CirclePolygon() {
        
        Random random = new Random();
        for (int i = 0; i < numPoints; i++) {
            double angle = i * 2 * Math.PI / numPoints;
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));
            xPoints[i] = x;
            yPoints[i] = y;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        
        
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
