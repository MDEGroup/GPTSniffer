
public class RandomCards {

    public static void main(String[] args) {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
        int card1 = deck.get(0);
        int card2 = deck.get(1);
        int card3 = deck.get(2);
        System.out.println("Card 1: " + card1 + ".png");
        System.out.println("Card 2: " + card2 + ".png");
        System.out.println("Card 3: " + card3 + ".png");
    }
}
