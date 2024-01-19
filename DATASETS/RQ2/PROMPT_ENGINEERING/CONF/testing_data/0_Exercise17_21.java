import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HexEditor extends JFrame {
    private JTextField fileNameTextField;
    private JTextArea hexTextArea;
    private JButton loadButton;
    private JButton saveButton;

    public HexEditor() {
        setTitle("Hex Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        fileNameTextField = new JTextField(30);
        hexTextArea = new JTextArea(20, 40);
        loadButton = new JButton("Load File");
        saveButton = new JButton("Save File");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(fileNameTextField, BorderLayout.NORTH);
        add(new JScrollPane(hexTextArea), BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
    }

    private void loadFile() {
        String fileName = fileNameTextField.getText();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            StringBuilder hexString = new StringBuilder();

            int data;
            while ((data = inputStream.read()) != -1) {
                hexString.append(String.format("%02X ", data));
            }

            hexTextArea.setText(hexString.toString());
            inputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        String fileName = fileNameTextField.getText();
        String hexData = hexTextArea.getText();

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);

            // Convert the hex string back to bytes
            String[] hexBytes = hexData.split(" ");
            for (String hexByte : hexBytes) {
                int decimalValue = Integer.parseInt(hexByte, 16);
                outputStream.write(decimalValue);
            }

            outputStream.close();
            JOptionPane.showMessageDialog(this, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HexEditor().setVisible(true);
            }
        });
    }
}
