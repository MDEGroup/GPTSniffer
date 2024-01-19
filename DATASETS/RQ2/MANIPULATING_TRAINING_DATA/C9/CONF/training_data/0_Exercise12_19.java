import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GettysburgAddressWordCounter {
    public static void main(String[] args) {
        String url = "http://se.cs.depaul.edu/Java/Chapter04/Lincoln.txt";
        int wordCount = 0;

        try {
            URL textUrl = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(textUrl.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error reading from URL: " + e.getMessage());
        }

        System.out.println("The Gettysburg address contains " + wordCount + " words.");
    }
}