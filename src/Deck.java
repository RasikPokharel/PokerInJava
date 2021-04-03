import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final int SIZE = 52;
    private ArrayList<Card> deck = new ArrayList<Card>(this.SIZE);

    public Deck() {
        Suit[] suits = {Suit.HEART, Suit.SPADE, Suit.CLUB, Suit.DIAMOND};

        for (int value = 1; value < 14; value++) {
            for (int suit = 0; suit < 4; suit++) {
                Card tempCard = new Card(value, suits[suit]);
                this.deck.add(tempCard);
            }
        }
        this.shuffle();
    }

    public Card pop() {
        return deck.remove(0);
    }

    public void shuffle() {

        Random randInt = new Random();

        for (int i = 0; i < this.SIZE; i++) {
            int randomCard = randInt.nextInt(this.SIZE - i) + i;

            Card temp = deck.get(randomCard);
            deck.set(randomCard, deck.get(i));
            deck.set(i, temp);
        }
    }



}

