import javax.naming.LinkLoopException;
import java.util.LinkedList;
import java.util.*;

public class Game {
    LinkedList<Card> deck = new LinkedList<Card>();
    LinkedList<Player> playerList = new LinkedList<Player>();
    LinkedList<Card> tableCards = new LinkedList<Card>();
    int minBlind = 0;
    int pool = 0;
    int to_call = minBlind;
    int turnCounter = 0;



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
    public void give_cards(){

//        System.out.print(playerList.size());


        for (int i = 0; i < this.playerList.size(); i++){
            for (int j = 0; j < 2; j++ ){
//                System.out.println(i);
                int size = this.deck.size() -1 ;
                int random_int = (int)(Math.random() * (size + 1));
                Card temp_card  = this.deck.get(random_int);
                this.playerList.get(i).hand.add(temp_card);
                this.deck.remove(random_int);
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
    public void setBlind(){
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("What big blind would you like to start with");
        int bigblind = sc.nextInt();
        bigblind = this.minBlind;
    }


    public void main_GameLoop(){
//        Happens only at the start when initializing the game
//        game setup ( make player lists, give players cards)
//        usage  -(create game object and call main_GameLoop on said object)
//        blind is set by the user as well
        this.create_playerList();
        this.give_cards();
        this.setBlind();
        Boolean Gameover = false;
// Initialize variables from game
//        Initialize pointers
        int bigBlindPointer = this.playerList.size()-2;
        int smallBlindPointer = this.playerList.size()-3 ;
        int turn = this.playerList.size()-1;
        System.out.println("1");


//        turn, bbp and sbp are all
//        this needs to happen after every round is finished and someone has won the round
        this.playerList.get(bigBlindPointer).bigblind = true;
        this.playerList.get(smallBlindPointer).smallblind = true;
        this.playerList.get(turn).turn = true;
        System.out.println("2");

//       This is the round loop
//       Runs the entire time when someone hasn't yet won the hand
//        This has to take care of
        while(Gameover == false){
            System.out.println("3");

//            iterate pointers and assign temp pointer to the player whose turn it is in this round of play the big blind small blind and turn pointers all move one space
//            set turn counter to zero at the start of every round
            iterate(this.playerList, bigBlindPointer);
            iterate(this.playerList, smallBlindPointer);
            iterate(this.playerList, turn);
            int tempTurn = turn;
            this.turnCounter = 0;
//             the appropriate players receive the bbp sbp and turn pointers

            this.playerList.get(bigBlindPointer).bigblind = true;
            this.playerList.get(smallBlindPointer).smallblind = true;
            this.playerList.get(turn).turn = true;
//        Round begins
//        All players should have cards at this point


//       Loops through Player list and changes all the players and removes money from their balance and adds it to the pool.

//          If the player has big blind is true money is removed from their balance and put into the game balance
//          blinds are set to false for the next round
//          each players round bets are adjusted accordingly (round bets is how much money they have put in each round a round is a round of betting)

            for (int i = 0; i < this.playerList.size()-1; i++) {
                Player player = this.playerList.get(i);
                if (player.bigblind == true ) {
                    player.money -= minBlind;
                    this.pool += minBlind;
                    player.bigblind = false;
                    player.roundBet = minBlind;
                    System.out.println("4");

                } else if (player.smallblind == true ) {
                    player.money -= minBlind / 2;
                    this.pool += minBlind / 2;
                    player.smallblind = false;
                    player.roundBet = minBlind / 2;
                    System.out.println("5");

                }




            }
//            runs for every betting round when the bets are not equal for every player
            while (turn != -1){



                if (checkRoundBets()==true){
                    turn = -1;
                    this.turnCounter += 1;
                    this.to_call = 0;
                    System.out.println("6");
                }else if (this.playerList.get(turn).turn == true & this.playerList.get(turn).folded == true){
                    iterate(this.playerList, turn);
                    this.playerList.get(turn).turn = true;
                    System.out.println("7");
                }else if (this.playerList.get(turn).turn == true & this.playerList.get(turn).folded == false){
                    this.playTurn(playerList.get(turn));
                    iterate(this.playerList, turn);
                    this.playerList.get(turn).turn = true;
                    System.out.println("8");

                }else if(checkRoundBets()==true){

                }


//          runs after each betting round has been completed and all remaining players have put in the same amount of money
            }
//            turn is set back to what it was before the turn loop
            turn = tempTurn;

            if (this.turnCounter == 1){
                flop(this);
            }else if(this.turnCounter ==2){
                river(this);

            }else if (this.turnCounter ==3){
                turn(this);
            }else if (this.turnCounter ==4){
                this.compareHands();

                this.playerList.get(bigBlindPointer).bigblind = true;
                this.playerList.get(smallBlindPointer).smallblind = true;
                this.playerList.get(turn).turn = true;
            }
        }



    }
//    displays everything nessesary per turn and is called when a player has a turn on the game and the player
    public void display(Player unknown){
        System.out.println("This is your hand"+deckString(unknown.hand));
        System.out.println("This is whats on the table"+ this.tableCards);
        System.out.println("This is your balance"+ unknown.money);
        System.out.println("Player" + unknown.Name + "It is now your turn what will you do");
        System.out.println("Your options are call(" + (this.to_call- unknown.roundBet) +") Raise or Fold");
    }
    public Player compareHands(){

        return this.playerList.get(0);
    }
//    checks the state variables of the game and outputs true if all the players have bet the same amount in a round
    public boolean checkRoundBets(){
        LinkedList plist =this.playerList;
        int roundbet = -1;
        for (Player p: playerList){
// first iteration changes the round bet from -1 to first players round bet
            if (roundbet == -1){
                roundbet = p.roundBet;
            }
//            Second iteration and on checks if roundbet is the same as previously recorded roundbet if yes does nothing and if false returns false.
            if (roundbet == p.roundBet){
                roundbet = p.roundBet;

            }else{
                return false;
            }



        }
        return true;
    }
    public void playTurn(Player unknown){
        this.display(unknown);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input == "Call"){
            call(unknown);

        }else if(input == "Raise") {
            System.out.println("How much?");
            Scanner sc1 = new Scanner(System.in);
            int amt = sc1.nextInt();
            raise(unknown, amt);
        }else if(input == "Fold");
            fold(unknown);




//        take inputs for raise, call or fold


    }
    public void raise(Player unknown, int amt){
        this.to_call = amt+unknown.roundBet;
        unknown.roundBet += amt;
        unknown.money -= amt;
        this.pool += amt;

    }
    public void fold(Player unknown){
        unknown.folded = true;
    }
    public void call(Player unknown){

        unknown.money -= this.to_call- unknown.roundBet;
        this.pool += this.to_call;

    }






    public int iterate(LinkedList a, int first){
        ListIterator iterator = a.listIterator();
        int index = first;
        if(iterator.hasNext()){
            first +=1;

        }else{
            first =0;
        }
        return index;


    }



    public static void main(String[] args){
    Game newgame = new Game();
    newgame.main_GameLoop();



// NOTES: Iterator creation isn't quite working properly
//        Checking Round bets is not working as intended
//





    }







}
