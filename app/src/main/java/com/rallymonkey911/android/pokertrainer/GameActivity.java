package com.rallymonkey911.android.pokertrainer;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Context context;

    // Declare all ImageView objects in the layout
    private ImageView gameCardImageView1, gameCardImageView2, gameCardImageView3, gameCardImageView4,
            gameCardImageView5, gameHintCardImageView1, gameHintCardImageView2,
            gameHintCardImageView3, gameHintCardImageView4, gameHintCardImageView5;
    ImageView[] gameCardImageViews, gameHintCardImageViews;

    // Declare all TextView objects in the layout
    public TextView gameCardHoldText1, gameCardHoldText2, gameCardHoldText3,
            gameCardHoldText4, gameCardHoldText5, gameHandText, gameHintCardHoldText1,
            gameHintCardHoldText2, gameHintCardHoldText3, gameHintCardHoldText4,
            gameHintCardHoldText5, gameHintHandText, betText, betAmountText, walletText,
            walletAmountText;
    TextView[] gameCardHoldTextViews, gameHintCardHoldTextViews;

    boolean[] isHold = new boolean[HAND_SIZE];

    private Button drawButton;
    private Button dealButton;
    private Button hintButton;

    private Random rand;

    private int bet, wallet;

    private Deck deck;

    private ArrayList<Card> deckListMaster, deckListCopy;

    // Declare List of Card objects that will later be used to represent the current hand.
    private ArrayList<Card> hand;
    private ArrayList<Card> hintHand;

    // Declare RadioGroup object that will be used to hold RadioButton objects
    private RadioGroup gameChoiceRadioGroup;

    // Declare RadioButton objects that will be used to select the appropriate result table
    private RadioButton radioButtonJacks, radioButtonDeuces;

    // Declare variable to hold reference to selected game
    private String gameSelected;

    private boolean isHintShown;

    // TODO implement code to save state on orientation change
    private static final String STATE_PLAYER_HAND = "playerHand";
    private static final String STATE_GAME_SELECTED = "gameSelected";
    private static final int HAND_SIZE = 5;
    private static final float VISIBLE_FLOAT_VALUE = 1.00f;
    private static final float SEMI_VISIBLE_FLOAT_VALUE = 0.25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        context = this;
        rand = new Random();
        setUpMasterDeck();
        deckListCopy = new ArrayList<>();
        deckListCopy.addAll(deckListMaster);

        // Initialize empty list for the five card hand
        hand = new ArrayList<>();

        // Set up array that contains which cards to hold and set default to not hold
        for (int i = 0; i < HAND_SIZE; i++) {
            isHold[i] = false;
        }

        // Find references to all ImageViews in the layout
        gameCardImageView1 = (ImageView) findViewById(R.id.game_card_one);
        gameCardImageView2 = (ImageView) findViewById(R.id.game_card_two);
        gameCardImageView3 = (ImageView) findViewById(R.id.game_card_three);
        gameCardImageView4 = (ImageView) findViewById(R.id.game_card_four);
        gameCardImageView5 = (ImageView) findViewById(R.id.game_card_five);
        gameHintCardImageView1 = (ImageView) findViewById(R.id.game_hint_card_one);
        gameHintCardImageView2 = (ImageView) findViewById(R.id.game_hint_card_two);
        gameHintCardImageView3 = (ImageView) findViewById(R.id.game_hint_card_three);
        gameHintCardImageView4 = (ImageView) findViewById(R.id.game_hint_card_four);
        gameHintCardImageView5 = (ImageView) findViewById(R.id.game_hint_card_five);

        // Find references to all TextViews in the layout
        gameCardHoldText1 = (TextView) findViewById(R.id.game_card_one_hold);
        gameCardHoldText2 = (TextView) findViewById(R.id.game_card_two_hold);
        gameCardHoldText3 = (TextView) findViewById(R.id.game_card_three_hold);
        gameCardHoldText4 = (TextView) findViewById(R.id.game_card_four_hold);
        gameCardHoldText5 = (TextView) findViewById(R.id.game_card_five_hold);
        gameHintCardHoldText1 = (TextView) findViewById(R.id.game_hint_card_one_hold);
        gameHintCardHoldText2 = (TextView) findViewById(R.id.game_hint_card_two_hold);
        gameHintCardHoldText3 = (TextView) findViewById(R.id.game_hint_card_three_hold);
        gameHintCardHoldText4 = (TextView) findViewById(R.id.game_hint_card_four_hold);
        gameHintCardHoldText5 = (TextView) findViewById(R.id.game_hint_card_five_hold);
        gameHandText = (TextView) findViewById(R.id.game_hand_text);
        gameHintHandText = (TextView) findViewById(R.id.game_hint_hand_text);
        betText = (TextView) findViewById(R.id.bet_text);
        betAmountText = (TextView) findViewById(R.id.bet_amount_text);
        walletText = (TextView) findViewById(R.id.wallet_text);
        walletAmountText = (TextView) findViewById(R.id.wallet_amount_text);

        // Find references to all Buttons in the layout
        drawButton = (Button) findViewById(R.id.draw_button);
        dealButton = (Button) findViewById(R.id.deal_button);
        hintButton = (Button) findViewById(R.id.hint_button);

        // Find reference to the radioGroup in the layout
        gameChoiceRadioGroup = (RadioGroup) findViewById(R.id.game_game_choice_radio_group);

        // Find reference to the radioButton's in the layout
        radioButtonJacks = (RadioButton) findViewById(R.id.game_radio_button_jacks);
        radioButtonDeuces = (RadioButton) findViewById(R.id.game_radio_button_deuces);

        // Create arrays to hold ImageViews
        gameCardImageViews = new ImageView[HAND_SIZE];
        gameCardImageViews[0] = gameCardImageView1;
        gameCardImageViews[1] = gameCardImageView2;
        gameCardImageViews[2] = gameCardImageView3;
        gameCardImageViews[3] = gameCardImageView4;
        gameCardImageViews[4] = gameCardImageView5;
        gameHintCardImageViews = new ImageView[HAND_SIZE];
        gameHintCardImageViews[0] = gameHintCardImageView1;
        gameHintCardImageViews[1] = gameHintCardImageView2;
        gameHintCardImageViews[2] = gameHintCardImageView3;
        gameHintCardImageViews[3] = gameHintCardImageView4;
        gameHintCardImageViews[4] = gameHintCardImageView5;

        // Create arrays to hold TextViews
        gameCardHoldTextViews = new TextView[HAND_SIZE];
        gameCardHoldTextViews[0] = gameCardHoldText1;
        gameCardHoldTextViews[1] = gameCardHoldText2;
        gameCardHoldTextViews[2] = gameCardHoldText3;
        gameCardHoldTextViews[3] = gameCardHoldText4;
        gameCardHoldTextViews[4] = gameCardHoldText5;
        gameHintCardHoldTextViews = new TextView[HAND_SIZE];
        gameHintCardHoldTextViews[0] = gameHintCardHoldText1;
        gameHintCardHoldTextViews[1] = gameHintCardHoldText2;
        gameHintCardHoldTextViews[2] = gameHintCardHoldText3;
        gameHintCardHoldTextViews[3] = gameHintCardHoldText4;
        gameHintCardHoldTextViews[4] = gameHintCardHoldText5;

        // Set the OnClickListener for the five ImageViews representing the current hand
        for (ImageView imageView : new ImageView[]{gameCardImageView1, gameCardImageView2,
                gameCardImageView3, gameCardImageView4, gameCardImageView5}) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.game_card_one:
                            toggleHold(0);
                            break;
                        case R.id.game_card_two:
                            toggleHold(1);
                            break;
                        case R.id.game_card_three:
                            toggleHold(2);
                            break;
                        case R.id.game_card_four:
                            toggleHold(3);
                            break;
                        case R.id.game_card_five:
                            toggleHold(4);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        // Set the click listener for the Draw button
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isHintShown) {
                    hintButton.performClick();
                }

                gameHintHandText.setVisibility(View.VISIBLE);

                for (int i = 0; i < HAND_SIZE; i++) {
                    if (!isHold[i]) {
                        hand.set(i, removeRandomCardFromDeckCopy());
                        gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
                    } else {
                        isHold[i] = false;
                        gameCardHoldTextViews[i].setVisibility(View.INVISIBLE);
                    }
                    gameCardImageViews[i].setClickable(false);
                }

                gameHandText.setText(Hand.getWinningHandString(context, gameSelected, hand));
                toggleViewClickability(drawButton);
                toggleViewClickability(dealButton);
                toggleViewClickability(hintButton);
                toggleViewClickability(radioButtonJacks);
                toggleViewClickability(radioButtonDeuces);
            }
        });

        // Set the click listener for the Deal button
        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleViewClickability(radioButtonJacks);
                toggleViewClickability(radioButtonDeuces);
                hideHintCardImageViews();
                hideHintCardHoldTextViews();
                hideGameHintHandText();
                hintButton.setText(getString(R.string.show_hint));
                isHintShown = false;
                gameHandText.setText(getString(R.string.default_game_hand_text));
                hand.clear();
                drawButton.setClickable(true);
                deckListCopy = new ArrayList<>();
                deckListCopy.addAll(deckListMaster);
                for (int i = 0; i < HAND_SIZE; i++) {
                    hand.add(removeRandomCardFromDeckCopy());
                    gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
                    gameCardImageViews[i].setClickable(true);
                }
                hintHand = new ArrayList<>(hand);
                toggleViewClickability(drawButton);
                toggleViewClickability(dealButton);
                toggleViewClickability(hintButton);
            }
        });

        // Set the click listener for the Hint button
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isHintShown) {
                    for (int i = 0; i < HAND_SIZE; i++) {
                        gameHintCardImageViews[i].setImageResource(hintHand.get(i).getmResourceIdFull());
                    }
                    showHintCardImageViews();
                    lookUpRecommendedCardsToHold(hintHand);
                    isHintShown = true;
                    hintButton.setText(getString(R.string.hide_hint));
                } else {
                    hideGameHintHandText();
                    hideHintCardHoldTextViews();
                    hideHintCardImageViews();
                    isHintShown = false;
                    hintButton.setText(getString(R.string.show_hint));
                }
            }
        });

        // Set response for RadioButton's via RadioGroup listener
        gameChoiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.game_radio_button_jacks) {
                    gameSelected = getString(R.string.jacks_or_better);
                } else if (checkedId == R.id.game_radio_button_deuces) {
                    gameSelected = getString(R.string.deuces_wild);
                }
                if (isHintShown) {
                    lookUpRecommendedCardsToHold(hintHand);
                }
            }
        });

        // Set default selection of game to "Jacks or Better" via RadioButton selection
        gameChoiceRadioGroup.check(R.id.game_radio_button_jacks);

        // Set up game so that deal is not selectable after hand is drawn
        toggleViewClickability(dealButton);

        // Select cards from deck and form initial hand
        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(removeRandomCardFromDeckCopy());
            gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
        }

        // Create copy of initial hand and set this aside for the hint row
        hintHand = new ArrayList<>(hand);

        // TODO properly enable prompt to set bet prior to first deal
        bet = 100;
        wallet = 500;
        if (betText != null &&
                walletText != null &&
                betAmountText != null &&
                walletAmountText != null) {
            betText.setText(R.string.bet);
            walletText.setText(R.string.wallet);
            betAmountText.setText(String.valueOf(bet));
            walletAmountText.setText(String.valueOf(wallet));
        }
    }

    public void setUpMasterDeck() {
        deck = new Deck(this);
        deckListMaster = new ArrayList<>();
        for (int suit = 0; suit < Deck.NUM_SUITS; suit++) {
            for (int rank = 0; rank < Deck.NUM_RANKS; rank++) {
                deckListMaster.add(deck.getCard(suit + 1, rank + 1));
            }
        }
    }

    public Card removeRandomCardFromDeckCopy() {
        int cardIndex = rand.nextInt(deckListCopy.size());
        return deckListCopy.remove(cardIndex);
    }

    public void toggleHold(int i) {
        if (!isHold[i]) {
            isHold[i] = true;
            gameCardHoldTextViews[i].setVisibility(View.VISIBLE);
        } else {
            isHold[i] = false;
            gameCardHoldTextViews[i].setVisibility(View.INVISIBLE);
        }
    }

    public void toggleViewClickability(View v) {
        if (v.getAlpha() == VISIBLE_FLOAT_VALUE) {
            v.setClickable(false);
            v.setAlpha((SEMI_VISIBLE_FLOAT_VALUE));
        } else {
            v.setClickable(true);
            v.setAlpha(VISIBLE_FLOAT_VALUE);
        }
    }

    public void lookUpRecommendedCardsToHold(ArrayList<Card> handToLookup) {
        // Use a String representation of the current five card hand to look up the correct
        // serialized HashMap object.  The String representation of the hand should match as one of
        // the keys to this HashMap, and will pair with corresponding value, which is a String
        // representing the optimal choices of cards to hold.
        new PokerAsyncTask(this, gameHintHandText, handToLookup, gameHintCardHoldTextViews,
                gameSelected).execute(Hand.sortedTomHandString(hand));
    }

    private void hideHintCardImageViews() {
        for (ImageView hintCardImageView : gameHintCardImageViews) {
            hintCardImageView.setVisibility(View.INVISIBLE);
        }
    }

    private void hideHintCardHoldTextViews() {
        for (TextView hintCardHoldTextView : gameHintCardHoldTextViews) {
            hintCardHoldTextView.setVisibility(View.INVISIBLE);
        }
    }

    private void hideGameHintHandText() {
        gameHintHandText.setVisibility(View.INVISIBLE);
    }

    private void showHintCardImageViews() {
        for (ImageView hintCardImageView : gameHintCardImageViews) {
            hintCardImageView.setVisibility(View.VISIBLE);
        }
    }
}