import java.util.ArrayList;
import java.util.List;

public class xQuAD {
    public static List<Integer> reRank(List<Double> relevanceScores, List<Double> popularityScores, double lambda) {
        int size = relevanceScores.size();
        List<Integer> ranking = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ranking.add(i);
        }
        ranking.sort((a, b) -> -Double.compare(lambda * relevanceScores.get(a) + (1 - lambda) * popularityScores.get(a),
                lambda * relevanceScores.get(b) + (1 - lambda) * popularityScores.get(b)));
        return ranking;
    }
}

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> relevanceScores = Arrays.asList(0.8, 0.7, 0.9, 0.6);
        List<Double> popularityScores = Arrays.asList(0.2, 0.1, 0.3, 0.4);
        double lambda = 0.8;
        List<Integer> ranking = xQuAD.reRank(relevanceScores, popularityScores, lambda);
        System.out.println("New ranking: " + ranking);
    }
}


// ================= second attempt ===========================


import java.util.ArrayList;
import java.util.List;

public class xQuAD {
    public static List<String> rerank(List<String> originalList, List<String> queryTerms, int numReranked) {
        List<String> rerankedList = new ArrayList<>();

        // The xQuAD algorithm implementation goes here
        // ...

        return rerankedList.subList(0, numReranked);
    }

    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("item1");
        originalList.add("item2");
        originalList.add("item3");

        List<String> queryTerms = new ArrayList<>();
        queryTerms.add("term1");
        queryTerms.add("term2");

        List<String> rerankedList = rerank(originalList, queryTerms, 2);
        for (String item : rerankedList) {
            System.out.println(item);
        }
    }
}
