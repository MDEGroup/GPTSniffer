import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class HexEditorApp {
    private JFrame frame;
    private JTextArea hexTextArea;
    private JTextField fileNameTextField;

    public HexEditorApp() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Hex Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        hexTextArea = new JTextArea();
        hexTextArea.setEditable(false);
        hexTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(hexTextArea);

        fileNameTextField = new JTextField();
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(fileNameTextField);
        topPanel.add(openButton);
        topPanel.add(saveButton);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            loadFileContent(selectedFile);
        }
    }

    private void loadFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder hexContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                hexContent.append(bytesToHex(line.getBytes()));
                hexContent.append("\n");
            }
            hexTextArea.setText(hexContent.toString());
            fileNameTextField.setText(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            showError("File not found: " + e.getMessage());
        }
    }

    private void saveFile() {
        String fileName = fileNameTextField.getText();
        if (fileName.isEmpty()) {
            showError("Please open a file first.");
            return;
        }

        File outputFile = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String hexContent = hexTextArea.getText();
            String[] hexLines = hexContent.split("\n");
            for (String hexLine : hexLines) {
                byte[] bytes = hexToBytes(hexLine);
                String text = new String(bytes);
                writer.write(text);
                writer.newLine();
            }
            showInfo("File saved successfully.");
        } catch (IOException e) {
            showError("Error saving file: " + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String message) {
        JOptionPane.showMessageDialog(frame, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    private byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        HexEditorApp hexEditor = new HexEditorApp();
        hexEditor.run();
    }
}