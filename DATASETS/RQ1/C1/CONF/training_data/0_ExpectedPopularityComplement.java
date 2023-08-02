import java.util.List;

public class EPC {
    public static double calculateEPC(List<Double> popularityScores) {
        int size = popularityScores.size();
        double epc = 0;
        double totalPopularity = 0;
        for (double score : popularityScores) {
            totalPopularity += score;
        }
        for (int i = 0; i < size; i++) {
            double popularity = popularityScores.get(i);
            epc += (1 - popularity / totalPopularity) * popularity;
        }
        return epc;
    }
}

