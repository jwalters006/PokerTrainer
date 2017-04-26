package com.rallymonkey911.android.pokertrainer;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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

    public TextView handText, directionsText, cardOneHoldText, cardTwoHoldText, cardThreeHoldText,
            cardFourHoldText, cardFiveHoldText;

    TextView[] holdTextSlots = new TextView[5];
    public Button clearButton;
    public List<Card> hand;
    boolean holdAll;

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
        holdTextSlots[0] = cardOneHoldText;
        holdTextSlots[1] = cardTwoHoldText;
        holdTextSlots[2] = cardThreeHoldText;
        holdTextSlots[3] = cardFourHoldText;
        holdTextSlots[4] = cardFiveHoldText;

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

        clearButton = (Button) findViewById(R.id.clear_button);

        ImageView[] diamondImageViews = {aceDiamondsImageView, deuceDiamondsImageView,
                threeDiamondsImageView, fourDiamondsImageView, fiveDiamondsImageView,
                sixDiamondsImageView, sevenDiamondsImageView, eightDiamondsImageView,
                nineDiamondsImageView, tenDiamondsImageView, jackDiamondsImageView,
                queenDiamondsImageView, kingDiamondsImageView};
        ImageView[] heartsImageViews = {aceHeartsImageView,
                deuceHeartsImageView, threeHeartsImageView, fourHeartsImageView,
                fiveHeartsImageView, sixHeartsImageView, sevenHeartsImageView,
                eightHeartsImageView, nineHeartsImageView, tenHeartsImageView,
                jackHeartsImageView, queenHeartsImageView, kingHeartsImageView};
        ImageView[] clubsImageViews = {aceClubsImageView, deuceClubsImageView, threeClubsImageView,
                fourClubsImageView, fiveClubsImageView, sixClubsImageView, sevenClubsImageView,
                eightClubsImageView, nineClubsImageView, tenClubsImageView, jackClubsImageView,
                queenClubsImageView, kingClubsImageView};
        ImageView[] spadesImageViews = {aceSpadesImageView, deuceSpadesImageView,
                threeSpadesImageView, fourSpadesImageView, fiveSpadesImageView, sixSpadesImageView,
                sevenSpadesImageView, eightSpadesImageView, nineSpadesImageView, tenSpadesImageView,
                jackSpadesImageView, queenSpadesImageView, kingSpadesImageView};

        ImageView[][] allImageViews = new ImageView[4][13];
        System.arraycopy(diamondImageViews, 0, allImageViews[0], 0, diamondImageViews.length);
        System.arraycopy(heartsImageViews, 0, allImageViews[1], 0, heartsImageViews.length);
        System.arraycopy(clubsImageViews, 0, allImageViews[2], 0, clubsImageViews.length);
        System.arraycopy(spadesImageViews, 0, allImageViews[3], 0, spadesImageViews.length);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                allImageViews[i][j].setImageResource(deck.getCard((i + 1), (j + 1)).
                        getmResourceIdSmall());
            }
        }


        // Define the OnClickListener for the five ImageViews representing the current hand
        View.OnClickListener handClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView handCardImage = (ImageView) v;
                if (!isBlank(handCardImage)) {
                    Card card = (Card) handCardImage.getTag();
                    removeCardFromHand(card);
                }
            }
        };

        // Set the five hand ImageView's as blank cards, and set their OnClickListeners
        for (ImageView blankImageView : new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5}) {
            setBlank(blankImageView);
            //blankImageView.setOnClickListener(handClickListener);
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                final Card currentCard = deck.getCard((i + 1), (j + 1));
                ImageView currentImageView = allImageViews[i][j];
                currentImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!hand.contains(currentCard)) {
                            addCardToHand(currentCard);
                        } else {
                            Toast.makeText(getApplication(), R.string.card_already_selected,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

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

    public void removeCardFromHand(Card cardToRemove) {
        for (TextView cardHoldSlot : holdTextSlots) {
            cardHoldSlot.setVisibility(View.INVISIBLE);
        }
        directionsText.setText("");
        for (ImageView cardImageView : new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5}) {
            if (isImageViewMatch(cardToRemove, cardImageView)) {
                setBlank(cardImageView);
                setHandText();
                hand.remove(cardToRemove);
                return;
            }
        }
    }

    public void setHandText() {
        int count = 0;
        for (ImageView cardImageView : new ImageView[]{cardImageView1, cardImageView2,
                cardImageView3, cardImageView4, cardImageView5})
            if (!isBlank(cardImageView)) {
                count++;
            }

        switch (count) {
            case 0:
                handText.setText(R.string.select_cards);
                break;
            case 1:
                handText.setText(getString(R.string.card_selected_singular, count));
                break;
            case 5:
                runCalculation();
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
        for (TextView cardHoldSlot : holdTextSlots) {
            cardHoldSlot.setVisibility(View.INVISIBLE);
        }
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

    public boolean isImageViewMatch(Card card, ImageView imageView) {
        int cardResId = card.getmResourceIdSmall();
        int imageViewResId = ((Card) imageView.getTag()).getmResourceIdSmall();
        return cardResId == imageViewResId;
    }

    public void runCalculation() {
        List<String> handString = Hand.handAsStringList(hand);
        holdAll = false;

        if (Hand.straightFlush(handString)) {
            handText.setText(R.string.straight_flush);
        } else if (Hand.kind(4, Hand.cardRanks(handString)) != null) {
            handText.setText(R.string.four_kind);
        } else if (Hand.fullHouse(handString)) {
            handText.setText(R.string.full_house);
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
            directionsText.setText("Hold cards as shown below");
        }
        directionsText.setText("Hold cards as shown below");

        String resultingDecision = MapLookup.lookUpInMap(this, Hand.sortedTomHandString(hand));

        String cardA, cardB, cardC, cardD, cardE;
        cardA = cardB = cardC = cardD = cardE = null;

        switch (resultingDecision.length()) {
            case 3:
                directionsText.setText("Discard all cards");
                break;
            case 2:
                cardA = resultingDecision.substring(0, 2);
                break;
            case 4:
                cardA = resultingDecision.substring(0, 2);
                cardB = resultingDecision.substring(2, 4);
                break;
            case 6:
                cardA = resultingDecision.substring(0, 2);
                cardB = resultingDecision.substring(2, 4);
                cardC = resultingDecision.substring(4, 6);
                break;
            case 8:
                cardA = resultingDecision.substring(0, 2);
                cardB = resultingDecision.substring(2, 4);
                cardC = resultingDecision.substring(4, 6);
                cardD = resultingDecision.substring(6, 8);
                break;
            case 10:
                cardA = resultingDecision.substring(0, 2);
                cardB = resultingDecision.substring(2, 4);
                cardC = resultingDecision.substring(4, 6);
                cardD = resultingDecision.substring(6, 8);
                cardE = resultingDecision.substring(8, 10);
                break;
            default:
                break;
        }

        String[] resultCards = {cardA, cardB, cardC, cardD, cardE};
        for (String result : resultCards) {
            if (result != null && !holdAll) {
                for (int i = 0; i < 5; i++) {
                    if (Hand.kind(4, Hand.cardRanks(handString)) != null ||
                            Hand.fullHouse(handString)) {
                        for (TextView holdTextSlot : holdTextSlots) {
                            holdTextSlot.setVisibility((View.VISIBLE));
                        }
                        holdAll = true;
                        break;
                    }
                    String compare = hand.get(i).toStringWithLetters();
                    if (result.equals(compare)) {
                        holdTextSlots[i].setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        }
    }
}