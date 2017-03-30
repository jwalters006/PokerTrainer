package com.rallymonkey911.android.pokertrainer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Deck is a multidimensional array consisting of {@link Card} objects.
 * Created by jeff on 3/24/2017.
 */

public class Deck {

    /** Declare and initialize the fixed number of suits and ranks in a deck */
    public static final int NUM_SUITS = 4;
    public static final int NUM_RANKS = 13;

    /** Declare and initialize the directory portion of the file path to the card images */
    public static final String RES_FILE_PATH = "drawable/";

    /** Declare a multidimensional array of {@link Card} objects */
    private Card[][] cards;

    /**
     * Constructor for deck of cards, consisting of 52 {@link Card} objects in a multidimensional
     * array.  The deck is built using a nested "for" loop to assign values to each Card.  In
     * addition, each Card object is assigned a resource ID (referring to a .PNG image file).
     * @param context The current context ({@link MainActivity})
     */
    public Deck(Context context) {

        cards = new Card[NUM_SUITS][NUM_RANKS];
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                int resId = context.getResources().getIdentifier(RES_FILE_PATH +
                                getCardFileName(suit, rank) + "_small_version", null,
                                context.getPackageName());
                cards[suit-1][rank-1] = new Card(rank, suit, resId);
            }
        }
    }

    /**
     * Programmatically generate the final portion of the pathname of the given Card's image file.
     *
     * @param suit The suit of the Card
     * @param rank The rank of the Card
     * @return The rest of the path to the Card's image file (first part of the path is given in
     * the constant, "RES_FILE_PATH".
     */
    public String getCardFileName(int suit, int rank){
        String suitAsString;
        String rankAsString = "" + rank;
        String separator = "_";

        switch (suit){
            case 1:     suitAsString = "d";
                        break;
            case 2:     suitAsString = "c";
                        break;
            case 3:     suitAsString = "h";
                        break;
            case 4:     suitAsString = "s";
                        break;
            default:    suitAsString = null;
                        break;
        }
        return suitAsString + separator + rankAsString;
    }

    /**
     * Fetch a particular {@link Card} out of the {@link Deck}, given the suit and rank
     * @param suit of the requested card
     * @param rank of the requested card
     * @return the requested {@link Card}
     */
    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }

    /**
     * Return a {@link ArrayList} of Card objects, constructed using a {@link Deck} of Cards
     *
     * @param deck The original source of the Card objects
     * @return An ArrayList of Card objects retrieved from the Deck
     */
    public static List<List<Card>> getCardArrayList(Deck deck){
        List<List<Card>> cardArrayList = new ArrayList<>();
        List<Card> diamondsArrayList = new ArrayList<>();
        List<Card> heartsArrayList = new ArrayList<>();
        List<Card> clubsArrayList = new ArrayList<>();
        List<Card> spadesArrayList = new ArrayList<>();

        for (int suit = Card.DIAMONDS; suit <= Card.DIAMONDS; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                diamondsArrayList.add(deck.getCard(suit, rank));
            }
        }

        for (int suit = Card.HEARTS; suit <= Card.HEARTS; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                heartsArrayList.add(deck.getCard(suit, rank));
            }
        }

        for (int suit = Card.CLUBS; suit <= Card.CLUBS; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                clubsArrayList.add(deck.getCard(suit, rank));
            }
        }

        for (int suit = Card.SPADES; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                spadesArrayList.add(deck.getCard(suit, rank));
            }
        }

        cardArrayList.add(diamondsArrayList);
        cardArrayList.add(heartsArrayList);
        cardArrayList.add(clubsArrayList);
        cardArrayList.add(spadesArrayList);
        return cardArrayList;
    }

}
