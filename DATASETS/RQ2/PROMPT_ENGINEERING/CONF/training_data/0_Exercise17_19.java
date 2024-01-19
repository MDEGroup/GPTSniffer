import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_19 {
    public static void main(String[] args) {
        // Prompt the user for a file name
        String fileName = System.console().readLine("Enter file name: ");

        try (FileInputStream input = new FileInputStream(fileName)) {
            // Read bytes from the file and display their hex representation
            int value;
            while ((value = input.read()) != -1) {
                String hex = Integer.toHexString(value & 0xFF);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                System.out.print(hex.toUpperCase() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
