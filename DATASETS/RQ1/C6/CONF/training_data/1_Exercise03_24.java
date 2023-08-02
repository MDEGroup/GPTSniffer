

import java.util.*;


public class CardPicker{
    public static void main(String[] args) {

        String card = "";
        String suit = "";
        String[] cards = new String[]{"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};

        int randomCard, randomSuit;
        randomCard = new Random().nextInt(13);
        randomSuit = new Random().nextInt(5);

        System.out.println("The card you picked is " + cards[randomCard] + " of " + suits[randomSuit]);

    }
}