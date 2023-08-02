import java.io.*;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) {
        
        String fileToCompress = "file.txt";
        
        String compressedFile = "file.zip";

        try (FileInputStream fis = new FileInputStream(fileToCompress);
             FileOutputStream fos = new FileOutputStream(compressedFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            
            ZipEntry entry = new ZipEntry(fileToCompress);
            zos.putNextEntry(entry);

            
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

