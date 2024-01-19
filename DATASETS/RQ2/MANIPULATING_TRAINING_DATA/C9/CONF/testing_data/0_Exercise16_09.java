import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class RectangleCanvas {
    private JFrame frame;
    private JPanel drawingPanel;
    private JTextField rect1XField, rect1YField, rect2XField, rect2YField;
    private Rectangle2D rect1, rect2;
    private boolean isDraggingRect1 = false;
    private boolean isDraggingRect2 = false;
    private int offsetX1, offsetY1, offsetX2, offsetY2;

    public RectangleCanvas() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Rectangle Intersection Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the drawing panel
        drawingPanel = new DrawingPanel();
        setupMouseListeners();

        frame.add(drawingPanel, BorderLayout.CENTER);

        // Create input fields and labels
        createInputFields();

        frame.pack();
        frame.setVisible(true);
    }

    private void createInputFields() {
        JPanel inputPanel = new JPanel();
        rect1XField = new JTextField(5);
        rect1YField = new JTextField(5);
        rect2XField = new JTextField(5);
        rect2YField = new JTextField(5);
        JButton checkIntersectionButton = new JButton("Check Intersection");
        checkIntersectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIntersection();
            }
        });
        inputPanel.add(new JLabel("Rect1 X:"));
        inputPanel.add(rect1XField);
        inputPanel.add(new JLabel("Rect1 Y:"));
        inputPanel.add(rect1YField);
        inputPanel.add(new JLabel("Rect2 X:"));
        inputPanel.add(rect2XField);
        inputPanel.add(new JLabel("Rect2 Y:"));
        inputPanel.add(rect2YField);
        inputPanel.add(checkIntersectionButton);

        frame.add(inputPanel, BorderLayout.SOUTH);
    }

    private void setupMouseListeners() {
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePress(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDraggingRect1 = false;
                isDraggingRect2 = false;
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDrag(e);
            }
        });
    }

    private void handleMousePress(MouseEvent e) {
        if (rect1.contains(e.getPoint())) {
            isDraggingRect1 = true;
            offsetX1 = e.getX() - (int) rect1.getX();
            offsetY1 = e.getY() - (int) rect1.getY();
        } else if (rect2.contains(e.getPoint())) {
            isDraggingRect2 = true;
            offsetX2 = e.getX() - (int) rect2.getX();
            offsetY2 = e.getY() - (int) rect2.getY();
        }
    }

    private void handleMouseDrag(MouseEvent e) {
        if (isDraggingRect1) {
            int newX = e.getX() - offsetX1;
            int newY = e.getY() - offsetY1;
            rect1.setRect(newX, newY, rect1.getWidth(), rect1.getHeight());
            updateTextFields(rect1, rect1XField, rect1YField);
        } else if (isDraggingRect2) {
            int newX = e.getX() - offsetX2;
            int newY = e.getY() - offsetY2;
            rect2.setRect(newX, newY, rect2.getWidth(), rect2.getHeight());
            updateTextFields(rect2, rect2XField, rect2YField);
        }
        drawingPanel.repaint();
    }

    private void updateTextFields(Rectangle2D rect, JTextField xField, JTextField yField) {
        xField.setText(Integer.toString((int) rect.getX()));
        yField.setText(Integer.toString((int) rect.getY()));
    }

    private void checkIntersection() {
        if (rect1.intersects(rect2)) {
            JOptionPane.showMessageDialog(frame, "Rectangles intersect.");
        } else {
            JOptionPane.showMessageDialog(frame, "Rectangles do not intersect.");
        }
    }

    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLUE);
            g2.draw(rect1);
            g2.setColor(Color.RED);
            g2.draw(rect2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RectangleCanvas();
            }
        });
    }
}