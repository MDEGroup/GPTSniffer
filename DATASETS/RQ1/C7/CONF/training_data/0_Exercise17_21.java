
public class HexEditor extends JFrame {

    private JTextField fileNameTextField;
    private JTextArea hexTextArea;
    private JButton openButton;
    private JButton saveButton;

    public HexEditor() {
        super("Hex Editor");
        initComponents();
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        fileNameTextField = new JTextField();
        fileNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        hexTextArea = new JTextArea();
        hexTextArea.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(hexTextArea);

        openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(fileNameTextField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileNameTextField.setText(file.getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while ((i = fis.read()) != -1) {
                    sb.append(String.format("%02X ", i));
                }
                hexTextArea.setText(sb.toString());
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(file);
                String hexText = hexTextArea.getText().replaceAll("\\s", "");
                for (int i = 0; i < hexText.length(); i += 2) {
                    String hexByte = hexText.substring(i, i + 2);
                    fos.write(Integer.parseInt(hexByte, 16));
                }
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new HexEditor();
    }
}
