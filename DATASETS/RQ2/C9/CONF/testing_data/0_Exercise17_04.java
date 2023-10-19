import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextToUTFConverter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java TextToUTFConverter <inputFileName> <outputFileName>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try {
            // Open the input text file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

            // Create an output binary file for writing
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                byte[] utfBytes = line.getBytes(StandardCharsets.UTF_8);

                // Write the length of UTF-8 bytes and the bytes themselves to the binary file
                dataOutputStream.writeInt(utfBytes.length);
                dataOutputStream.write(utfBytes);
            }

            // Close the input and output streams
            reader.close();
            dataOutputStream.close();

            // Display the sizes of the text file and the binary file
            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);

            System.out.println("Size of the text file (" + inputFileName + "): " + inputFile.length() + " bytes");
            System.out.println("Size of the binary file (" + outputFileName + "): " + outputFile.length() + " bytes");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}