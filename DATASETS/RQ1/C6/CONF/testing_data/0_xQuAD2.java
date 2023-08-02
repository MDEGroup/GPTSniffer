import java.util.List;
import java.util.Map;

public class xQuAD {

    
    private List<Document> collection;

    
    private String query;

    
    private Map<Document, Boolean> relevanceJudgment;

    public xQuAD(List<Document> collection, String query, Map<Document, Boolean> relevanceJudgment) {
        this.collection = collection;
        this.query = query;
        this.relevanceJudgment = relevanceJudgment;
    }

    public List<Document> run() {
        
        List<Document> selected = new ArrayList<>();

        
        Map<Document, Double> weight = new HashMap<>();
        for (Document doc : collection) {
            weight.put(doc, 1.0);
        }

        
        Map<String, Double> termWeight = new HashMap<>();
        for (String term : query.split(" ")) {
            termWeight.put(term, 1.0);
        }

        
        int numIterations = 10;

        for (int i = 0; i < numIterations; i++) {
            
            Document maxDoc = null;
            double maxWeight = Double.NEGATIVE_INFINITY;
            for (Document doc : collection) {
                double weightSum = 0;
                for (String term : query.split(" ")) {
                    weightSum += termWeight.get(term) * doc.tf(term);
                }
                if (weightSum > maxWeight) {
                    maxWeight = weightSum;
                    maxDoc = doc;
                }
            }

            
            selected.add(maxDoc);

            
            for (Document doc : collection) {
                double weightSum = 0;
                for (String term : query.split(" ")) {
                    weightSum += termWeight.get(term) * doc.tf(term);
                }
                weight.put(doc, weight.get(doc) * Math.exp(-1 * weightSum));
            }

            
            for (String term : query.split(" ")) {
                double weightSum = 0;
                for (Document doc : collection) {
                    weightSum += doc.tf(term) * weight.get(doc);
                }
                termWeight.put(term, termWeight.get(term) * Math.exp(-1 * weightSum));
            }
        }

        return selected;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        List<Document> collection = new ArrayList<>();
        collection.add(new Document("doc1", "The quick brown fox jumps over the lazy dog"));
        collection.add(new Document("doc2", "The quick brown fox jumps over the lazy dog"));
        collection.add(new Document("doc3", "The quick brown fox jumps over the lazy dog"));
        collection.add(new Document("doc4", "The quick brown fox jumps over the lazy dog"));
        collection.add(new Document("doc5", "The quick brown fox jumps over the lazy dog"));

        
        String query = "brown fox";

        
        Map<Document, Boolean> relevanceJudgment = new HashMap<>();
        relevanceJudgment.put(collection.get(0), true);
        relevanceJudgment.put(collection.get(1), false);
        relevanceJudgment.put(collection.get(2), true);
        relevanceJudgment.put(collection.get(3), false);
        relevanceJudgment.put(collection.get(4), true);

        
        xQuAD xquad = new xQuAD(collection, query, relevanceJudgment);

        
        List<Document> selected = xquad.run();

        
        for (Document doc : selected) {
            System.out.println(doc.getId());
        }
    }
}

