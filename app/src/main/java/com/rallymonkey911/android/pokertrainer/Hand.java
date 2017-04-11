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
        return (ranks.get(0) - ranks.get(4) == 4 && sortedRanks.size() == 5);
    }

    static Integer kind(int n, List<Integer> ranks){
        for (int rank : ranks){
            if (Collections.frequency(ranks, rank) == n){
                return rank;
            }
        }
        return null;
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
}