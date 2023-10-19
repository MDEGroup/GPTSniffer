import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockExample {
    private JFrame frame;
    private JTextField hourField, minuteField, secondField;
    private ClockPanel clockPanel;

    public ClockExample() {
        frame = new JFrame("Clock Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for input fields and the "Set Time" button
        JPanel inputPanel = new JPanel();
        hourField = new JTextField(2);
        minuteField = new JTextField(2);
        secondField = new JTextField(2);
        JButton setTimeButton = new JButton("Set Time");

        setTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setClockTime();
            }
        });

        inputPanel.add(new JLabel("Hour:"));
        inputPanel.add(hourField);
        inputPanel.add(new JLabel("Minute:"));
        inputPanel.add(minuteField);
        inputPanel.add(new JLabel("Second:"));
        inputPanel.add(secondField);
        inputPanel.add(setTimeButton);

        // Create the clock panel
        clockPanel = new ClockPanel();

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(clockPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private void setClockTime() {
        try {
            int hour = Integer.parseInt(hourField.getText());
            int minute = Integer.parseInt(minuteField.getText());
            int second = Integer.parseInt(secondField.getText());
            clockPanel.setTime(hour, minute, second);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClockExample();
            }
        });
    }
}