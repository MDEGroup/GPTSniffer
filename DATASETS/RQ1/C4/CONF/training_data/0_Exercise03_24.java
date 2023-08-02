import java.util.Random;

public class CardPicker {
    public static void main(String[] args) {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        
        Random random = new Random();

        
        int rankIndex = random.nextInt(13);
        int suitIndex = random.nextInt(4);

        
        String rank = ranks[rankIndex];
        String suit = suits[suitIndex];
        System.out.println(rank + " of " + suit);
    }
}