package com.rallymonkey911.android.pokertrainer;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jeff on 4/28/2017.
 */

public class PokerAsyncTask extends AsyncTask<String, Void, String> {

    private Context mContext;
    private TextView mDirectionsText;
    private List<Card> mHand;
    private TextView[] mHoldTextViewLabels;

    public PokerAsyncTask(Context context, TextView directionsText, List<Card> hand,
                          TextView[] holdTextViewLabels) {
        mContext = context;
        mDirectionsText = directionsText;
        mHand = hand;
        mHoldTextViewLabels = holdTextViewLabels;

    }

    @Override
    protected void onPreExecute() {
        mDirectionsText.setText(R.string.please_wait);
    }

    @Override
    protected String doInBackground(String... hand) {
        return MapLookup.lookUpInMap(mContext, hand[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        int recommendedCardsToHoldLength = result.length();

        if (recommendedCardsToHoldLength != 3) {
            mDirectionsText.setText(R.string.hold_cards_below);
        }

        // Strings representing each separate card to be held.  One or more may remain as null
        // objects depending on the actual recommendation of cards to be held.
        String cardToHoldA, cardToHoldB, cardToHoldC, cardToHoldD, cardToHoldE;
        cardToHoldA = cardToHoldB = cardToHoldC = cardToHoldD = cardToHoldE = null;
        String[] cardsToHold = {cardToHoldA, cardToHoldB, cardToHoldC, cardToHoldD, cardToHoldE};

        if (recommendedCardsToHoldLength == 10) {
            cardsToHold[4] = result.substring(8, 10);
        }
        if (recommendedCardsToHoldLength >= 8) {
            cardsToHold[3] = result.substring(6, 8);
        }
        if (recommendedCardsToHoldLength >= 6) {
            cardsToHold[2] = result.substring(4, 6);
        }
        if (recommendedCardsToHoldLength >= 4) {
            cardsToHold[1] = result.substring(2, 4);
        }
        if (recommendedCardsToHoldLength >= 2 && recommendedCardsToHoldLength != 3) {
            cardsToHold[0] = result.substring(0, 2);
        }

        // If the length of the recommended cards to hold is 3, the response was "all", meaning to
        // discard all cards (i.e., do not hold any of the cards).
        if (recommendedCardsToHoldLength == 3) {
            mDirectionsText.setText(R.string.discard_all);
        }

        for (String cardToHold : cardsToHold) {
            if (cardToHold != null) {
                for (int i = 0; i < 5; i++) {
                    String compare = mHand.get(i).toStringWithLetters();
                    if (cardToHold.equals(compare)) {
                        mHoldTextViewLabels[i].setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        }
    }
}
