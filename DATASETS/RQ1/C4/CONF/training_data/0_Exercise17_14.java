import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEncrypter {
    public static void main(String[] args) {
        
        String inputFileName = System.console().readLine("Enter input file name: ");
        String outputFileName = System.console().readLine("Enter output file name: ");

        try (FileInputStream input = new FileInputStream(inputFileName);
             FileOutputStream output = new FileOutputStream(outputFileName)) {

            
            int b;
            while ((b = input.read()) != -1) {
                output.write(b + 5);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
