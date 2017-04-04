package com.rallymonkey911.android.pokertrainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

    public TextView sampleText;
    public Button clearButton;
    public List<Card> hand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct deck of Card objects, using the {@link Deck} class
        Deck deck = new Deck(this);

        // Initialize empty list for the five card hand
        hand = new ArrayList<>();

        // Find reference to TextView in the layout
        sampleText = (TextView)findViewById(R.id.sample_text);

        //Find reference to ImageView's in the layout
        cardImageView1 = (ImageView)findViewById(R.id.card_one);
        cardImageView2 = (ImageView)findViewById(R.id.card_two);
        cardImageView3 = (ImageView)findViewById(R.id.card_three);
        cardImageView4 = (ImageView)findViewById(R.id.card_four);
        cardImageView5 = (ImageView)findViewById(R.id.card_five);

        aceDiamondsImageView = (ImageView)findViewById(R.id.ace_diamonds);
        deuceDiamondsImageView = (ImageView)findViewById(R.id.deuce_diamonds);
        threeDiamondsImageView = (ImageView)findViewById(R.id.three_diamonds);
        fourDiamondsImageView = (ImageView)findViewById(R.id.four_diamonds);
        fiveDiamondsImageView = (ImageView)findViewById(R.id.five_diamonds);
        sixDiamondsImageView = (ImageView)findViewById(R.id.six_diamonds);
        sevenDiamondsImageView = (ImageView)findViewById(R.id.seven_diamonds);
        eightDiamondsImageView = (ImageView)findViewById(R.id.eight_diamonds);
        nineDiamondsImageView = (ImageView)findViewById(R.id.nine_diamonds);
        tenDiamondsImageView = (ImageView)findViewById(R.id.ten_diamonds);
        jackDiamondsImageView = (ImageView)findViewById(R.id.jack_diamonds);
        queenDiamondsImageView = (ImageView)findViewById(R.id.queen_diamonds);
        kingDiamondsImageView = (ImageView)findViewById(R.id.king_diamonds);

        aceHeartsImageView = (ImageView)findViewById(R.id.ace_hearts);
        deuceHeartsImageView = (ImageView)findViewById(R.id.deuce_hearts);
        threeHeartsImageView = (ImageView)findViewById(R.id.three_hearts);
        fourHeartsImageView = (ImageView)findViewById(R.id.four_hearts);
        fiveHeartsImageView = (ImageView)findViewById(R.id.five_hearts);
        sixHeartsImageView = (ImageView)findViewById(R.id.six_hearts);
        sevenHeartsImageView = (ImageView)findViewById(R.id.seven_hearts);
        eightHeartsImageView = (ImageView)findViewById(R.id.eight_hearts);
        nineHeartsImageView = (ImageView)findViewById(R.id.nine_hearts);
        tenHeartsImageView = (ImageView)findViewById(R.id.ten_hearts);
        jackHeartsImageView = (ImageView)findViewById(R.id.jack_hearts);
        queenHeartsImageView = (ImageView)findViewById(R.id.queen_hearts);
        kingHeartsImageView = (ImageView)findViewById(R.id.king_hearts);

        aceClubsImageView = (ImageView)findViewById(R.id.ace_clubs);
        deuceClubsImageView = (ImageView)findViewById(R.id.deuce_clubs);
        threeClubsImageView = (ImageView)findViewById(R.id.three_clubs);
        fourClubsImageView = (ImageView)findViewById(R.id.four_clubs);
        fiveClubsImageView = (ImageView)findViewById(R.id.five_clubs);
        sixClubsImageView = (ImageView)findViewById(R.id.six_clubs);
        sevenClubsImageView = (ImageView)findViewById(R.id.seven_clubs);
        eightClubsImageView = (ImageView)findViewById(R.id.eight_clubs);
        nineClubsImageView = (ImageView)findViewById(R.id.nine_clubs);
        tenClubsImageView = (ImageView)findViewById(R.id.ten_clubs);
        jackClubsImageView = (ImageView)findViewById(R.id.jack_clubs);
        queenClubsImageView = (ImageView)findViewById(R.id.queen_clubs);
        kingClubsImageView = (ImageView)findViewById(R.id.king_clubs);

        aceSpadesImageView = (ImageView)findViewById(R.id.ace_spades);
        deuceSpadesImageView = (ImageView)findViewById(R.id.deuce_spades);
        threeSpadesImageView = (ImageView)findViewById(R.id.three_spades);
        fourSpadesImageView = (ImageView)findViewById(R.id.four_spades);
        fiveSpadesImageView = (ImageView)findViewById(R.id.five_spades);
        sixSpadesImageView = (ImageView)findViewById(R.id.six_spades);
        sevenSpadesImageView = (ImageView)findViewById(R.id.seven_spades);
        eightSpadesImageView = (ImageView)findViewById(R.id.eight_spades);
        nineSpadesImageView = (ImageView)findViewById(R.id.nine_spades);
        tenSpadesImageView = (ImageView)findViewById(R.id.ten_spades);
        jackSpadesImageView = (ImageView)findViewById(R.id.jack_spades);
        queenSpadesImageView = (ImageView)findViewById(R.id.queen_spades);
        kingSpadesImageView = (ImageView)findViewById(R.id.king_spades);

        clearButton = (Button)findViewById(R.id.clear_button);

        ImageView[] cardSlotImageViews = {cardImageView1, cardImageView2, cardImageView3,
                cardImageView4, cardImageView5};

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


        for (int i = 0; i < 13; i++){
            diamondImageViews[i].setImageResource(deck.getCard(1, i+1).getmResourceId());
        }

        for (int i = 0; i < 13; i++){
            heartsImageViews[i].setImageResource(deck.getCard(2, i+1).getmResourceId());
        }

        for (int i = 0; i < 13; i++){
            clubsImageViews[i].setImageResource(deck.getCard(3, i+1).getmResourceId());
        }

        for (int i = 0; i < 13; i++){
            spadesImageViews[i].setImageResource(deck.getCard(4, i+1).getmResourceId());
        }

        // Define the OnClickListener for the five ImageViews representing the current hand
        View.OnClickListener handClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView handCardImage = (ImageView) v;
                if (handCardImage.getDrawable().getConstantState() !=
                        getResources().getDrawable(R.drawable.blank_small_version)
                                .getConstantState()){
                    Card card = (Card) handCardImage.getTag();
                    removeCardFromHand(card);
                }
            }
        };

        // Set the five hand ImageView's as invisible, and set their OnClickListeners
        for (ImageView blankImageView : cardSlotImageViews){
            blankImageView.setImageResource(R.drawable.blank_small_version);
            blankImageView.setOnClickListener(handClickListener);
        }

        for (int i = 0; i < 13; i++){
            final Card currentCard = deck.getCard(1, i+1);
            ImageView currentImageView = diamondImageViews[i];
            currentImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hand.contains(currentCard)){
                        addCardToHand(currentCard);
                    } else {
                        Toast.makeText(getApplication(), "Card already in hand",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        for (int i = 0; i < 13; i++){
            final Card currentCard = deck.getCard(2, i+1);
            ImageView currentImageView = heartsImageViews[i];
            currentImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hand.contains(currentCard)){
                        addCardToHand(currentCard);
                    } else {
                        Toast.makeText(getApplication(), "Card already in hand",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        for (int i = 0; i < 13; i++){
            final Card currentCard = deck.getCard(3, i+1);
            ImageView currentImageView = clubsImageViews[i];
            currentImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hand.contains(currentCard)){
                        addCardToHand(currentCard);
                    } else {
                        Toast.makeText(getApplication(), "Card already in hand",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        for (int i = 0; i < 13; i++){
            final Card currentCard = deck.getCard(4, i+1);
            ImageView currentImageView = spadesImageViews[i];
            currentImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hand.contains(currentCard)){
                        addCardToHand(currentCard);
                    } else {
                        Toast.makeText(getApplication(), "Card already in hand",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHand();
            }
        });
    }

    public boolean addCardToHand(Card cardToAdd){
        if (hand.size() <= 4){
            hand.add(cardToAdd);
            if (isBlank(cardImageView1)){
                cardImageView1.setImageResource(cardToAdd.getmResourceId());
                cardImageView1.setTag(cardToAdd);
            } else if (isBlank(cardImageView2)){
                cardImageView2.setImageResource(cardToAdd.getmResourceId());
                cardImageView2.setTag(cardToAdd);
            } else if (isBlank(cardImageView3)){
                cardImageView3.setImageResource(cardToAdd.getmResourceId());
                cardImageView3.setTag(cardToAdd);
            } else if (isBlank(cardImageView4)){
                cardImageView4.setImageResource(cardToAdd.getmResourceId());
                cardImageView4.setTag(cardToAdd);
            } else {
                cardImageView5.setImageResource(cardToAdd.getmResourceId());
                cardImageView5.setTag(cardToAdd);
            }
            setSampleText();
            return true;
        } else {
            Toast.makeText(getApplication(), "Hand is full.  To discard," +
                            " select from amongst the 5-card hand",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean removeCardFromHand(Card cardToRemove){
        if (isImageViewMatch(cardToRemove, cardImageView1)){
            setBlank(cardImageView1);
        } else if (isImageViewMatch(cardToRemove, cardImageView2)){
            setBlank(cardImageView2);
        } else if (isImageViewMatch(cardToRemove, cardImageView3)){
            setBlank(cardImageView3);
        } else if (isImageViewMatch(cardToRemove, cardImageView4)){
            setBlank(cardImageView4);
        } else if (isImageViewMatch(cardToRemove, cardImageView5)){
            setBlank(cardImageView5);
        }
        else{return false;}
        setSampleText();
        return hand.remove(cardToRemove);
    }

    public void setSampleText(){
        int count = 0;
        if (!isBlank(cardImageView1)){
            count++;
        }
        if (!isBlank(cardImageView2)){
            count++;
        }
        if (!isBlank(cardImageView3)) {
            count++;
        }
        if (!isBlank(cardImageView4)) {
            count++;
        }
        if (!isBlank(cardImageView5)) {
            count++;
        }
        if (count == 1){
            sampleText.setText("" + count + " card is selected");
        } else if (count < 5 && count > 1) {
            sampleText.setText("" + count + " cards are selected");
        } else if (count == 5){
            runCalculation();
        } else {
            sampleText.setText(R.string.select_cards);
        }
    }

    public void clearHand(){
        ImageView[] cardSlotImageViews = {cardImageView1, cardImageView2, cardImageView3,
                cardImageView4, cardImageView5};
        for (ImageView cardInHand : cardSlotImageViews){
            cardInHand.setImageResource(R.drawable.blank_small_version);
        }
        hand.clear();
        setSampleText();
    }

    public boolean isBlank(ImageView image) {
        return image.getDrawable().getConstantState() == getResources().
                getDrawable(R.drawable.blank_small_version).getConstantState();
    }

    public void setBlank(ImageView image){
        image.setImageResource(R.drawable.blank_small_version);
    }

    public boolean isImageViewMatch(Card card, ImageView imageView){
        int cardResId = card.getmResourceId();
        int imageViewResId = ((Card)imageView.getTag()).getmResourceId();
        return cardResId == imageViewResId;
    }

    public void runCalculation(){
        sampleText.setText("RUNNING CALC...");
    }
}