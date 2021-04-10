import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    int money;
    String Name = "Player Unknown";
    int roundBet = 0;
    boolean bigblind = false;
    boolean smallblind = false;
    boolean turn = false;
    boolean folded = false;

    public Player(int guap, String name){
        money = guap;
        Name = name;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }
    public void printHand() {
        System.out.println();
        System.out.println(this.Name + "'s Hand");
        System.out.println("====================");
        for (Card card: this.hand) {
            System.out.print(card.getValue() + " " + card.getSuit() + " | ");
        }
        System.out.println();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }
}
