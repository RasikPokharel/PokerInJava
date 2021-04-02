import java.util.LinkedList;


public class Card {
    public enum Suit {
        HEART, CLUB, DIAMOND, SPADE
    }

    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    private String getSuitString() {
        return switch (this.suit) {
            case HEART -> "♥";
            case CLUB -> "♣";
            case DIAMOND -> "♦";
            case SPADE -> "♠";
        };
    }

    private String getValueString() {
        return switch (this.value) {
            case 1 -> "A ";
            case 10 -> "10";
            case 11 -> "J ";
            case 12 -> "Q ";
            case 13 -> "K ";
            default -> this.value + " ";
        };
    }

    public String toString(){
        String valString = this.getValueString();
        String suitString = this.getSuitString();

        String cardTemplate = " -------------\n" +
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

        return String.format(cardTemplate, valString, suitString, suitString, valString, suitString);
    }


    public static void main(String[] args){
//        Card Ace_of_Spades = new Card(1, Suit.SPADE);
//        System.out.println(Ace_of_Spades.toString());
//        System.out.println((Ace_of_Spades.toString()));
//        Card King_of_Spades = new Card(13,Suit.SPADE);
//
//        LinkedList<Card> list = new LinkedList<Card>();
//        System.out.print(list);
//        list.add(Ace_of_Spades);
//        System.out.print(list);
//        list.add(King_of_Spades);
//
//        System.out.print(list.get(1).toString());
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        System.out.println(list.listIterator(0).nextIndex());
//        System.out.println(list.get(-1));

    }
}

