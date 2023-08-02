import java.io.*;
import java.net.*;

public class ScoreReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            double sum = 0;
            int count = 0;

            while ((line = in.readLine()) != null) {
                String[] scores = line.split("\\s+");
                for (String score : scores) {
                    sum += Double.parseDouble(score);
                    count++;
                }
            }

            in.close();

            System.out.println("Total: " + sum);
            System.out.println("Average: " + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}