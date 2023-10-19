import java.io.*;
import java.util.Scanner;

public class ByteBinaryViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            int bytesRead;
            byte[] buffer = new byte[1024];

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    byte currentByte = buffer[i];
                    String binaryRepresentation = getBinaryString(currentByte);
                    System.out.println("Byte: " + currentByte + " Binary: " + binaryRepresentation);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static String getBinaryString(byte value) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int bit = (value >> i) & 1;
            binaryString.append(bit);
        }
        return binaryString.toString();
    }
}