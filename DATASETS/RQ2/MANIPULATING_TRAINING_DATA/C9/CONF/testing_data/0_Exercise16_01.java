import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageColorChanger extends JFrame {
    private JLabel messageLabel;
    private JButton leftButton;
    private JButton rightButton;
    private JRadioButton redRadio;
    private JRadioButton greenRadio;
    private JRadioButton blueRadio;

    public MessageColorChanger() {
        setTitle("Message Color Changer");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        messageLabel = new JLabel("Change my color!");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        leftButton = new JButton("Move Left");
        rightButton = new JButton("Move Right");

        redRadio = new JRadioButton("Red");
        greenRadio = new JRadioButton("Green");
        blueRadio = new JRadioButton("Blue");

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redRadio);
        colorGroup.add(greenRadio);
        colorGroup.add(blueRadio);

        JPanel messagePanel = new JPanel(new FlowLayout());
        messagePanel.add(leftButton);
        messagePanel.add(messageLabel);
        messagePanel.add(rightButton);

        JPanel colorPanel = new JPanel(new FlowLayout());
        colorPanel.add(redRadio);
        colorPanel.add(greenRadio);
        colorPanel.add(blueRadio);

        add(messagePanel, BorderLayout.CENTER);
        add(colorPanel, BorderLayout.SOUTH);

        leftButton.addActionListener(e -> moveMessageLeft());
        rightButton.addActionListener(e -> moveMessageRight());
        redRadio.addActionListener(e -> changeMessageColor(Color.RED));
        greenRadio.addActionListener(e -> changeMessageColor(Color.GREEN));
        blueRadio.addActionListener(e -> changeMessageColor(Color.BLUE));
    }

    private void moveMessageLeft() {
        Point location = messageLabel.getLocation();
        location.x -= 10;
        messageLabel.setLocation(location);
    }

    private void moveMessageRight() {
        Point location = messageLabel.getLocation();
        location.x += 10;
        messageLabel.setLocation(location);
    }

    private void changeMessageColor(Color color) {
        messageLabel.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MessageColorChanger frame = new MessageColorChanger();
            frame.setLayout(null); // Use absolute positioning for label movement
            frame.setVisible(true);
        });
    }
}