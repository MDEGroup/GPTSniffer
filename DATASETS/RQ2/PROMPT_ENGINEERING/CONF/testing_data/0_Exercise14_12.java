import javax.swing.*;
import java.awt.*;

public class BarChartDisplay extends JPanel {
    private double projectPercentage = 20.0;
    private double quizPercentage = 10.0;
    private double midtermPercentage = 30.0;
    private double finalExamPercentage = 40.0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int projectWidth = (int) (width * (projectPercentage / 100));
        int quizWidth = (int) (width * (quizPercentage / 100));
        int midtermWidth = (int) (width * (midtermPercentage / 100));
        int finalExamWidth = (int) (width * (finalExamPercentage / 100));

        g.setColor(Color.RED);
        g.fillRect(10, 10, projectWidth, 30);

        g.setColor(Color.BLUE);
        g.fillRect(10, 50, quizWidth, 30);

        g.setColor(Color.GREEN);
        g.fillRect(10, 90, midtermWidth, 30);

        g.setColor(Color.ORANGE);
        g.fillRect(10, 130, finalExamWidth, 30);

        g.setColor(Color.BLACK);
        g.drawString("Projects", 10, 30);
        g.drawString("Quizzes", 10, 70);
        g.drawString("Midterm Exams", 10, 110);
        g.drawString("Final Exam", 10, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BarChartDisplay chart = new BarChartDisplay();
        frame.add(chart);

        frame.setSize(400, 200);
        frame.setTitle("Grade Percentage Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}