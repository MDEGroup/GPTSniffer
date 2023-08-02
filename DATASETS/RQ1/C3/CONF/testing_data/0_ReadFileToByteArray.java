import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        try {
            // Get file
            File file = new File("example.txt");
        
            // Read file into byte array
            byte[] fileContent = Files.readAllBytes(file.toPath());
        
            // Print the byte array
            for (byte b : fileContent) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

