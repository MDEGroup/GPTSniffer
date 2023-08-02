
public class CouponCollectorSimulation {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};

        Set<String> cards = new HashSet<String>();
        int picks = 0;

        while (cards.size() < 4 * suits.length) {
            int suitIndex = (int) (Math.random() * suits.length);
            int rankIndex = (int) (Math.random() * ranks.length);
            String card = ranks[rankIndex] + " of " + suits[suitIndex];
            cards.add(card);
            picks++;
        }

        System.out.println("Cards picked:");
        for (String card : cards) {
            System.out.println(card);
        }
        System.out.println("Number of picks: " + picks);
    }
}
