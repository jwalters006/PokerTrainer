package com.rallymonkey911.android.pokertrainer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class LookupActivity extends AppCompatActivity {

    Context context;
    Deck deck;
    ArrayList<Card> deckListMaster;

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
            tenSpadesImageView, jackSpadesImageView, queenSpadesImageView, kingSpadesImageView,
            diamondsImageView, heartsImageView, clubsImageView, spadesImageView;

    ImageView[] diamondsImageViews, heartsImageViews, clubsImageViews, spadesImageViews;
    ImageView[][] allImageViews = new ImageView[Deck.NUM_SUITS][Deck.NUM_RANKS];

    // Declare all TextView objects in the layout
    public TextView handText, directionsText, cardOneHoldText, cardTwoHoldText, cardThreeHoldText,
            cardFourHoldText, cardFiveHoldText;

    // Declare Button object in the layout
    public Button clearButton;

    // Declare List of Card objects that will later be used to represent the current hand.
    public ArrayList<Card> hand;

    // Declare array of TextViews which will later store references to the "Hold" TextView
    // indicators placed above each ImageView representing a card in the hand.
    TextView[] holdTextViewLabels = new TextView[5];

    // Declare RadioGroup object that will be used to hold RadioButton objects
    private RadioGroup gameChoiceRadioGroup;

    // Declare RadioButton objects that will be used to select the appropriate result table
    private RadioButton radioButtonJacks, radioButtonDeuces;

    // Declare variable to hold reference to selected game
    private String gameSelected;

    public static final String STATE_PLAYER_HAND = "playerHand";
    public static final String STATE_GAME_SELECTED = "gameSelected";
    public static final int FULLY_VISIBLE = 255;
    public static final int SEMI_TRANSPARENT = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);

        context = this;

        deck = new Deck(this);
        deckListMaster = createDeckListOfCards(deck);

        // Initialize empty list for the five card hand
        hand = new ArrayList<>();

        // Find reference to TextViews in the layout
        handText = (TextView) findViewById(R.id.lookup_hand_text);
        directionsText = (TextView) findViewById(R.id.lookup_directions_text);
        cardOneHoldText = (TextView) findViewById(R.id.lookup_card_one_hold);
        cardTwoHoldText = (TextView) findViewById(R.id.lookup_card_two_hold);
        cardThreeHoldText = (TextView) findViewById(R.id.lookup_card_three_hold);
        cardFourHoldText = (TextView) findViewById(R.id.lookup_card_four_hold);
        cardFiveHoldText = (TextView) findViewById(R.id.lookup_card_five_hold);
        holdTextViewLabels[0] = cardOneHoldText;
        holdTextViewLabels[1] = cardTwoHoldText;
        holdTextViewLabels[2] = cardThreeHoldText;
        holdTextViewLabels[3] = cardFourHoldText;
        holdTextViewLabels[4] = cardFiveHoldText;

        // Find reference to ImageView's in the layout
        cardImageView1 = (ImageView) findViewById(R.id.lookup_card_one);
        cardImageView2 = (ImageView) findViewById(R.id.lookup_card_two);
        cardImageView3 = (ImageView) findViewById(R.id.lookup_card_three);
        cardImageView4 = (ImageView) findViewById(R.id.lookup_card_four);
        cardImageView5 = (ImageView) findViewById(R.id.lookup_card_five);
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
        diamondsImageView = (ImageView) findViewById(R.id.diamonds);
        heartsImageView = (ImageView) findViewById(R.id.hearts);
        clubsImageView = (ImageView) findViewById(R.id.clubs);
        spadesImageView = (ImageView) findViewById(R.id.spades);

        // Find reference to the Button in the layout
        clearButton = (Button) findViewById(R.id.lookup_clear_button);

        // Find reference to the radioGroup in the layout
        gameChoiceRadioGroup = (RadioGroup) findViewById(R.id.lookup_game_choice_radio_group);

        // Find reference to the radioButton's in the layout
        radioButtonJacks = (RadioButton) findViewById(R.id.lookup_radio_button_jacks);
        radioButtonDeuces = (RadioButton) findViewById(R.id.lookup_radio_button_deuces);

        // Set the default game selection
        gameSelected = getString(R.string.jacks_or_better);

        // Set response for RadioButton's via RadioGroup listener
        gameChoiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.lookup_radio_button_jacks:
                        gameSelected = getString(R.string.jacks_or_better);
                        break;
                    case R.id.lookup_radio_button_deuces:
                        gameSelected = getString(R.string.deuces_wild);
                }
                if (hand.size() == 5) {
                    //detectWinningHand();
                    handText.setText(Hand.getWinningHandString(context, gameSelected, hand));
                    lookUpRecommendedCardsToHold();

                }
            }
        });

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

        System.arraycopy(spadesImageViews, 0, allImageViews[0], 0, spadesImageViews.length);
        System.arraycopy(heartsImageViews, 0, allImageViews[1], 0, heartsImageViews.length);
        System.arraycopy(diamondsImageViews, 0, allImageViews[2], 0, diamondsImageViews.length);
        System.arraycopy(clubsImageViews, 0, allImageViews[3], 0, clubsImageViews.length);


        diamondsImageView.setImageResource(R.drawable.diamonds);
        heartsImageView.setImageResource(R.drawable.hearts);
        clubsImageView.setImageResource(R.drawable.clubs);
        spadesImageView.setImageResource(R.drawable.spades);

        // Set the corresponding image resource for each of the smaller non-hand card ImageViews
        for (int i = 0; i < Deck.NUM_SUITS; i++) {
            for (int j = 0; j < Deck.NUM_RANKS; j++) {
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
        for (int i = 0; i < Deck.NUM_SUITS; i++) {
            for (int j = 0; j < Deck.NUM_RANKS; j++) {
                final Card currentCard = deck.getCard((i + 1), (j + 1));
                final ImageView currentImageView = allImageViews[i][j];
                currentImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!hand.contains(currentCard)) {
                            if (hand.size() < PokerAsyncTask.NUMBER_OF_CARDS_IN_FULL_HAND) {
                                currentImageView.setAlpha(SEMI_TRANSPARENT);
                            }
                            addCardToHand(currentCard);
                        } else {
                            removeCardFromHand(currentCard, currentImageView);
                        }
                    }
                });
            }
        }

        // Set default selection of game to "Jacks or Better" via RadioButton selection
        gameChoiceRadioGroup.check(R.id.lookup_radio_button_jacks);

        // Set the OnClickListener for the clear Button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHand();
            }
        });

        // Recover state of all objects if the activity is restarted
        if (savedInstanceState != null) {
            ArrayList<Card> handCopy = (ArrayList<Card>) savedInstanceState.getSerializable(
                    STATE_PLAYER_HAND);
            gameSelected = savedInstanceState.getString(STATE_GAME_SELECTED);
            if (gameSelected == getString(R.string.jacks_or_better)) {
                gameChoiceRadioGroup.check(R.id.lookup_radio_button_jacks);
            } else if (gameSelected == getString(R.string.deuces_wild)) {
                gameChoiceRadioGroup.check(R.id.lookup_radio_button_deuces);
            }

            for (Card card : handCopy) {
                for (int i = 0; i < Deck.NUM_SUITS; i++) {
                    for (int j = 0; j < Deck.NUM_RANKS; j++) {
                        Card cardFromImageView = (Card) allImageViews[i][j].getTag();
                        if (cardFromImageView.toString().equals(card.toString())) {
                            allImageViews[i][j].performClick();
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_PLAYER_HAND, hand);
        outState.putString(STATE_GAME_SELECTED, gameSelected);
    }

    public boolean addCardToHand(Card cardToAdd) {
        if (hand.size() < PokerAsyncTask.NUMBER_OF_CARDS_IN_FULL_HAND) {
            hand.add(cardToAdd);
            for (ImageView cardImageView : new ImageView[]{cardImageView1, cardImageView2,
                    cardImageView3, cardImageView4, cardImageView5}) {
                if (isBlank(cardImageView)) {
                    cardImageView.setImageResource(cardToAdd.getmResourceIdFull());
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
                smallImage.setAlpha(FULLY_VISIBLE);
            }
        }

        for (ImageView smallImage : heartsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(FULLY_VISIBLE);
            }
        }

        for (ImageView smallImage : diamondsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(FULLY_VISIBLE);
            }
        }

        for (ImageView smallImage : clubsImageViews) {
            if (smallImage.getTag() == cardToRemoveImageView.getTag()) {
                smallImage.setAlpha(FULLY_VISIBLE);
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
            cardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
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
            case PokerAsyncTask.NUMBER_OF_CARDS_IN_FULL_HAND:
                //detectWinningHand();
                handText.setText(Hand.getWinningHandString(context, gameSelected, hand));
                lookUpRecommendedCardsToHold();
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
                (LookupActivity.this, R.drawable.blank_small_version).getConstantState();
    }

    public void setBlank(ImageView image) {
        image.setImageResource(R.drawable.blank_small_version);
    }

    public void setAllImagesToNormalAlpha() {
        for (ImageView smallImage : spadesImageViews) {
            smallImage.setAlpha(FULLY_VISIBLE);
        }

        for (ImageView smallImage : heartsImageViews) {
            smallImage.setAlpha(FULLY_VISIBLE);
        }

        for (ImageView smallImage : diamondsImageViews) {
            smallImage.setAlpha(FULLY_VISIBLE);
        }

        for (ImageView smallImage : clubsImageViews) {
            smallImage.setAlpha(FULLY_VISIBLE);
        }
    }

    public void lookUpRecommendedCardsToHold() {
        // Use a String representation of the current five card hand to look up the correct
        // serialized HashMap object.  The String representation of the hand should match as one of
        // the keys to this HashMap, and will pair with corresponding value, which is a String
        // representing the optimal choices of cards to hold.
        new PokerAsyncTask(this, directionsText, hand, holdTextViewLabels,
                gameSelected).execute(Hand.sortedTomHandString(hand));
    }

    public ArrayList<Card> createDeckListOfCards(Deck deck) {
        Deck mDeck = deck;
        ArrayList<Card> mDeckListMaster = new ArrayList<>();
        for (int suit = 0; suit < Deck.NUM_SUITS; suit++) {
            for (int rank = 0; rank < Deck.NUM_RANKS; rank++) {
                mDeckListMaster.add(mDeck.getCard(suit + 1, rank + 1));
            }
        }
        return mDeckListMaster;
    }

}