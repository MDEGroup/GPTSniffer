
public class DocumentSimilarity {
    public static double jaccardSimilarity(String doc1, String doc2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String word : doc1.split(" ")) {
            set1.add(word);
        }

        for (String word : doc2.split(" ")) {
            set2.add(word);
        }

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return (double) intersection.size() / (double) union.size();
    }

    public static void main(String[] args) {
        String doc1 = "This is the first document";
        String doc2 = "This is the second document";

        double similarity = jaccardSimilarity(doc1, doc2);
        System.out.println("Similarity: " + similarity);
    }
}

