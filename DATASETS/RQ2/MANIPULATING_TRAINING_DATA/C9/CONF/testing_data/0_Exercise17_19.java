import java.io.*;
import java.util.Scanner;

public class HexFileViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            viewFileInHex(inputStream);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void viewFileInHex(InputStream inputStream) throws IOException {
        int bytesRead;
        byte[] buffer = new byte[1024];

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            for (int i = 0; i < bytesRead; i++) {
                byte currentByte = buffer[i];
                String hexRepresentation = String.format("%02X", currentByte);
                System.out.print(hexRepresentation + " ");
            }
        }
    }
}