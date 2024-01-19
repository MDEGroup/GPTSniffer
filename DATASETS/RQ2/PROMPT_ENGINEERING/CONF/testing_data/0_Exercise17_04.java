import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise17_04 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide the input text file and the output binary file.");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Read a line from the text file
                // And write it as a UTF-8 string into the binary file
                bufferedWriter.write(new String(line.getBytes("UTF-8")));
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

            // Display the sizes of the text file and the binary file
            System.out.println("Text file size: " + getFileSize(inputFile) + " bytes");
            System.out.println("Binary file size: " + getFileSize(outputFile) + " bytes");

        } catch (IOException e) {
            System.err.println("An error occurred while processing the files: " + e.getMessage());
        }
    }

    // Helper method to get the file size
    private static long getFileSize(String filePath) {
        java.io.File file = new java.io.File(filePath);
        return file.length();
    }
}