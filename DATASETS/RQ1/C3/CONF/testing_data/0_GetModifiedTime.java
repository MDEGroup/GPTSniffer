import java.io.File;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        // Get file
        File file = new File("example.txt");
    
        // Get last modified time
        long lastModified = file.lastModified();
    
        // Create a DateFormat object to format the last modified time
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
        // Format the last modified time and print it
        System.out.println("Last modified: " + sdf.format(lastModified));
    }
}

