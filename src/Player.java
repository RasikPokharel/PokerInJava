import java.util.LinkedList;

public class Player {
    LinkedList<Card> hand = new LinkedList<Card>();
    int money = 1000;
    String Name = "Player Unknown";
    int roundBet = 0;
    boolean bigblind = false;
    boolean smallblind = false;
    boolean turn = false;
    boolean folded = true;

    public Player(int guap, String name){
        money = guap;
        Name = name;


    }

}
