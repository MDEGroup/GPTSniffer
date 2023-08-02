
public class CollaborativeFilteringRecommender {

    private int[][] ratings;
    private Map<Integer, List<Integer>> userToItems;

    public CollaborativeFilteringRecommender(int[][] ratings) {
        this.ratings = ratings;
        this.userToItems = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            List<Integer> items = new ArrayList<>();
            for (int j = 0; j < ratings[i].length; j++) {
                if (ratings[i][j] > 0) {
                    items.add(j);
                }
            }
            userToItems.put(i, items);
        }
    }

    public List<Integer> recommend(int user, int k) {
        List<Integer> similarUsers = findSimilarUsers(user, k);
        Map<Integer, Double> itemToScore = new HashMap<>();
        for (int i : userToItems.get(user)) {
            double sum = 0.0;
            double count = 0.0;
            for (int j : similarUsers) {
                if (userToItems.get(j).contains(i)) {
                    sum += ratings[j][i];
                    count += 1.0;
                }
            }
            if (count > 0.0) {
                itemToScore.put(i, sum / count);
            }
        }
        List<Integer> recommendations = new ArrayList<>();
        for (int i = 0; i < ratings[user].length; i++) {
            if (ratings[user][i] == 0 && itemToScore.containsKey(i)) {
                recommendations.add(i);
            }
        }
        recommendations.sort((i1, i2) -> Double.compare(itemToScore.get(i2), itemToScore.get(i1)));
        return recommendations;
    }

    private List<Integer> findSimilarUsers(int user, int k) {
        List<Integer> similarUsers = new ArrayList<>();
        double[] similarities = new double[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i != user) {
                similarities[i] = cosineSimilarity(ratings[user], ratings[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            int maxIndex = -1;
            double maxSimilarity = -1.0;
            for (int j = 0; j < similarities.length; j++) {
                if (similarities[j] > maxSimilarity) {
                    maxIndex = j;
                    maxSimilarity = similarities[j];
                }
            }
            similarUsers.add(maxIndex);
            similarities[maxIndex] = -1.0;
        }
        return similarUsers;
    }

    private double cosineSimilarity(int[] v1, int[] v2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (int i = 0; i < v1.length; i++) {
            dotProduct += v1[i] * v2[i];
            norm1 += v1[i] * v1[i];
            norm2 += v2[i] * v2[i];
        }
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}

