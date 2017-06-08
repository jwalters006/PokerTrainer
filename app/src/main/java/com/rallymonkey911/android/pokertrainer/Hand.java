package com.rallymonkey911.android.pokertrainer;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jeff on 4/10/2017.
 */

final class Hand {

    static List<String> handAsStringList(List<Card> hand) {
        List<String> handAsStringList = new ArrayList<>();
        for (Card card : hand) {
            handAsStringList.add(card.toString());
        }
        return handAsStringList;
    }

    static List<Integer> cardRanks(List<String> hand) {
        List<Integer> ranks = new ArrayList<>();
        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1);
            ranks.add(Integer.parseInt(rank));
        }
        Collections.sort(ranks, Collections.reverseOrder());
        if (ranks.equals(new ArrayList<>(Arrays.asList(
                new Integer[]{Card.KING, Card.QUEEN, Card.JACK, Card.TEN, Card.ACE})))) {
            return new ArrayList<>(Arrays.asList(new Integer[]{Card.HIGH_ACE, Card.KING,
                    Card.QUEEN, Card.JACK, Card.TEN}));
        } else {
            return ranks;
        }
    }

    static boolean isFlush(List<String> hand) {
        Collection<String> suits = new HashSet<>();
        for (String card : hand) {
            suits.add(card.substring(card.length() - 1));
        }
        return suits.size() == 1;
    }

    static boolean isStraight(List<Integer> ranks) {
        Collection<Integer> sortedRanks = new HashSet<>(ranks);
        return (ranks.get(0) - ranks.get(4) == 4 && sortedRanks.size() == 5);
    }

    static boolean isStraightFlush(List<String> hand) {
        return Hand.isFlush(hand) && Hand.isStraight(Hand.cardRanks(hand));
    }

    static boolean isRoyalFlush(List<String> hand) {
        return Hand.isFlush(hand) && Hand.isStraight(Hand.cardRanks(hand)) &&
                Hand.cardRanks(hand).contains(Card.HIGH_ACE);
    }

    static Integer kind(int n, List<Integer> ranks) {
        for (int rank : ranks) {
            if (Collections.frequency(ranks, rank) == n) {
                return rank;
            }
        }
        return null;
    }

    static boolean isFullHouse(List<String> hand) {
        return Hand.kind(3, Hand.cardRanks(hand)) != null &&
                Hand.kind(2, Hand.cardRanks(hand)) != null;
    }

    static Integer[] twoPair(List<Integer> ranks) {
        List<Integer> sortedRanks = new ArrayList<>(ranks);
        Collections.sort(sortedRanks);
        Integer[] pair = new Integer[2];
        pair[0] = kind(2, ranks);
        pair[1] = kind(2, sortedRanks);
        if (pair[0] != null) {
            if (!pair[1].equals(pair[0])) {
                return pair;
            }
            return null;
        }
        return null;
    }

    static boolean isJacksOrBetterPair(List<String> hand) {
        int numberOfJacks = 0;
        int numberOfQueens = 0;
        int numberOfKings = 0;
        int numberOfAces = 0;

        List<Integer> ranks = Hand.cardRanks(hand);

        for (int rank : ranks) {
            if (rank == Card.JACK) {
                numberOfJacks++;
            } else if (rank == Card.QUEEN) {
                numberOfQueens++;
            } else if (rank == Card.KING) {
                numberOfKings++;
            } else if (rank == Card.ACE || rank == Card.HIGH_ACE) {
                numberOfAces++;
            }
        }

        if (numberOfJacks == 2 ||
                numberOfQueens == 2 ||
                numberOfKings == 2 ||
                numberOfAces == 2) {
            return true;
        } else {
            return false;
        }

    }

    static String sortedTomHandString(List<Card> hand) {
        StringBuilder handTomStringSorted = new StringBuilder();
        List<Card> handCopy = new ArrayList<>(hand);
        Collections.sort(handCopy);

        for (Card card : handCopy) {
            handTomStringSorted.append(card.toStringWithLetters());
        }
        return handTomStringSorted.toString();
    }

    static String getWinningHandString(Context context, String gameSelected, List<Card> hand) {
        if (gameSelected == context.getString(R.string.jacks_or_better)) {
            return getWinningJacksOrBetterString(context, hand);
        } else if (gameSelected == context.getString(R.string.deuces_wild)) {
            return getWinningDeucesWildString(context, hand);
        }
        return "";
    }

    static String getWinningJacksOrBetterString(Context context, List<Card> hand) {
        List<String> handString = handAsStringList(hand);
        if (Hand.isRoyalFlush(handString)) {
            return context.getString(R.string.royal_flush);
        } else if (Hand.isStraightFlush(handString)) {
            return context.getString(R.string.straight_flush);
        } else if (Hand.kind(4, Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.four_kind);
        } else if (Hand.isFullHouse(handString)) {
            return context.getString(R.string.full_house);
        } else if (Hand.isFlush(handString)) {
            return context.getString(R.string.flush);
        } else if (Hand.isStraight(Hand.cardRanks(handString))) {
            return context.getString(R.string.straight);
        } else if (Hand.kind(3, Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.three_kind);
        } else if (Hand.twoPair(Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.two_pair);
        } else if (Hand.isJacksOrBetterPair(handString)) {
            return context.getString(R.string.jacks_or_better);
        } else {
            return context.getString(R.string.no_win);
        }
    }

    static String getWinningDeucesWildString(Context context, List<Card> hand) {
        List<String> handString = handAsStringList(hand);
        if (Hand.isRoyalFlush(handString)) {
            return context.getString(R.string.natural_royal_flush);
        } else if (Hand.kind(4, Hand.cardRanks(handString)).equals(2)) {
            return "four two's!";
        } else if (Hand.isStraightFlush(handString)) {
            return context.getString(R.string.straight_flush);
        } else if (Hand.kind(4, Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.four_kind);
        } else if (Hand.isFullHouse(handString)) {
            return context.getString(R.string.full_house);
        } else if (Hand.isFlush(handString)) {
            return context.getString(R.string.flush);
        } else if (Hand.isStraight(Hand.cardRanks(handString))) {
            return context.getString(R.string.straight);
        } else if (Hand.kind(3, Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.three_kind);
        } else if (Hand.twoPair(Hand.cardRanks(handString)) != null) {
            return context.getString(R.string.two_pair);
        } else if (Hand.isJacksOrBetterPair(handString)) {
            return context.getString(R.string.jacks_or_better);
        } else {
            return context.getString(R.string.no_win);
        }
    }

}