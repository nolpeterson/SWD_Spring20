/**
 * The type Card.
 */
public class Card{
    /**
     * The Value of a card.
     */
    private int value;
    /**
     * The Face of a card.
     */
    private final char face;
    /**
     * The Suit of a card.
     */
    private final char suit;

    /**
     * Instantiates a new Card.
     * @param suit the suit
     * @param value the value
     */
    public Card(char suit, int value){
        this.value = value;
        this.suit = suit;

        //Set the face of each card
        switch (value) {
            case 1:
                this.face = 'A';
                break;
            case 2:
                this.face = '2';
                break;
            case 3:
                this.face = '3';
                break;
            case 4:
                this.face = '4';
                break;
            case 5:
                this.face = '5';
                break;
            case 6:
                this.face = '6';
                break;
            case 7:
                this.face = '7';
                break;
            case 8:
                this.face = '8';
                break;
            case 9:
                this.face = '9';
                break;
            case 10:
                this.face = 'T';
                break;
            case 11:
                this.face = 'J';
                break;
            case 12:
                this.face = 'Q';
                break;
            case 13:
                this.face = 'K';
                break;
            default:
                this.face = ' ';
        }

        //Face cards are worth 10 in blackjack
        if (value >= 10) {
            this.value = 10;
        }
    }

    /**
     * Gets value of card.
     * @return the value
     */
    public int getValue() {
        return (value);
    }

    /**
     * Gets suit of card.
     * @return the suit
     */
    public char getSuit() {
        return (suit);
    }

    /**
     * Gets face of card.
     * @return the face
     */
    public char getFace() {
        return (face);
    }

    /**
     * To string method the face and suit of card.
     * @return teh face and suit of card
     */
    public String toString() {
        return (face + " of " + suit);
    }
}
