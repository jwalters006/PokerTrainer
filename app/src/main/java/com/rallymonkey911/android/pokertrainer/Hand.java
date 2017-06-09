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

    public static final int JOB_ROYAL_FLUSH_PAYOFF = 976;
    public static final int JOB_STRAIGHT_FLUSH_PAYOFF = 50;
    public static final int JOB_FOUR_OF_A_KIND_PAYOFF = 25;
    public static final int JOB_FULL_HOUSE_PAYOFF = 9;
    public static final int JOB_FLUSH_PAYOFF = 6;
    public static final int JOB_STRAIGHT_PAYOFF = 4;
    public static final int JOB_THREE_OF_A_KIND_PAYOFF = 3;
    public static final int JOB_TWO_PAIR_PAYOFF = 2;
    public static final int JOB_JACKS_OR_BETTER_PAYOFF = 1;

    public static final int DW_NATURAL_ROYAL_FLUSH_PAYOFF = 800;
    public static final int DW_FOUR_DEUCES_PAYOFF = 200;
    public static final int DW_WILD_ROYAL_FLUSH_PAYOFF = 25;
    public static final int DW_FIVE_OF_A_KIND_PAYOFF = 15;
    public static final int DW_STRAIGHT_FLUSH_PAYOFF = 9;
    public static final int DW_FOUR_OF_A_KIND_PAYOFF = 5;
    public static final int DW_FULL_HOUSE_PAYOFF = 3;
    public static final int DW_FLUSH_PAYOFF = 2;
    public static final int DW_STRAIGHT_PAYOFF = 2;
    public static final int DW_THREE_OF_A_KIND_PAYOFF = 1;



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
        return isFlush(hand) && isStraight(cardRanks(hand));
    }

    static boolean isRoyalFlush(List<String> hand) {
        return isFlush(hand) && isStraight(cardRanks(hand)) &&
                cardRanks(hand).contains(Card.HIGH_ACE);
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
        return kind(3, cardRanks(hand)) != null &&
                kind(2, cardRanks(hand)) != null;
    }

    static Integer[] twoPair(List<Integer> ranks) {
        List<Integer> sortedRanks = new ArrayList<>(ranks);
        Collections.sort(sortedRanks);
        Integer[] pair = new Integer[2];
        pair[0] = kind(2, ranks);
        pair[1] = kind(2, sortedRanks);
        if (pair[0] != null && !pair[0].equals(pair[1])) {
            return pair;
        }
        return null;
    }

    static boolean isJacksOrBetterPair(List<String> hand) {
        if (kind(2, cardRanks(hand)) != null) {
            if (kind(2, cardRanks(hand)) >= Card.JACK ||
                    (kind(2, cardRanks(hand))) == Card.ACE) {
                return true;
            }
        }
        return false;
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

    private static boolean hasAllCardsTenOrHigher(List<String> hand) {
        List<Integer> handRanks = cardRanks(hand);
        for (int card : handRanks) {
            if (card < Card.TEN && card != Card.ACE) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOneAwayFromStraight(List<String> hand) {
        List<Integer> handRanks = cardRanks(hand);
        Collection<Integer> rankSet = new HashSet<>(handRanks);
        if (rankSet.size() != 4) {
            return false;
        }
        if (handRanks.get(0) - handRanks.get(3) <= 4) {
            return true;
        }
        if (handRanks.contains(Card.ACE)) {
            Collections.replaceAll(handRanks, Card.ACE, Card.HIGH_ACE);
            Collections.sort(handRanks, Collections.<Integer>reverseOrder());
            if (handRanks.get(0) - handRanks.get(3) <= 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTwoAwayFromStraight(List<String> hand) {
        List<Integer> handRanks = cardRanks(hand);
        Collection<Integer> rankSet = new HashSet<>(handRanks);
        if (rankSet.size() != 3) {
            return false;
        }
        if (handRanks.get(0) - handRanks.get(2) <= 4) {
            return true;
        }
        if (handRanks.contains(Card.ACE)) {
            Collections.replaceAll(handRanks, Card.ACE, Card.HIGH_ACE);
            Collections.sort(handRanks, Collections.<Integer>reverseOrder());
            if (handRanks.get(0) - handRanks.get(2) <= 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isThreeAwayFromStraight(List<String> hand) {
        List<Integer> handRanks = cardRanks(hand);
        Collection<Integer> rankSet = new HashSet<>(handRanks);
        if (rankSet.size() != 2) {
            return false;
        }
        if (handRanks.get(0) - handRanks.get(1) <= 4) {
            return true;
        }
        if (handRanks.contains(Card.ACE)) {
            Collections.replaceAll(handRanks, Card.ACE, Card.HIGH_ACE);
            Collections.sort(handRanks, Collections.<Integer>reverseOrder());
            if (handRanks.get(0) - handRanks.get(1) <= 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOneAwayFromStraightFlush(List<String> hand) {
        return isOneAwayFromStraight(hand) &&
                isFlush(hand);
    }

    private static boolean isTwoAwayFromStraightFlush(List<String> hand) {
        return isTwoAwayFromStraight(hand) &&
                isFlush(hand);
    }

    private static boolean isThreeAwayFromStraightFlush(List<String> hand) {
        return isThreeAwayFromStraight(hand) &&
                isFlush(hand);
    }

    private static boolean isOneAwayFromRoyalFlush(List<String> hand) {
        return isOneAwayFromStraightFlush(hand) &&
                hasAllCardsTenOrHigher(hand);
    }

    private static boolean isTwoAwayFromRoyalFlush(List<String> hand) {
        return isTwoAwayFromStraightFlush(hand) &&
                hasAllCardsTenOrHigher(hand);
    }

    private static boolean isThreeAwayFromRoyalFlush(List<String> hand) {
        return isThreeAwayFromStraightFlush(hand) &&
                hasAllCardsTenOrHigher(hand);
    }

    private static boolean isOneAwayFromThreeOfAKind(List<String> hand) {
        List<Integer> handRanks = cardRanks(hand);
        return kind(2, handRanks) != null && kind(2, handRanks) != Card.DEUCE;
    }

    static String getWinningHandString(Context context, String gameSelected, List<Card> hand) {
        if (gameSelected.equals(context.getString(R.string.jacks_or_better))) {
            return getWinningJacksOrBetterString(context, hand);
        } else if (gameSelected.equals(context.getString(R.string.deuces_wild))) {
            return getWinningDeucesWildString(context, hand);
        }
        return "";
    }

    private static String getWinningJacksOrBetterString(Context context, List<Card> hand) {
        List<String> handString = handAsStringList(hand);
        if (isRoyalFlush(handString)) {
            return context.getString(R.string.royal_flush);
        } else if (isStraightFlush(handString)) {
            return context.getString(R.string.straight_flush);
        } else if (kind(4, cardRanks(handString)) != null) {
            return context.getString(R.string.four_kind);
        } else if (isFullHouse(handString)) {
            return context.getString(R.string.full_house);
        } else if (isFlush(handString)) {
            return context.getString(R.string.flush);
        } else if (isStraight(cardRanks(handString))) {
            return context.getString(R.string.straight);
        } else if (kind(3, cardRanks(handString)) != null) {
            return context.getString(R.string.three_kind);
        } else if (twoPair(cardRanks(handString)) != null) {
            return context.getString(R.string.two_pair);
        } else if (isJacksOrBetterPair(handString)) {
            return context.getString(R.string.jacks_or_better);
        } else {
            return context.getString(R.string.no_win);
        }
    }

    private static String getWinningDeucesWildString(Context context, List<Card> hand) {
        List<String> handStringInitial = handAsStringList(hand);

        List<String> handString = new ArrayList<>();


        int numberOfDeuces = Collections.frequency(cardRanks(handStringInitial), Card.DEUCE);
        if (numberOfDeuces > 0) {
            // Trim the hand of any deuces here
            for (String cardAsString : handStringInitial) {
                if (!cardAsString.substring(0, 1).equals("2")) {
                    handString.add(cardAsString);
                }
            }
        } else {
            handString.addAll(handStringInitial);
        }

        switch (numberOfDeuces) {
            case 0:
                if (isRoyalFlush(handString)) {
                    return context.getString(R.string.natural_royal_flush);
                } else if (isStraightFlush(handString)) {
                    return context.getString(R.string.straight_flush);
                } else if (kind(4, cardRanks(handString)) != null) {
                    return context.getString(R.string.four_kind);
                } else if (isFullHouse(handString)) {
                    return context.getString(R.string.full_house);
                } else if (isFlush(handString)) {
                    return context.getString(R.string.flush);
                } else if (isStraight(cardRanks(handString))) {
                    return context.getString(R.string.straight);
                } else if (kind(3, cardRanks(handString)) != null) {
                    return context.getString(R.string.three_kind);
                } else {
                    return context.getString(R.string.no_win);
                }

            case 1:
                if (isOneAwayFromRoyalFlush(handString)) {
                    return context.getString(R.string.royal_flush);
                } else if (kind(4, cardRanks(handString)) != null) {
                    return context.getString(R.string.five_kind);
                } else if (isOneAwayFromStraightFlush(handString)) {
                    return context.getString(R.string.straight_flush);
                } else if (kind(3, cardRanks(handString)) != null) {
                    return context.getString(R.string.four_kind);
                } else if (twoPair(cardRanks(handString)) != null) {
                    return context.getString(R.string.full_house);
                } else if (isFlush(handString)) {
                    return context.getString(R.string.flush);
                } else if (isOneAwayFromStraight(handString)) {
                    return context.getString(R.string.straight);
                } else if (isOneAwayFromThreeOfAKind(handString)) {
                    return context.getString(R.string.three_kind);
                } else {
                    return context.getString(R.string.no_win);
                }

            case 2:
                if (isTwoAwayFromRoyalFlush(handString)) {
                    return context.getString(R.string.royal_flush);
                } else if (kind(3, cardRanks(handString)) != null) {
                    return context.getString(R.string.five_kind);
                } else if (isTwoAwayFromStraightFlush(handString)) {
                    return context.getString(R.string.straight_flush);
                } else if (isOneAwayFromThreeOfAKind(handString)) {
                    return context.getString(R.string.four_kind);
                } else if (isFlush(handString)) {
                    return context.getString(R.string.flush);
                } else if (isTwoAwayFromStraight(handString)) {
                    return context.getString(R.string.straight);
                } else {
                    return context.getString(R.string.three_kind);
                }

            case 3:
                if (isThreeAwayFromRoyalFlush(handString)) {
                    return context.getString(R.string.royal_flush);
                } else if (isOneAwayFromThreeOfAKind(handString)) {
                    return context.getString(R.string.five_kind);
                } else if (isThreeAwayFromStraightFlush(handString)) {
                    return context.getString(R.string.straight_flush);
                } else {
                    return context.getString(R.string.four_kind);
                }

            default:
                return context.getString(R.string.four_deuces);
        }
    }
}