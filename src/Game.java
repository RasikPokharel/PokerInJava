import javax.naming.LinkLoopException;
import java.util.LinkedList;
import java.util.*;

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
//        System.out.print(playerList.size());


        for (int i = 0; i < playerList.size(); i++){
            for (int j = 0; j < 2; j++ ){
//                System.out.println(i);
                int size = deck.size() -1 ;
                int random_int = (int)(Math.random() * (size + 1));
                Card temp_card  = deck.get(random_int);
                playerList.get(i).hand.add(temp_card);
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
        for (int i = 0; i < deck.size() ; i++ ){
            s_deck += "\n" + Card.to_String(deck.get(i));

        }
        return s_deck;



    }

    public void create_playerList(){
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("how many players");
        int numplayers = sc.nextInt();


        for (int i = 0; i < numplayers; i++){
//            System.out.println(i);
            Scanner sc1= new Scanner(System.in);
            int num = i+1;
            System.out.println("Player" + num + " what is your name?");
            String name = sc1.nextLine();

            System.out.println( name +" what is your buy in amount?");
            int money = sc1.nextInt();

            Player newPlayer = new Player(money, name);
            this.playerList.add(newPlayer);
        }


    }



    public static void main(String[] args){
//        Player p1 = new Player(100, "poo");
//        Player p2 = new Player(100, "pee");
//        Player p3 = new Player(100, "poop");
//        LinkedList<Player> plist = new LinkedList<Player>();
//        plist.add(p1);
//        plist.add(p2);
//        plist.add(p3);


        Game newGame = new Game();
//        newGame.playerList = plist;
        newGame.create_playerList();
        give_cards(newGame);
        System.out.print(deckString(newGame.playerList.get(0).hand));
        System.out.print(deckString(newGame.playerList.get(1).hand));
        System.out.print(deckString(newGame.deck));








    }







}
