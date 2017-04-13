package com.rallymonkey911.android.pokertrainer;

/**
 * Created by jeff on 3/24/2017.
 */

public class Card {

    /** The value of the card (e.g., SEVEN) */
    private final int mRank;

    /** The suit of the card (e.g., SPADES) */
    private final int mSuit;

    /** Resource ID of the card's full image file */
    private int mResourceIdFull;

    /** Resource ID of the card's small image file */
    private int mResourceIdSmall;

    /** Kinds of suits */
    final static int DIAMONDS    = 1;
    final static int CLUBS       = 2;
    final static int HEARTS      = 3;
    final static int SPADES      = 4;

    /** Kinds of ranks */
    final static int ACE     = 1;
    final static int DEUCE   = 2;
    final static int THREE   = 3;
    final static int FOUR    = 4;
    final static int FIVE    = 5;
    final static int SIX     = 6;
    final static int SEVEN   = 7;
    final static int EIGHT   = 8;
    final static int NINE    = 9;
    final static int TEN     = 10;
    final static int JACK    = 11;
    final static int QUEEN   = 12;
    final static int KING    = 13;



    /**
     * Constructs a new Card object.
     *
     * @param rank is the card's numeric (int) value
     * @param suit is the card's suit
     * //@param resourceId is the resource identifier for the card's .PNG image file
     */
    Card(int rank, int suit, int resourceIdFull, int resourceIdSmall) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        mRank = rank;
        mSuit = suit;
        mResourceIdFull = resourceIdFull;
        mResourceIdSmall = resourceIdSmall;
    }

    /**
     *
     * @return the value of the card
     */
    private int getmRank() {return mRank;}

    /**
     *
     * @return the suit of the card
     */
    private int getmSuit() {return mSuit;}

    /**
     *
     * @return the resource ID of the card's full image file
     */
    int getmResourceIdFull() {return mResourceIdFull;}

    /**
     *
     * @return the resource ID of the card's small image file
     */
    int getmResourceIdSmall() {return mResourceIdSmall;}

    /**
     * Check if the card's rank is valid
     *
     * @param rank the rank of the card
     * @return whether the rank is valid
     */
    private static boolean isValidRank(int rank) {
        return ACE <= rank && rank <= KING;
    }

    /**
     * Check if the card's suit is valid
     *
     * @param suit the card's suit
     * @return whether the suit is valid
     */
    private static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    /**
     * Returns the card's rank as a String
     *
     * @param rank the card's rank
     * @return a String representation of the card's rank
     */
    private static String rankToString(int rank) {
        switch (rank) {
            case ACE:
                return "Ace";
            case DEUCE:
                return "Deuce";
            case THREE:
                return "Three";
            case FOUR:
                return "Four";
            case FIVE:
                return "Five";
            case SIX:
                return "Six";
            case SEVEN:
                return "Seven";
            case EIGHT:
                return "Eight";
            case NINE:
                return "Nine";
            case TEN:
                return "Ten";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            default:
                return null;
        }
    }

    /**
     * Returns the card's suit as a String
     *
     * @param suit the card's suit
     * @return a String representation of the card's suit
     */
    private static String suitToString(int suit) {
        switch (suit) {
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            case HEARTS:
                return "Hearts";
            case SPADES:
                return "Spades";
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        String suitAsString;

        switch (getmSuit()){
            case 1:
                suitAsString = "D";
                break;
            case 2:
                suitAsString = "C";
                break;
            case 3:
                suitAsString = "H";
                break;
            default:
                suitAsString = "S";
                break;
        }

        return "" + getmRank() + suitAsString;
    }

    public String toStringFullName(){
        return rankToString(getmRank()) + " of " + suitToString(getmSuit());
    }
}
