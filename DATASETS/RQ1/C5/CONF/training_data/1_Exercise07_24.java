

import java.util.Arrays;


public class CouponHandler{
    public static void main(String[] args) {
        
        int[] deck = getShuffledDeck();
        
        int[] suits = new int[4];

        int numPicks = 0;
        while (suits[0] != 1 || suits[1] != 1 || suits[2] != 1 || suits[3] != 1) {
            int card = pickACard(deck);
            printCard(card);
            numPicks++;

            if (card >= 1 && card <= 13) {
                suits[0] = 1;
            } else if (card >= 14 && card <= 26) {
                suits[1] = 1;
            } else if (card >= 27 && card <= 39) {
                suits[2] = 1;
            } else if (card >= 40) {
                suits[3] = 1;
            }
        }
        System.out.println("Number of picks: " + numPicks);
    }

    static void printCard(int card) {
        String suit = "";
        if (card >= 1 && card <= 13) {
            suit += "Hearts\n";
        } else if (card >= 14 && card <= 26) {
            suit += "Diamonds\n";
        } else if (card >= 27 && card <= 39) {
            suit += "Clubs\n";
        } else if (card >= 40) {
            suit += "Spades\n";
        }
        if (card > 13) {
            while (card >= 13) {
                card -= 13;
            }
        }

        String value = "";
        switch (card) {
            case 1:
                value += "Ace of ";
                break;
            case 11:
                value += "Jack of ";
                break;
            case 12:
                value += "Queen of ";
                break;
            case 13:
                value += "King of ";
                break;
            default:
                value = card + " of ";

        }

        System.out.print(value + suit);

    }

    static int pickACard(int[] deck) {
        return deck[(int) (Math.random() * 52)];
    }

    static int[] getShuffledDeck() {
        int[] dck = new int[52];

        for (int i = 0; i < 52; i++) {
            dck[i] = (i + 1);
        }
        
        for (int i = 0; i < 260; i++) {
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            int temp = dck[random1];
            dck[random1] = dck[random2];
            dck[random2] = temp;
        }

        return dck;
    }
}