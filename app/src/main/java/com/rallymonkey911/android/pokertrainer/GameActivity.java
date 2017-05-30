package com.rallymonkey911.android.pokertrainer;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private Button continueButton;

    private Random rand;

    private Deck deck;

    private ArrayList<Card> deckListMaster, deckListCopy;

    // Declare List of Card objects that will later be used to represent the current hand.
    private ArrayList<Card> hand, handToHold;

    // Declare RadioGroup object that will be used to hold RadioButton objects
    private RadioGroup gameChoiceRadioGroup;

    // Declare RadioButton objects that will be used to select the appropriate result table
    private RadioButton radioButtonJacks, radioButtonDeuces;

    // Declare variable to hold reference to selected game
    private String gameSelected;

    private static final String STATE_PLAYER_HAND = "playerHand";
    private static final String STATE_GAME_SELECTED = "gameSelected";
    private static final int HAND_SIZE = 5;

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

        // Initialize empty list for the cards to hold
        handToHold = new ArrayList<>();

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
        continueButton = (Button) findViewById(R.id.continue_button);

        gameCardImageViews = new ImageView[5];
        gameCardImageViews[0] = gameCardImageView1;
        gameCardImageViews[1] = gameCardImageView2;
        gameCardImageViews[2] = gameCardImageView3;
        gameCardImageViews[3] = gameCardImageView4;
        gameCardImageViews[4] = gameCardImageView5;


        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(removeRandomCardFromDeckCopy());
            gameCardImageViews[i].setImageResource(hand.get(i).getmResourceIdFull());
        }











/*

        // Define the OnClickListener for the five ImageViews representing the current hand
        View.OnClickListener handClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView handCardImage = (ImageView) v;

                // Get Card object that is paired with this ImageView
                Card card = (Card) handCardImage.getTag();
                if (!isHeld(handCardImage)) {
                    holdCard(card, handCardImage);
                }
            }
        };



        // Set the five hand ImageViews with a blank card image resource, and also set their
        // OnClickListeners
        for (ImageView blankImageView : new ImageView[]{gameCardImageView1, gameCardImageView2,
                gameCardImageView3, gameCardImageView4, gameCardImageView5}) {
            setBlank(blankImageView);
            blankImageView.setOnClickListener(handClickListener);
        }

*/

    }

    public void setBlank(ImageView image) {
        image.setImageResource(R.drawable.blank_small_version);
    }

    private boolean isHeld(ImageView imageView) {
        Card card = (Card) imageView.getTag();
        return true;

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

}
