import java.util.List;

public class NDCG {
    public static double calculateNDCG(List<Double> relevanceScores, List<Integer> ranking) {
        int size = relevanceScores.size();
        double dcg = 0;
        double idcg = calculateIDCG(relevanceScores);
        for (int i = 0; i < size; i++) {
            dcg += (Math.pow(2, relevanceScores.get(ranking.get(i))) - 1) / (Math.log(i + 2) / Math.log(2));
        }
        return dcg / idcg;
    }

    private static double calculateIDCG(List<Double> relevanceScores) {
        int size = relevanceScores.size();
        double idcg = 0;
        relevanceScores.sort((a, b) -> -Double.compare(a, b));
        for (int i = 0; i < size; i++) {
            idcg += (Math.pow(2, relevanceScores.get(i)) - 1) / (Math.log(i + 2) / Math.log(2));
        }
        return idcg;
    }
}
