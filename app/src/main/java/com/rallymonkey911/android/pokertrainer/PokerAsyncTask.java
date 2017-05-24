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
    private String mGameSelected;

    private static final int DISCARD_ALL_CODE = 3;
    static final int NUMBER_OF_CARDS_IN_FULL_HAND = 5;
    static final int CODE_LENGTH_ONE_CARD = 2;

    PokerAsyncTask(Context context, TextView directionsText, List<Card> hand,
                          TextView[] holdTextViewLabels, String gameSelected) {
        mContext = context;
        mDirectionsText = directionsText;
        mHand = hand;
        mHoldTextViewLabels = holdTextViewLabels;
        mGameSelected = gameSelected;
    }

    @Override
    protected void onPreExecute() {
        mDirectionsText.setText(R.string.please_wait);
    }

    @Override
    protected String doInBackground(String... hand) {
        return MapLookup.lookUpInMap(mContext, hand[0], mGameSelected);
    }

    @Override
    protected void onPostExecute(String result) {
        // Strings representing each separate card to be held.  One or more may remain as null
        // objects depending on the actual recommendation of cards to be held.
        String[] cardsToHold = new String[NUMBER_OF_CARDS_IN_FULL_HAND];
        for (int i = 0; i < NUMBER_OF_CARDS_IN_FULL_HAND; i++) { cardsToHold[i] = null; }

        if (result.length() == DISCARD_ALL_CODE){
            mDirectionsText.setText(R.string.discard_all);
        } else {
            mDirectionsText.setText(R.string.hold_cards_below);
            for (int i = 0; i < result.length() / CODE_LENGTH_ONE_CARD; i++) {
                cardsToHold[i] = result.substring(i*CODE_LENGTH_ONE_CARD,
                        (i*CODE_LENGTH_ONE_CARD) + CODE_LENGTH_ONE_CARD);
            }
        }

        for (TextView holdLabel: mHoldTextViewLabels) {
            holdLabel.setVisibility(View.INVISIBLE);
        }

        for (String cardToHold : cardsToHold) {
            if (cardToHold != null) {
                for (int i = 0; i < NUMBER_OF_CARDS_IN_FULL_HAND; i++) {
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
