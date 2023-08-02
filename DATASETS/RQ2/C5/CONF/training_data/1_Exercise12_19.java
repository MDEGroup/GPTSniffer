

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class WordCounter {

    public static void main(String[] args) {
        try {
            URL url = new URL("http:
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("Number of words in the Gettysburg Address is " + countWords(bufferedReader));
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s");
            if (words.length == 0) continue;
            for (String word : words) {
                word = word.trim();
                if (word.length() > 0 && !word.equals(" ")) {
                    wordCount++;

                }
            }
        }
        return wordCount;
    }
}
