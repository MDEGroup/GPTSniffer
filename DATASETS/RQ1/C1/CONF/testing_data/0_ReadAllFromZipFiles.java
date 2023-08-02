import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {
    public static void main(String[] args) {
        // The zip file
        String zipFile = "file.zip";

        try (ZipFile zf = new ZipFile(zipFile)) {
            // Enumerate each entry
            for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name
                String entryName = entries.nextElement().getName();
                System.out.println("File: " + entryName);

                // Open the entry's input stream
                InputStream in = zf.getInputStream(new ZipEntry(entryName));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                // Print the contents of the entry
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
