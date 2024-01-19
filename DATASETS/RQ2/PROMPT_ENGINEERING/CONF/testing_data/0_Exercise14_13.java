import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PieChartDisplay extends JPanel {
    private double projectPercentage = 20.0;
    private double quizPercentage = 10.0;
    private double midtermPercentage = 30.0;
    private double finalExamPercentage = 40.0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        double totalPercentage = projectPercentage + quizPercentage + midtermPercentage + finalExamPercentage;

        double projectAngle = 360 * (projectPercentage / totalPercentage);
        double quizAngle = 360 * (quizPercentage / totalPercentage);
        double midtermAngle = 360 * (midtermPercentage / totalPercentage);
        double finalExamAngle = 360 * (finalExamPercentage / totalPercentage);

        g.setColor(Color.RED);
        g.fillArc(50, 50, 200, 200, 0, (int) projectAngle);

        g.setColor(Color.BLUE);
        g.fillArc(50, 50, 200, 200, (int) projectAngle, (int) quizAngle);

        g.setColor(Color.GREEN);
        g.fillArc(50, 50, 200, 200, (int) (projectAngle + quizAngle), (int) midtermAngle);

        g.setColor(Color.ORANGE);
        g.fillArc(50, 50, 200, 200, (int) (projectAngle + quizAngle + midtermAngle), (int) finalExamAngle);

        g.setColor(Color.BLACK);
        g.drawString("Projects", 20, 100);
        g.drawString("Quizzes", 270, 100);
        g.drawString("Midterm Exams", 270, 250);
        g.drawString("Final Exam", 20, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PieChartDisplay chart = new PieChartDisplay();
        frame.add(chart);

        frame.setSize(400, 400);
        frame.setTitle("Grade Percentage Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}