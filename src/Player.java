import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    int money = 1000;
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

    public ArrayList<Card> getHand() {
        return this.hand;
    }
}
