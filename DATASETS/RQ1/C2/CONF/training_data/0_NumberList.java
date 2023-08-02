import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NumberListGUI extends JFrame implements ActionListener {
    private LinkedList<Integer> numbers;
    private Set<Integer> uniqueNumbers;
    private JTextField inputField;
    private JTextArea outputArea;

    public NumberListGUI() {
        numbers = new LinkedList<>();
        uniqueNumbers = new HashSet<>();
        
        // Create input panel with text field and add button
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        
        // Create control panel with sort, shuffle, and reverse buttons
        JPanel controlPanel = new JPanel();
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        controlPanel.add(sortButton);
        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(this);
        controlPanel.add(shuffleButton);
        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(this);
        controlPanel.add(reverseButton);
        
        // Create output panel with text area
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Add all panels to main frame
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);
        
        // Set main frame properties and display it
        this.setTitle("Number List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        
        switch (actionCommand) {
            case "Add":
                try {
                    int number = Integer.parseInt(inputField.getText());
                    
                    if (uniqueNumbers.add(number)) {
                        numbers.add(number);
                        outputArea.append(number + "\n");
                    }
                    
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input: " + inputField.getText());
                    inputField.setText("");
                }
                break;
                
            case "Sort":
                Collections.sort(numbers);
                outputArea.setText("");
                
                for (int number : numbers) {
                    outputArea.append(number + "\n");
                }
                
                break;
                
            case "Shuffle":
                Collections.shuffle(numbers);
                outputArea.setText("");
                
                for (int number : numbers) {
                    outputArea.append(number + "\n");
                }
                
                break;
                
            case "Reverse":
                Collections.reverse(numbers);
                outputArea.setText("");
                
                for (int number : numbers) {
                    outputArea.append(number + "\n");
                }
                
                break;
        }
    }
    
    public static void main(String[] args) {
        new NumberListGUI();
    }
}

