public class test {


    public static void main(String[] args) {

        Card card = new Card(9, Suit.CLUB);
        Deck deck = new Deck();
        Player p1 = new Player(100, "bob");
        Player p2 = new Player(100, "nob");

        p1.addCard(deck.pop());
        p1.addCard(deck.pop());
        p1.addCard(deck.pop());
        p1.addCard(deck.pop());

        p2.addCard(deck.pop());
        p2.addCard(deck.pop());
        p2.addCard(card);

        p1.printHand();
        p2.printHand();
    }
}

