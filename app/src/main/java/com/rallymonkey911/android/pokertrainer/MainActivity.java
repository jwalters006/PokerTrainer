package com.rallymonkey911.android.pokertrainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ImageView cardImageView1;
    public static ImageView cardImageView2;
    public static ImageView cardImageView3;
    public static ImageView cardImageView4;
    public static ImageView cardImageView5;
    public static TextView sampleText;
    public static List<Card> hand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find reference to ImageView's in the layout
        cardImageView1 = (ImageView)findViewById(R.id.card_one);
        cardImageView2 = (ImageView)findViewById(R.id.card_two);
        cardImageView3 = (ImageView)findViewById(R.id.card_three);
        cardImageView4 = (ImageView)findViewById(R.id.card_four);
        cardImageView5 = (ImageView)findViewById(R.id.card_five);

        // Set the five hand ImageView's as invisible, prior to selection of cards
        cardImageView1.setVisibility(View.INVISIBLE);
        cardImageView2.setVisibility(View.INVISIBLE);
        cardImageView3.setVisibility(View.INVISIBLE);
        cardImageView4.setVisibility(View.INVISIBLE);
        cardImageView5.setVisibility(View.INVISIBLE);

        // Find reference to TextView in the layout
        sampleText = (TextView)findViewById(R.id.sample_text);

        // Construct deck of Card objects, using the {@link Deck} class
        Deck deck = new Deck(this);

        // Move the deck of cards into a nested list of cards
        final List<List<Card>> allCards = Deck.getCardArrayList(deck);

        // Initialize empty list for the five card hand
        hand = new ArrayList<>();

        // Create a CardAdapter, whose data source is an ArrayList of Card's
        CardAdapter adapter = new CardAdapter(this, allCards);

        // Find the ListView object in the activity_main.xml layout file
        ListView listView = (ListView) findViewById(R.id.list);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }

    public static boolean addCardToHand(Card cardToAdd){
        if (hand.size() <= 4){
            hand.add(cardToAdd);
            if (cardImageView1.getVisibility() == View.INVISIBLE){
                cardImageView1.setImageResource(cardToAdd.getmResourceId());
                cardImageView1.setVisibility(View.VISIBLE);
                cardImageView1.setTag(cardToAdd.getmResourceId());
            } else if (cardImageView2.getVisibility() == View.INVISIBLE){
                cardImageView2.setImageResource(cardToAdd.getmResourceId());
                cardImageView2.setVisibility(View.VISIBLE);
                cardImageView2.setTag(cardToAdd.getmResourceId());
            } else if (cardImageView3.getVisibility() == View.INVISIBLE){
                cardImageView3.setImageResource(cardToAdd.getmResourceId());
                cardImageView3.setVisibility(View.VISIBLE);
                cardImageView3.setTag(cardToAdd.getmResourceId());
            } else if (cardImageView4.getVisibility() == View.INVISIBLE){
                cardImageView4.setImageResource(cardToAdd.getmResourceId());
                cardImageView4.setVisibility(View.VISIBLE);
                cardImageView4.setTag(cardToAdd.getmResourceId());
            } else {
                cardImageView5.setImageResource(cardToAdd.getmResourceId());
                cardImageView5.setVisibility(View.VISIBLE);
                cardImageView5.setTag(cardToAdd.getmResourceId());
            }
            setSampleText();
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeCardFromHand(Card cardToRemove){
        int resId = cardToRemove.getmResourceId();
        if ((Integer) cardImageView1.getTag() == resId){
            cardImageView1.setVisibility(View.INVISIBLE);
        } else if ((Integer) cardImageView2.getTag() == resId){
            cardImageView2.setVisibility(View.INVISIBLE);
        } else if ((Integer) cardImageView3.getTag() == resId){
            cardImageView3.setVisibility(View.INVISIBLE);
        } else if ((Integer) cardImageView4.getTag() == resId){
            cardImageView4.setVisibility(View.INVISIBLE);
        } else if ((Integer) cardImageView5.getTag() == resId){
            cardImageView5.setVisibility(View.INVISIBLE);
        }
        else{return false;}
        setSampleText();
        return hand.remove(cardToRemove);
    }

    public static void setSampleText(){
        int count = 0;
        if (cardImageView1.getVisibility() == View.VISIBLE){
            count++;
        }
        if (cardImageView2.getVisibility() == View.VISIBLE){
            count++;
        }
        if (cardImageView3.getVisibility() == View.VISIBLE) {
            count++;
        }
        if (cardImageView4.getVisibility() == View.VISIBLE) {
            count++;
        }
        if (cardImageView5.getVisibility() == View.VISIBLE) {
            count++;
        }
        if (count == 1){
            sampleText.setText("" + count + " card is selected");
        } else{
            sampleText.setText("" + count + " cards are selected");
        }

    }
}