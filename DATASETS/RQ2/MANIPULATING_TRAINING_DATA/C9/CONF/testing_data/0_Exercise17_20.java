import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BinaryEditorApp {
    private JFrame frame;
    private JTextArea binaryTextArea;
    private JTextField fileNameTextField;

    public BinaryEditorApp() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Binary Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        binaryTextArea = new JTextArea();
        binaryTextArea.setEditable(false);
        binaryTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(binaryTextArea);

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
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            loadFileContent(selectedFile);
        }
    }

    private void loadFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder binaryContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                binaryContent.append(textToBinary(line));
                binaryContent.append("\n");
            }
            binaryTextArea.setText(binaryContent.toString());
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
            String binaryContent = binaryTextArea.getText();
            String[] binaryLines = binaryContent.split("\n");
            for (String binaryLine : binaryLines) {
                String text = binaryToText(binaryLine);
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

    private String textToBinary(String text) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : text.toCharArray()) {
            binaryString.append(Integer.toBinaryString(c));
            binaryString.append(" ");
        }
        return binaryString.toString();
    }

    private String binaryToText(String binaryString) {
        String[] binaryTokens = binaryString.trim().split(" ");
        StringBuilder text = new StringBuilder();
        for (String binaryToken : binaryTokens) {
            int charCode = Integer.parseInt(binaryToken, 2);
            text.append((char) charCode);
        }
        return text.toString();
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
        BinaryEditorApp binaryEditor = new BinaryEditorApp();
        binaryEditor.run();
    }
}