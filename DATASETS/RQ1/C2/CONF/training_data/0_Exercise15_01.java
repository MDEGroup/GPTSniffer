import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardGame {
    private List<String> deck;
    private List<String> cardsOnTable;
    private JLabel[] cardLabels;

    public CardGame() {
        deck = new ArrayList<>();
        cardsOnTable = new ArrayList<>();
        cardLabels = new JLabel[4];

        // Initialize the deck
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        // Initialize the GUI
        JFrame frame = new JFrame("Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        for (int i = 0; i < 4; i++) {
            cardLabels[i] = new JLabel();
            panel.add(cardLabels[i]);
        }

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCards();
            }
        });
        panel.add(refreshButton);

        frame.setSize(400, 100);
        frame.setVisible(true);
    }

    private void refreshCards() {
        // Shuffle the deck and deal four cards
        Collections.shuffle(deck);
        cardsOnTable.clear();
        for (int i = 0; i < 4; i++) {
            cardsOnTable.add(deck.get(i));
        }

        // Update the card labels
        for (int i = 0; i < 4; i++) {
            cardLabels[i].setText(cardsOnTable.get(i));
        }
    }

    public static void main(String[] args) {
        new CardGame();
    }
}