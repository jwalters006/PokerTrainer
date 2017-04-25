package com.rallymonkey911.android.pokertrainer;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by jeff on 3/24/2017.
 */

public class Card implements Comparable<Card> {

    /** The value of the card (e.g., SEVEN) */
    private final int mRank;

    /** The suit of the card (e.g., SPADES) */
    private final int mSuit;

    /** Resource ID of the card's full image file */
    private int mResourceIdFull;

    /** Resource ID of the card's small image file */
    private int mResourceIdSmall;

    /** Kinds of suits */
    final static int SPADES      = 1;
    final static int HEARTS      = 2;
    final static int DIAMONDS    = 3;
    final static int CLUBS       = 4;

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
    public int getmRank() {return mRank;}

    /**
     *
     * @return the suit of the card
     */
    public int getmSuit() {return mSuit;}

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
        return SPADES <= suit && suit <= CLUBS;
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
                suitAsString = "S";
                break;
            case 2:
                suitAsString = "H";
                break;
            case 3:
                suitAsString = "D";
                break;
            default:
                suitAsString = "C";
                break;
        }

        return "" + getmRank() + suitAsString;
    }

    public String toStringWithLetters() {
        String suitAsString;
        String ranksAsString;

        switch (getmSuit()) {
            case 1:
                suitAsString = "S";
                break;
            case 2:
                suitAsString = "H";
                break;
            case 3:
                suitAsString = "D";
                break;
            default:
                suitAsString = "C";
                break;
        }

        switch (getmRank()) {
            case 1:
                ranksAsString = "A";
                break;
            case 10:
                ranksAsString = "T";
                break;
            case 11:
                ranksAsString = "J";
                break;
            case 12:
                ranksAsString = "Q";
                break;
            case 13:
                ranksAsString = "K";
                break;
            default:
                ranksAsString = String.valueOf(getmRank());
                break;
        }

        return "" + ranksAsString + suitAsString;
    }

    public String toStringFullName(){
        return rankToString(getmRank()) + " of " + suitToString(getmSuit());
    }

    @Override
    public int compareTo(@NonNull Card o) {
        if (this.getmSuit() == o.getmSuit()) {
            return this.getmRank() > o.getmRank() ? 1 : -1;
        } else {
            return this.getmSuit() > o.getmSuit() ? 1 : -1;
        }
    }
}
