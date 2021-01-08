import java.util.Random;

/**
 * The type Deck.
 */
public class Deck {
    /**
     * The Suits, in unicode characters for Spade, Heart, Diamond, Club (in order)
     */
    private final char[] suits = {'\u2660', '\u2665', '\u2666', '\u2663'};
    /**
     * The Values of each card.
     */
    private final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    /**
     * The Next card in stack.
     */
    private int nextCard;
    /**
     * The current card.
     */
    private final Card[] myDeck;

    /**
     * Instantiates a new Deck.
     */
    public Deck(){
        nextCard = -1;
        myDeck = new Card[52];

        int numCards = 0;
        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < values.length; j++){
                myDeck[numCards] = new Card(suits[i], values[j]);
                numCards++;
            }
        }
    }

    /**
     * Prints out all elements of the deck, for testing purposes.
     */
    public void print(){
        System.out.println();
        for (int i = 0; i < 52; i++){
            if (i % 13 == 0 && i != 0) {
                System.out.println();
            }
            //add a comma to every card but the last one
            System.out.print(myDeck[i]);
            if (i != 51) {
                System.out.print(", ");
            }
        }
    }

    /**
     * Shuffle the deck randomly.
     */
    public void shuffle(){
        Random rand = new Random();
        for ( int i = myDeck.length-1; i > 0; i-- ) {
            int shuffle = rand.nextInt(52);
            Card temp = myDeck[i];
            myDeck[i] = myDeck[shuffle];
            myDeck[shuffle] = temp;
        }
    }

    /**
     * Hit the next card in deck.
     * @return the card
     */
    public Card hit(){
        if(nextCard < 52) {
            nextCard++;
        }
        System.out.println(myDeck[nextCard]);

        return myDeck[nextCard];
    }
}
