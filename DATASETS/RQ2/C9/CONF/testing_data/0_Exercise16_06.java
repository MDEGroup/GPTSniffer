import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldExample {
    private JFrame frame;
    private JTextField textField;

    public TextFieldExample() {
        // Create the main application window.
        frame = new JFrame("Dynamic Text Field Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create and configure the text field.
        textField = new JTextField("Hello, World!");
        frame.add(textField);

        // Create buttons for different text field alignment options.
        addButton("Left Align", JTextField.LEFT);
        addButton("Center Align", JTextField.CENTER);
        addButton("Right Align", JTextField.RIGHT);

        // Create a button to set the column size dynamically.
        addButton("Set Column Size", -1); // -1 is a placeholder value for now.

        // Display the application window.
        frame.pack();
        frame.setVisible(true);
    }

    private void addButton(String label, final int alignment) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alignment == -1) {
                    // Handle the "Set Column Size" button.
                    handleSetColumnSize();
                } else {
                    // Set the text field's alignment.
                    textField.setHorizontalAlignment(alignment);
                }
            }
        });
        frame.add(button);
    }

    private void handleSetColumnSize() {
        String input = JOptionPane.showInputDialog(frame, "Enter Column Size:");
        try {
            int columnSize = Integer.parseInt(input);
            textField.setColumns(columnSize);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid integer.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextFieldExample();
            }
        });
    }
}