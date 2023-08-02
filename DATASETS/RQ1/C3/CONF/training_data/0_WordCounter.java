import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class WordFrequency {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> wordMap = new HashMap<>();
        Scanner sc = new Scanner(new File("text.txt"));

        while (sc.hasNext()) {
            String word = sc.next();
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word);
                wordMap.put(word, count + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        sc.close();

        for (String word : wordMap.keySet()) {
            System.out.println(word + ": " + wordMap.get(word));
        }
    }
}



