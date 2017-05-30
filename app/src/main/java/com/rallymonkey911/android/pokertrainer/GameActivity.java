package com.rallymonkey911.android.pokertrainer;

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

    // Declare all ImageView objects in the layout
    private ImageView gameCardImageView1, gameCardImageView2, gameCardImageView3, gameCardImageView4,
            gameCardImageView5;
    ImageView[] gameCardImageViews;

    // Declare all TextView objects in the layout
    public TextView gameCardHoldText1, gameCardHoldText2, gameCardHoldText3,
            gameCardHoldText4, gameCardHoldText5;
    TextView[] gameCardHoldTextViews;

    boolean[] isHold = new boolean[HAND_SIZE];

    private Button drawButton;
    private Button dealButton;

    private Random rand;

    private Deck deck;

    private ArrayList<Card> deckListMaster, deckListCopy;

    // Declare List of Card objects that will later be used to represent the current hand.
    private ArrayList<Card> hand;

    // Declare RadioGroup object that will be used to hold RadioButton objects
    private RadioGroup gameChoiceRadioGroup;

    // Declare RadioButton objects that will be used to select the appropriate result table
    private RadioButton radioButtonJacks, radioButtonDeuces;

    // Declare variable to hold reference to selected game
    private String gameSelected;

    private static final String STATE_PLAYER_HAND = "playerHand";
    private static final String STATE_GAME_SELECTED = "gameSelected";
    private static final int HAND_SIZE = 5;
    private static final float VISIBLE_FLOAT_VALUE = 1.00f;
    private static final float SEMI_VISIBLE_FLOAT_VALUE = 0.25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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

        gameCardImageView1 = (ImageView) findViewById(R.id.game_card_one);
        gameCardImageView2 = (ImageView) findViewById(R.id.game_card_two);
        gameCardImageView3 = (ImageView) findViewById(R.id.game_card_three);
        gameCardImageView4 = (ImageView) findViewById(R.id.game_card_four);
        gameCardImageView5 = (ImageView) findViewById(R.id.game_card_five);
        gameCardHoldText1 = (TextView) findViewById(R.id.game_card_one_hold);
        gameCardHoldText2 = (TextView) findViewById(R.id.game_card_two_hold);
        gameCardHoldText3 = (TextView) findViewById(R.id.game_card_three_hold);
        gameCardHoldText4 = (TextView) findViewById(R.id.game_card_four_hold);
        gameCardHoldText5 = (TextView) findViewById(R.id.game_card_five_hold);

        drawButton = (Button) findViewById(R.id.draw_button);
        dealButton = (Button) findViewById(R.id.deal_button);
        toggleButtonClickability(dealButton);

        gameCardImageViews = new ImageView[HAND_SIZE];
        gameCardImageViews[0] = gameCardImageView1;
        gameCardImageViews[1] = gameCardImageView2;
        gameCardImageViews[2] = gameCardImageView3;
        gameCardImageViews[3] = gameCardImageView4;
        gameCardImageViews[4] = gameCardImageView5;

        gameCardHoldTextViews = new TextView[HAND_SIZE];
        gameCardHoldTextViews[0] = gameCardHoldText1;
        gameCardHoldTextViews[1] = gameCardHoldText2;
        gameCardHoldTextViews[2] = gameCardHoldText3;
        gameCardHoldTextViews[3] = gameCardHoldText4;
        gameCardHoldTextViews[4] = gameCardHoldText5;

        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(removeRandomCardFromDeckCopy());
            gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
            //gameCardImageViews[i].setTag(hand.get(i));
        }

        // Define the OnClickListener for the five ImageViews representing the current hand
        View.OnClickListener handClickListener = new View.OnClickListener() {
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
        };

        // Set the OnClickListeners for the five hand ImageViews
        for (ImageView imageView : new ImageView[]{gameCardImageView1, gameCardImageView2,
                gameCardImageView3, gameCardImageView4, gameCardImageView5}) {
            imageView.setOnClickListener(handClickListener);
        }

        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                toggleButtonClickability(drawButton);
                toggleButtonClickability(dealButton);
            }
        });

        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hand.clear();
                drawButton.setClickable(true);
                deckListCopy = new ArrayList<>();
                deckListCopy.addAll(deckListMaster);
                for (int i = 0; i < HAND_SIZE; i++) {
                    hand.add(removeRandomCardFromDeckCopy());
                    gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
                    gameCardImageViews[i].setClickable(true);
                }
                toggleButtonClickability(drawButton);
                toggleButtonClickability(dealButton);
            }
        });

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

    public void toggleButtonClickability(Button button) {
        if (button.getAlpha() == VISIBLE_FLOAT_VALUE){
            button.setClickable(false);
            button.setAlpha((SEMI_VISIBLE_FLOAT_VALUE));
        } else {
            button.setClickable(true);
            button.setAlpha(VISIBLE_FLOAT_VALUE);
        }
    }
}
