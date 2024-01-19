import java.io.*;

public class FileEncryption {
    public static void main(String[] args) {
        // Step 1: Get the input file name from the user
        System.out.println("Please enter the name of the file you want to encrypt:");
        Scanner scanner = new Scanner(System.in);
        String inputFile = scanner.nextLine();

        // Step 2: Get the output file name from the user
        System.out.println("Now, enter the name of the output file where you want to save the encrypted data:");
        String outputFile = scanner.nextLine();

        // Step 3: Open the input and output streams
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);

            // Step 4: Read and encrypt each byte in the input file
            int data;
            while ((data = inputStream.read()) != -1) {
                // Encrypt the byte by adding 5 to it
                int encryptedByte = data + 5;

                // Step 5: Write the encrypted byte to the output file
                outputStream.write(encryptedByte);
            }

            System.out.println("File encryption completed successfully!");
        } catch (IOException e) {
            // Handle any exceptions that might occur during file operations
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Step 6: Close the input and output streams
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}