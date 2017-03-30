package com.rallymonkey911.android.pokertrainer;

/**
 * Created by jeff on 3/24/2017.
 */

public class Card {

    /** The value of the card (e.g., SEVEN) */
    private final int mRank;

    /** The suit of the card (e.g., SPADES) */
    private final int mSuit;

    /** Resource ID of the card's image file */
    private int mResourceId;

    /** Kinds of suits */
    public final static int DIAMONDS    = 1;
    public final static int CLUBS       = 2;
    public final static int HEARTS      = 3;
    public final static int SPADES      = 4;

    /** Kinds of ranks */
    public final static int ACE     = 1;
    public final static int DEUCE   = 2;
    public final static int THREE   = 3;
    public final static int FOUR    = 4;
    public final static int FIVE    = 5;
    public final static int SIX     = 6;
    public final static int SEVEN   = 7;
    public final static int EIGHT   = 8;
    public final static int NINE    = 9;
    public final static int TEN     = 10;
    public final static int JACK    = 11;
    public final static int QUEEN   = 12;
    public final static int KING    = 13;



    /**
     * Constructs a new Card object.
     *
     * @param rank is the card's numeric (int) value
     * @param suit is the card's suit
     * //@param resourceId is the resource identifier for the card's .PNG image file
     */
    public Card(int rank, int suit, int resourceId) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        mRank = rank;
        mSuit = suit;
        mResourceId = resourceId;
    }

    /**
     *
     * @return the value of the card
     */
    public int getmRank() {return mRank;}

    /**
     *
     * @return the suit of the card
     */
    public int getmSuit() {return mSuit;}

    /**
     *
     * @return the resource ID of the card's image file
     */
    public int getmResourceId() {return mResourceId;}

    /**
     * Check if the card's rank is valid
     *
     * @param rank the rank of the card
     * @return whether the rank is valid
     */
    public static boolean isValidRank(int rank) {
        return ACE <= rank && rank <= KING;
    }

    /**
     * Check if the card's suit is valid
     *
     * @param suit the card's suit
     * @return whether the suit is valid
     */
    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    /**
     * Returns the card's rank as a String
     *
     * @param rank the card's rank
     * @return a String representation of the card's rank
     */
    public static String rankToString(int rank) {
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
    public static String suitToString(int suit) {
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
        return rankToString(getmRank()) + " of " + suitToString(getmSuit());
    }
}
