import java.io.FileInputStream;
import java.io.IOException;

public class ViewHex {

    public static void main(String[] args) {
        System.out.println("Welcome to the Hex Viewer Program!");
        System.out.print("Please enter the file name: ");
        String fileName = System.console().readLine();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);

            int byteRead;
            while ((byteRead = fileInputStream.read()) != -1) {
                String hexRepresentation = Integer.toHexString(byteRead);
                if (hexRepresentation.length() == 1) {
                    System.out.print("0"); // Add a leading '0' if necessary to ensure two-digit hex representation
                }
                System.out.print(hexRepresentation + " ");
            }

            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}