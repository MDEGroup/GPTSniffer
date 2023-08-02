import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppendExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferWriter = null;
        try {
            // Append to the existing file
            fileWriter = new FileWriter(file, true);
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write("\nThis is the new text to be added to the file.");
            bufferWriter.newLine();
            System.out.println("Text appended to the file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


