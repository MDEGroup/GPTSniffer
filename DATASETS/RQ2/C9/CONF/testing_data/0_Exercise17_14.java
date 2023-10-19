import java.io.*;

public class FileEncryptor {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileEncryptor <inputFileName> <outputFileName>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try {
            encryptFile(inputFileName, outputFileName);
            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFileName);
             FileOutputStream outputStream = new FileOutputStream(outputFileName)) {

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                // Encrypt by adding 5 to every byte and write to the output file
                int encryptedByte = bytesRead + 5;
                outputStream.write(encryptedByte);
            }
        }
    }
}