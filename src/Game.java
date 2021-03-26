import javax.naming.LinkLoopException;
import java.util.LinkedList;

public class Game {
    LinkedList<Card> deck = new LinkedList<Card>();
    LinkedList<Player> playerList = new LinkedList<Player>();
    LinkedList<Card> tableCards = new LinkedList<Card>();


    public Game(){
//        Creates a non randomized deck
        LinkedList<String> suits = new LinkedList<String>();
        suits.add("Hearts");
        suits.add("Spades");
        suits.add("Diamonds");
        suits.add("Clubs");
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                Card tempCard = new Card(i, suits.get(j));
                deck.add(tempCard);

            }
        }


    }
    public static void give_cards(Game a){
        LinkedList<Card> deck = a.deck;
        LinkedList<Player> playerList = a.playerList;


        for (int i = 0; i < playerList.size(); i++){
            for (int j = 0; j < 2; j++ ){
                int size = deck.size() -1 ;
                int random_int = (int)(Math.random() * (size + 1));
                Card temp_card  = deck.get(random_int);
                playerList.get(random_int).hand.add(temp_card);
                deck.remove(random_int);
                }
        }
    }

    public static void flop(Game a){
        LinkedList<Card> deck = a.deck;
        LinkedList<Card> table = a.tableCards;
        for (int j = 0; j < 3; j++ ){
            int size = deck.size() -1 ;
            int random_int = (int)(Math.random() * (size + 1));
            Card temp_card  = deck.get(random_int);
            table.add(temp_card);
            deck.remove(random_int);
        }

    }
    public static void river(Game a){
        LinkedList<Card> deck = a.deck;
        LinkedList<Card> table = a.tableCards;
        int size = deck.size() -1 ;
        int random_int = (int)(Math.random() * (size + 1));
        Card temp_card  = deck.get(random_int);
        table.add(temp_card);
        deck.remove(random_int);

    }
    public static void turn(Game a){
        LinkedList<Card> deck = a.deck;
        LinkedList<Card> table = a.tableCards;
        int size = deck.size() -1 ;
        int random_int = (int)(Math.random() * (size + 1));
        Card temp_card  = deck.get(random_int);
        table.add(temp_card);
        deck.remove(random_int);

    }
    public void bet(int x){

    }

    public static String deckString(LinkedList<Card> deck){
        String s_deck = " ";
        for (int i = 0; i < deck.size()-1 ; i++ ){
            s_deck += "\n" + Card.to_String(deck.get(i));

        }
        return s_deck;



    }

    public static void create_player(){

    }



    public static void main(String[] args){
        Game newGame = new Game();
        give_cards(newGame);
        LinkedList p = newGame.playerList.get(0).hand;
        deckString(p);

    }







}
