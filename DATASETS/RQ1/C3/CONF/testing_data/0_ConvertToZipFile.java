import java.io.*;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) {
        // The file to compress
        String fileToCompress = "file.txt";
        // The compressed file
        String compressedFile = "file.zip";

        try (FileInputStream fis = new FileInputStream(fileToCompress);
             FileOutputStream fos = new FileOutputStream(compressedFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Create a new zip entry
            ZipEntry entry = new ZipEntry(fileToCompress);
            zos.putNextEntry(entry);

            // Write the file to the zip
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            // Close the zip entry and the zip output stream
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

