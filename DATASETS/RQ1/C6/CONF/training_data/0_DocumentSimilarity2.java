import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.tartarus.snowball.ext.PorterStemmer;
import org.tartarus.snowball.ext.englishStemmer;

import opennlp.tools.stemmer.PorterStemmerAlgorithm;
import opennlp.tools.tokenize.SimpleTokenizer;

public class DocumentSimilarity {
    public static double jaccardSimilarity(String doc1, String doc2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        Set<String> stopWords = getStopWords();

        
        String[] tokens1 = SimpleTokenizer.INSTANCE.tokenize(doc1);
        String[] tokens2 = SimpleTokenizer.INSTANCE.tokenize(doc2);

        
        englishStemmer stemmer = new englishStemmer();

        for (String token : tokens1) {
            
            if (stopWords.contains(token)) {
                continue;
            }

            
            stemmer.setCurrent(token);
            stemmer.stem();
            set1.add(stemmer.getCurrent());
        }

        for (String token : tokens2) {
            
            if (stopWords.contains(token)) {
                continue;
            }

            
            stemmer.setCurrent(token);
            stemmer.stem();
            set2.add(stemmer.getCurrent());
        }

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return (double) intersection.size() / (double) union.size();
    }

    private static Set<String> getStopWords() {
        Set<String> stopWords = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(new File("src/main/resources/stopwords.txt").toURI()));
            for (String line : lines) {
                stopWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    public static void main(String[] args) {
        String doc1 = "This is the first document";
        String doc2 = "This is the second document";

        double similarity = jaccardSimilarity(doc1, doc2);
        System.out.println("Similarity: " + similarity);
    }
}

