package com.rallymonkey911.android.pokertrainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jeff on 4/10/2017.
 */

class Hand {

    static List<String> handAsStringList(List<Card> hand){
        List<String> handAsStringList = new ArrayList<>();
        for (Card card : hand){
            handAsStringList.add(card.toString());
        }
        return handAsStringList;
    }

    static String handAsString(List<Card> hand){
        StringBuilder handAsString = new StringBuilder();
        for (Card card : hand){
            handAsString.append(card.toString());
        }
        return handAsString.toString();
    }

    static List<Integer> cardRanks(List<String> hand){
        List<Integer> ranks = new ArrayList<>();
        for (String card : hand){
            String rank = card.substring(0, card.length()-1);
            ranks.add(Integer.parseInt(rank));
        }

        Collections.sort(ranks, Collections.reverseOrder());
        if (ranks.equals(new ArrayList<>(Arrays.asList(
                new Integer[]{14, 5, 4, 3, 2})))){
            return new ArrayList<>(Arrays.asList(new Integer[]{5, 4, 3, 2, 1}));
        } else { return ranks; }
    }

    static boolean flush(List<String> hand){
        Collection<String> suits = new HashSet<>();
        for (String card : hand){
            suits.add(card.substring(card.length()-1));
        }
        return suits.size() == 1;
    }

    static boolean straight(List<Integer> ranks){
        Collection<Integer> sortedRanks = new HashSet<>(ranks);
        return (ranks.get(0) - ranks.get(4) == 4 && sortedRanks.size() == 5) ||
                ranks.contains(Card.ACE) &&
                        ranks.contains(Card.TEN) &&
                        ranks.contains(Card.JACK) &&
                        ranks.contains(Card.QUEEN) &&
                        ranks.contains(Card.KING);
    }

    static boolean straightFlush(List<String> hand) {
        return Hand.flush(hand) && Hand.straight(Hand.cardRanks(hand));
    }

    static boolean royalFlush(List<String> hand) {
        List<Integer> handRanks = Hand.cardRanks(hand);
        return Hand.flush(hand) && handRanks.contains(Card.ACE) &&
                handRanks.contains(Card.TEN) &&
                handRanks.contains(Card.JACK) &&
                handRanks.contains(Card.QUEEN) &&
                handRanks.contains(Card.KING);
    }

    static Integer kind(int n, List<Integer> ranks){
        for (int rank : ranks){
            if (Collections.frequency(ranks, rank) == n){
                return rank;
            }
        }
        return null;
    }

    static boolean fullHouse(List<String> hand) {
        return Hand.kind(3, Hand.cardRanks(hand)) != null &&
                Hand.kind(2, Hand.cardRanks(hand)) != null;
    }

    static Integer[] twoPair(List<Integer> ranks){
        List<Integer> sortedRanks = new ArrayList<>(ranks);
        Collections.sort(sortedRanks);
        Integer[] pair = new Integer[2];
        pair[0] = kind(2, ranks);
        pair[1] = kind(2, sortedRanks);
        if (pair[0] != null){
            if (!pair[1].equals(pair[0])){
                return pair;
            }
            return null;
        }
        return null;
    }

    public static String sortedTomHandString(List<Card>hand){
        StringBuilder handTomStringSorted = new StringBuilder();
        List<Card> handCopy = new ArrayList<>(hand);
        Collections.sort(handCopy);

        for (Card card : handCopy) {
            handTomStringSorted.append(card.toStringWithLetters());
        }
        return handTomStringSorted.toString();
    }
}