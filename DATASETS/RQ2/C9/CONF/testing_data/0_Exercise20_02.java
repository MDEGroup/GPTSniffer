import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NumberPanel extends JFrame {
    private LinkedList<Integer> numberList = new LinkedList<>();
    private JTextArea numberTextArea;
    private JTextField inputField;

    public NumberPanel() {
        setTitle("Number List Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        numberTextArea = new JTextArea(10, 30);
        numberTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(numberTextArea);

        inputField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton sortButton = new JButton("Sort");
        JButton shuffleButton = new JButton("Shuffle");
        JButton reverseButton = new JButton("Reverse");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortNumbers();
            }
        });

        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleNumbers();
            }
        });

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseNumbers();
            }
        });

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(sortButton);
        inputPanel.add(shuffleButton);
        inputPanel.add(reverseButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void addNumber() {
        String inputText = inputField.getText().trim();
        if (!inputText.isEmpty()) {
            try {
                int number = Integer.parseInt(inputText);
                if (!numberList.contains(number)) {
                    numberList.add(number);
                    displayNumbers();
                    inputField.setText("");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        }
    }

    private void displayNumbers() {
        Collections.sort(numberList);
        StringBuilder builder = new StringBuilder();
        for (int number : numberList) {
            builder.append(number).append("\n");
        }
        numberTextArea.setText(builder.toString());
    }

    private void sortNumbers() {
        Collections.sort(numberList);
        displayNumbers();
    }

    private void shuffleNumbers() {
        Collections.shuffle(numberList);
        displayNumbers();
    }

    private void reverseNumbers() {
        Collections.reverse(numberList);
        displayNumbers();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberPanel().setVisible(true);
            }
        });
    }
}
