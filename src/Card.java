import java.util.LinkedList;

public class Card {
    String suit;
    int value;
    public Card(int val, String type){


        if (type == "Heart" || type == "heart" || type == "Hearts" || type == "hearts" ) {
            suit = "♥";
        }else if(type == "Club" || type == "club" || type == "Clubs" || type == "clubs"){
            suit = "♣";
        }else if(type == "Diamond" || type == "diamond" || type == "Diamonds" || type == "diamonds"){
            suit = "♦";

        }else if(type == "Spade"|| type == "spade" || type == "Spades" || type == "Spades" ){
            suit = "♠";
        }else{

        }




        value = val;

    }
    public static String to_String(Card c){
        String val = "poop";
        if (c.value <= 1){
            val = "A ";

        }else if (c.value < 10) {
            val = " " + String.valueOf(c.value);
        }else if (c.value == 10){
            val = String.valueOf(c.value);
        }else if (c.value == 11){
            val = "J ";
        }else if (c.value == 12){
            val = "Q ";
        }else {
            val = "K ";
        }






        String card1 = " -------------\n" +
                "|%s%s          | \n" +
                "|   -------   | \n" +
                "|  |       |  | \n" +
                "|  |       |  | \n" +
                "|  |   %s   |  | \n" +
                "|  |       |  | \n" +
                "|  |       |  | \n" +
                "|   -------   | \n" +
                "|          %s%s| \n" +
                " -------------  ";
        String card  = String.format(card1, val,c.suit, c.suit,val,c.suit);
        return card;



    }


    public static void main(String[] args){
//        Card Ace_of_Spades = new Card(12, "♠");
////        System.out.println(Ace_of_Spades.value);
////        System.out.println(to_String(Ace_of_Spades));
//        Card King_of_Spades = new Card(13,"♠");
//
//        LinkedList<Card> list = new LinkedList<Card>();
////        System.out.print(list);
//        list.add(Ace_of_Spades);
////        System.out.print(list);
//        list.add(King_of_Spades);

//        System.out.print(to_String(list.get(1)));



    }
}
