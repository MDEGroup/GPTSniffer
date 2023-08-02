import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MatrixDisplay {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix Display");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[][] matrix = new int[10][10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = rand.nextInt(2); 
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER); 
                textField.setText(Integer.toString(matrix[i][j])); 
                textField.setEditable(false); 
                textField.setBounds(j * 50, i * 50, 50, 50); 
                frame.add(textField);
            }
        }

        frame.setLayout(null); 
        frame.setVisible(true);
    }
}

