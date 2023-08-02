

import java.util.*;


public class Exercise21_07 {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";
        // Create a HashMap to hold words as key and count as value
        Map<String, Integer> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();
        String[] words = text.split("[ \n\t\r.,;:!?(){]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        ArrayList<WordOccurrence> wordOccurrences = new ArrayList<>();
        // Get all entries into a set
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        // Get key and value from each entry
        for (Map.Entry<String, Integer> entry : entrySet) {
            wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordOccurrences);
        for (WordOccurrence wordOccurrence : wordOccurrences) {
            System.out.println(wordOccurrence);
        }
    }
}

class WordOccurrence implements Comparable<WordOccurrence> {
    String word;
    int count;

    public WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordOccurrence that) {
        return Integer.compare(this.count, that.count);
    }

    @Override
    public String toString() {
        return "WordOccurrence{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}

