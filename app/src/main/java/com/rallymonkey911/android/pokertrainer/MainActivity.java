package com.rallymonkey911.android.pokertrainer;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare all ImageView objects in the layout
    public ImageView cardImageView1, cardImageView2, cardImageView3, cardImageView4, cardImageView5,
            aceDiamondsImageView, deuceDiamondsImageView, threeDiamondsImageView, fourDiamondsImageView,
            fiveDiamondsImageView, sixDiamondsImageView, sevenDiamondsImageView, eightDiamondsImageView,
            nineDiamondsImageView, tenDiamondsImageView, jackDiamondsImageView, queenDiamondsImageView,
            kingDiamondsImageView, aceHeartsImageView, deuceHeartsImageView, threeHeartsImageView,
            fourHeartsImageView, fiveHeartsImageView, sixHeartsImageView, sevenHeartsImageView,
            eightHeartsImageView, nineHeartsImageView, tenHeartsImageView, jackHeartsImageView,
            queenHeartsImageView, kingHeartsImageView, aceClubsImageView, deuceClubsImageView,
            threeClubsImageView, fourClubsImageView, fiveClubsImageView, sixClubsImageView,
            sevenClubsImageView, eightClubsImageView, nineClubsImageView, tenClubsImageView,
            jackClubsImageView, queenClubsImageView, kingClubsImageView, aceSpadesImageView,
            deuceSpadesImageView, threeSpadesImageView, fourSpadesImageView, fiveSpadesImageView,
            sixSpadesImageView, sevenSpadesImageView, eightSpadesImageView, nineSpadesImageView,
            tenSpadesImageView, jackSpadesImageView, queenSpadesImageView, kingSpadesImageView;

    ImageView[] diamondsImageViews, heartsImageViews, clubsImageViews, spadesImageViews;

    // Declare all TextView objects in the layout
    public TextView handText, directionsText, cardOneHoldText, cardTwoHoldText, cardThreeHoldText,
            cardFourHoldText, cardFiveHoldText;

    // Declare Button object in the layout
    public Button clearButton;

    // Declare List of Card objects that will later be used to represent the current hand.
    public List<Card> hand;

    // Declare array of TextViews which will later store references to the "Hold" TextView
    // indicators placed above each ImageView representing a card in the hand.
    TextView[] holdTextViewLabels = new TextView[5];

    // Declare boolean flag used in setting all hold TextViews to Visible automatically if the hand
    // contains four-of-a-kind or a full-house.
    boolean bypassMapLookUpAndHoldAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct deck of Card objects, using the {@link Deck} class
        Deck deck = new Deck(this);

        // Initialize empty list for the five card hand
        hand = new ArrayList<>();

        // Find reference to TextViews in the layout
        handText = (TextView) findViewById(R.id.hand_text);
        directionsText = (TextView) findViewById(R.id.directions_text);
        cardOneHoldText = (TextView) findViewById(R.id.card_one_hold);
        cardTwoHoldText = (TextView) findViewById(R.id.card_two_hold);
        cardThreeHoldText = (TextView) findViewById(R.id.card_three_hold);
        cardFourHoldText = (TextView) findViewById(R.id.card_four_hold);
        cardFiveHoldText = (TextView) findViewById(R.id.card_five_hold);
        holdTextViewLabels[0] = cardOneHoldText;
        holdTextViewLabels[1] = cardTwoHoldText;
        holdTextViewLabels[2] = cardThreeHoldText;
        holdTextViewLabels[3] = cardFourHoldText;
        holdTextViewLabels[4] = cardFiveHoldText;

        //Find reference to ImageView's in the layout
        cardImageView1 = (ImageView) findViewById(R.id.card_one);
        cardImageView2 = (ImageView) findViewById(R.id.card_two);
        cardImageView3 = (ImageView) findViewById(R.id.card_three);
        cardImageView4 = (ImageView) findViewById(R.id.card_four);
        cardImageView5 = (ImageView) findViewById(R.id.card_five);
        aceDiamondsImageView = (ImageView) findViewById(R.id.ace_diamonds);
        deuceDiamondsImageView = (ImageView) findViewById(R.id.deuce_diamonds);
        threeDiamondsImageView = (ImageView) findViewById(R.id.three_diamonds);
        fourDiamondsImageView = (ImageView) findViewById(R.id.four_diamonds);
        fiveDiamondsImageView = (ImageView) findViewById(R.id.five_diamonds);
        sixDiamondsImageView = (ImageView) findViewById(R.id.six_diamonds);
        sevenDiamondsImageView = (ImageView) findViewById(R.id.seven_diamonds);
        eightDiamondsImageView = (ImageView) findViewById(R.id.eight_diamonds);
        nineDiamondsImageView = (ImageView) findViewById(R.id.nine_diamonds);
        tenDiamondsImageView = (ImageView) findViewById(R.id.ten_diamonds);
        jackDiamondsImageView = (ImageView) findViewById(R.id.jack_diamonds);
        queenDiamondsImageView = (ImageView) findViewById(R.id.queen_diamonds);
        kingDiamondsImageView = (ImageView) findViewById(R.id.king_diamonds);
        aceHeartsImageView = (ImageView) findViewById(R.id.ace_hearts);
        deuceHeartsImageView = (ImageView) findViewById(R.id.deuce_hearts);
        threeHeartsImageView = (ImageView) findViewById(R.id.three_hearts);
        fourHeartsImageView = (ImageView) findViewById(R.id.four_hearts);
        fiveHeartsImageView = (ImageView) findViewById(R.id.five_hearts);
        sixHeartsImageView = (ImageView) findViewById(R.id.six_hearts);
        sevenHeartsImageView = (ImageView) findViewById(R.id.seven_hearts);
        eightHeartsImageView = (ImageView) findViewById(R.id.eight_hearts);
        nineHeartsImageView = (ImageView) findViewById(R.id.nine_hearts);
        tenHeartsImageView = (ImageView) findViewById(R.id.ten_hearts);
        jackHeartsImageView = (ImageView) findViewById(R.id.jack_hearts);
        queenHeartsImageView = (ImageView) findViewById(R.id.queen_hearts);
        kingHeartsImageView = (ImageView) findViewById(R.id.king_hearts);
        aceClubsImageView = (ImageView) findViewById(R.id.ace_clubs);
        deuceClubsImageView = (ImageView) findViewById(R.id.deuce_clubs);
        threeClubsImageView = (ImageView) findViewById(R.id.three_clubs);
        fourClubsImageView = (ImageView) findViewById(R.id.four_clubs);
        fiveClubsImageView = (ImageView) findViewById(R.id.five_clubs);
        sixClubsImageView = (ImageView) findViewById(R.id.six_clubs);
        sevenClubsImageView = (ImageView) findViewById(R.id.seven_clubs);
        eightClubsImageView = (ImageView) findViewById(R.id.eight_clubs);
        nineClubsImageView = (ImageView) findViewById(R.id.nine_clubs);
        tenClubsImageView = (ImageView) findViewById(R.id.ten_clubs);
        jackClubsImageView = (ImageView) findViewById(R.id.jack_clubs);
        queenClubsImageView = (ImageView) findViewById(R.id.queen_clubs);
        kingClubsImageView = (ImageView) findViewById(R.id.king_clubs);
        aceSpadesImageView = (ImageView) findViewById(R.id.ace_spades);
        deuceSpadesImageView = (ImageView) findViewById(R.id.deuce_spades);
        threeSpadesImageView = (ImageView) findViewById(R.id.three_spades);
        fourSpadesImageView = (ImageView) findViewById(R.id.four_spades);
        fiveSpadesImageView = (ImageView) findViewById(R.id.five_spades);
        sixSpadesImageView = (ImageView) findViewById(R.id.six_spades);
        sevenSpadesImageView = (ImageView) findViewById(R.id.seven_spades);
        eightSpadesImageView = (ImageView) findViewById(R.id.eight_spades);
        nineSpadesImageView = (ImageView) findViewById(R.id.nine_spades);
        tenSpadesImageView = (ImageView) findViewById(R.id.ten_spades);
        jackSpadesImageView = (ImageView) findViewById(R.id.jack_spades);
        queenSpadesImageView = (ImageView) findViewById(R.id.queen_spades);
        kingSpadesImageView = (ImageView) findViewById(R.id.king_spades);

        // Find reference to the Button in the layout
        clearButton = (Button) findViewById(R.id.clear_button);

        // Store references to all of the non-hand card ImageViews in arrays for convenient
        // processing in a loop below.
        diamondsImageViews = new ImageView[]{aceDiamondsImageView, deuceDiamondsImageView,
                threeDiamondsImageView, fourDiamondsImageView, fiveDiamondsImageView,
                sixDiamondsImageView, sevenDiamondsImageView, eightDiamondsImageView,
                nineDiamondsImageView, tenDiamondsImageView, jackDiamondsImageView,
                queenDiamondsImageView, kingDiamondsImageView};
        heartsImageViews = new ImageView[]{aceHeartsImageView,
                deuceHeartsImageView, threeHeartsImageView, fourHeartsImageView,
                fiveHeartsImageView, sixHeartsImageView, sevenHeartsImageView,
                eightHeartsImageView, nineHeartsImageView, tenHeartsImageView,
                jackHeartsImageView, queenHeartsImageView, kingHeartsImageView};
        clubsImageViews = new ImageView[]{aceClubsImageView, deuceClubsImageView, threeClubsImageView,
                fourClubsImageView, fiveClubsImageView, sixClubsImageView, sevenClubsImageView,
                eightClubsImageView, nineClubsImageView, tenClubsImageView, jackClubsImageView,
                queenClubsImageView, kingClubsImageView};
        spadesImageViews = new ImageView[]{aceSpadesImageView, deuceSpadesImageView,
                threeSpadesImageView, fourSpadesImageView, fiveSpadesImageView, sixSpadesImageView,
                sevenSpadesImageView, eightSpadesImageView, nineSpadesImageView, tenSpadesImageView,
                jackSpadesImageView, queenSpadesImageView, kingSpadesImageView};
        ImageView[][] allImageViews = new ImageView[4][13];
        System.arraycopy(diamondsImageViews, 0, allImageViews[0], 0, diamondsImageViews.length);
        System.arraycopy(heartsImageViews, 0, allImageViews[1], 0, heartsImageViews.length);
        System.arraycopy(clubsImageViews, 0, allImageViews[2], 0, clubsImageViews.length);
        System.arraycopy(spadesImageViews, 0, allImageViews[3], 0, spadesImageViews.length);

        // Set the corresponding image resource for each of the smaller non-hand card ImageViews
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                allImageViews[i][j].setImageResource(deck.getCard((i + 1), (j + 1)).
                        getmResourceIdSmall());
                allImageViews[i][j].setTag(deck.getCard((i + 1), (j + 1)));
            }
        }

        // Define the OnClickListener for the five ImageViews representing the current hand
        View.OnClickListener handClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView handCardImage = (ImageView) v;
                if (!isBlank(handCardImage)) {
                    Card card = (Card) handCardImage.getTag();
                    removeCardFromHand(card, handCardImage);
                }
            }
        };

        // Set the five hand ImageViews with a blank card image resource, and also set their
        // OnClickListeners
        for (ImageView blankImageView : new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5}) {
            setBlank(blankImageView);
            blankImageView.setOnClickListener(handClickListener);
        }

        // Set the OnClickListeners for each of the smaller non-hand cards
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                final Card currentCard = deck.getCard((i + 1), (j + 1));
                final ImageView currentImageView = allImageViews[i][j];
                currentImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!hand.contains(currentCard)) {
                            if (hand.size() < 5){
                                currentImageView.setAlpha(75);
                            }
                            addCardToHand(currentCard);

                        } else {
                            Toast.makeText(getApplication(), R.string.card_already_selected,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        // Set the OnClickListener for the clear Button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHand();
            }
        });
    }

    public boolean addCardToHand(Card cardToAdd) {
        if (hand.size() <= 4) {
            hand.add(cardToAdd);
            for (ImageView cardImageView : new ImageView[]{cardImageView1, cardImageView2,
                    cardImageView3, cardImageView4, cardImageView5}) {
                if (isBlank(cardImageView)) {
                    cardImageView.setImageResource(cardToAdd.getmResourceIdSmall());
                    cardImageView.setTag(cardToAdd);
                    setHandText();
                    return true;
                }
            }
        } else {
            Toast.makeText(getApplication(), R.string.hand_full,
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void removeCardFromHand(Card cardToRemove, ImageView cardToRemoveImageView) {

        for (ImageView smallImage : spadesImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(255);
            }
        }

        for (ImageView smallImage : heartsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(255);
            }
        }

        for (ImageView smallImage : diamondsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(255);
            }
        }

        for (ImageView smallImage : clubsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(255);
            }
        }

        hand.remove(cardToRemove);
        directionsText.setText("");

        for (TextView holdTextViewLabel : holdTextViewLabels) {
            holdTextViewLabel.setVisibility(View.INVISIBLE);
        }

        ImageView[] cardImageViews = new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5};

        for (ImageView cardImageView : cardImageViews) {
            setBlank(cardImageView);
        }

        for (int i = 0; i < hand.size(); i++) {
            cardImageViews[i].setImageResource(hand.get(i).getmResourceIdSmall());
            cardImageViews[i].setTag(hand.get(i));
        }
        setHandText();

    }

    public void setHandText() {
        int count = hand.size();
        switch (hand.size()) {
            case 0:
                handText.setText(R.string.select_cards);
                break;
            case 1:
                handText.setText(getString(R.string.card_selected_singular, count));
                break;
            case 5:
                detectWinningHand();
                break;
            default:
                handText.setText(getString(R.string.cards_selected_plural, count));
                break;
        }
    }

    public void clearHand() {
        for (ImageView cardImageView : new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5}) {
            setBlank(cardImageView);
        }
        hand.clear();
        for (TextView holdTextViewLabel : holdTextViewLabels) {
            holdTextViewLabel.setVisibility(View.INVISIBLE);
        }

        setAllImagesToNormalAlpha();
        setHandText();
        directionsText.setText("");
    }

    public boolean isBlank(ImageView image) {
        return image.getDrawable().getConstantState() == ContextCompat.getDrawable
                (MainActivity.this, R.drawable.blank_small_version).getConstantState();
    }

    public void setBlank(ImageView image) {
        image.setImageResource(R.drawable.blank_small_version);
    }

    public void setAllImagesToNormalAlpha() {
        for (ImageView smallImage : spadesImageViews) {
            smallImage.setAlpha(255);
        }

        for (ImageView smallImage : heartsImageViews) {
            smallImage.setAlpha(255);
        }

        for (ImageView smallImage : diamondsImageViews) {
            smallImage.setAlpha(255);
        }

        for (ImageView smallImage : clubsImageViews) {
            smallImage.setAlpha(255);
        }
    }

    public void detectWinningHand() {
        List<String> handString = Hand.handAsStringList(hand);
        bypassMapLookUpAndHoldAll = false;

        if (Hand.straightFlush(handString)) {
            handText.setText(R.string.straight_flush);
        } else if (Hand.kind(4, Hand.cardRanks(handString)) != null) {
            handText.setText(R.string.four_kind);
            bypassMapLookUpAndHoldAll = true;
        } else if (Hand.fullHouse(handString)) {
            handText.setText(R.string.full_house);
            bypassMapLookUpAndHoldAll = true;
        } else if (Hand.flush(handString)) {
            handText.setText(R.string.flush);
        } else if (Hand.straight(Hand.cardRanks(handString))) {
            handText.setText(R.string.straight);
        } else if (Hand.kind(3, Hand.cardRanks(handString)) != null) {
            handText.setText(R.string.three_kind);
        } else if (Hand.twoPair(Hand.cardRanks(handString)) != null) {
            handText.setText(R.string.two_pair);
        } else {
            handText.setText("No win");
        }

        directionsText.setText("Hold cards as shown below");
        lookUpRecommendedCardsToHold();
    }

    public void lookUpRecommendedCardsToHold() {
        // Use a String representation of the current five card hand to look up the correct
        // serialized HashMap object.  The String representation of the hand should match as one of
        // the keys to this HashMap, and will pair with corresponding value, which is a String
        // representing the optimal choices of cards to hold.
        if (bypassMapLookUpAndHoldAll) {
            for (TextView holdTextViewLabel : holdTextViewLabels) {
                holdTextViewLabel.setVisibility((View.VISIBLE));
            }
        } else {
            String recommendedCardsToHold = MapLookup.lookUpInMap(this, Hand.sortedTomHandString(hand));
            int recommendedCardsToHoldLength = recommendedCardsToHold.length();

            // Strings representing each separate card to be held.  One or more may remain as null
            // objects depending on the actual recommendation of cards to be held.
            String cardToHoldA, cardToHoldB, cardToHoldC, cardToHoldD, cardToHoldE;
            cardToHoldA = cardToHoldB = cardToHoldC = cardToHoldD = cardToHoldE = null;
            String[] cardsToHold = {cardToHoldA, cardToHoldB, cardToHoldC, cardToHoldD, cardToHoldE};

            if (recommendedCardsToHoldLength == 10) {
                cardsToHold[4] = recommendedCardsToHold.substring(8, 10);
            }
            if (recommendedCardsToHoldLength >= 8) {
                cardsToHold[3] = recommendedCardsToHold.substring(6, 8);
            }
            if (recommendedCardsToHoldLength >= 6) {
                cardsToHold[2] = recommendedCardsToHold.substring(4, 6);
            }
            if (recommendedCardsToHoldLength >= 4) {
                cardsToHold[1] = recommendedCardsToHold.substring(2, 4);
            }
            if (recommendedCardsToHoldLength >= 2 && recommendedCardsToHoldLength != 3) {
                cardsToHold[0] = recommendedCardsToHold.substring(0, 2);
            }

            // If the length of the recommended cards to hold is 3, the response was "all", meaning to
            // discard all cards (i.e., do not hold any of the cards).
            if (recommendedCardsToHoldLength == 3) {
                directionsText.setText("Discard all cards");
            }

            for (String cardToHold : cardsToHold) {
                if (cardToHold != null) {
                    for (int i = 0; i < 5; i++) {
                        String compare = hand.get(i).toStringWithLetters();
                        if (cardToHold.equals(compare)) {
                            holdTextViewLabels[i].setVisibility(View.VISIBLE);
                            break;
                        }
                    }
                }
            }
        }
    }
}