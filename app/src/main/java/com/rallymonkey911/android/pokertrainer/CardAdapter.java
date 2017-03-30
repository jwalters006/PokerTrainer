package com.rallymonkey911.android.pokertrainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * {@link CardAdapter} is an {@link ArrayAdapter} that can provide the View for each list
 * based on a data source, which is a list of {@link Card} objects.
 * Created by jeff on 3/28/2017.
 */

class CardAdapter extends ArrayAdapter<List<Card>> {

    /**
     * Custom constructor for supplying Card objects to complex layout.
     * @param context The current context, used to inflate the layout file.
     * @param cards A list of Card objects to display in a list.
     */
    CardAdapter(Context context, List<List<Card>> cards){
        super(context, 0, cards);
    }

    @Override
    public View getView(int position, final View convertView, final ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the List<Card> object (representing all cards in a particular suit) located at a
        // given position in the list
        final List<Card> currentSuit = getItem(position);

        // Find the ImageViews in the list_item.xml layout.
        final ImageView aceImage = (ImageView) listItemView.findViewById(R.id.ace_image);
        final ImageView deuceImage = (ImageView) listItemView.findViewById(R.id.deuce_image);
        final ImageView threeImage = (ImageView) listItemView.findViewById(R.id.three_image);
        final ImageView fourImage = (ImageView) listItemView.findViewById(R.id.four_image);
        final ImageView fiveImage = (ImageView) listItemView.findViewById(R.id.five_image);
        final ImageView sixImage = (ImageView) listItemView.findViewById(R.id.six_image);
        final ImageView sevenImage = (ImageView) listItemView.findViewById(R.id.seven_image);
        final ImageView eightImage = (ImageView) listItemView.findViewById(R.id.eight_image);
        final ImageView nineImage = (ImageView) listItemView.findViewById(R.id.nine_image);
        final ImageView tenImage = (ImageView) listItemView.findViewById(R.id.ten_image);
        final ImageView jackImage = (ImageView) listItemView.findViewById(R.id.jack_image);
        final ImageView queenImage = (ImageView) listItemView.findViewById(R.id.queen_image);
        final ImageView kingImage = (ImageView) listItemView.findViewById(R.id.king_image);

        // Display the images for this row of Cards
        aceImage.setImageResource(currentSuit.get(0).getmResourceId());
        deuceImage.setImageResource(currentSuit.get(1).getmResourceId());
        threeImage.setImageResource(currentSuit.get(2).getmResourceId());
        fourImage.setImageResource(currentSuit.get(3).getmResourceId());
        fiveImage.setImageResource(currentSuit.get(4).getmResourceId());
        sixImage.setImageResource(currentSuit.get(5).getmResourceId());
        sevenImage.setImageResource(currentSuit.get(6).getmResourceId());
        eightImage.setImageResource(currentSuit.get(7).getmResourceId());
        nineImage.setImageResource(currentSuit.get(8).getmResourceId());
        tenImage.setImageResource(currentSuit.get(9).getmResourceId());
        jackImage.setImageResource(currentSuit.get(10).getmResourceId());
        queenImage.setImageResource(currentSuit.get(11).getmResourceId());
        kingImage.setImageResource(currentSuit.get(12).getmResourceId());

        // Set OnClickListener for each element in the ListView item
        aceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(0);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        deuceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(1);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(2);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(3);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        fiveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(4);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        sixImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(5);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        sevenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(6);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        eightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(7);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        nineImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(8);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        tenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(9);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        jackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(10);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        queenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(11);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        kingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card currentCard = currentSuit.get(12);
                addOrRemoveCardFromHand(v, currentCard);
            }
        });

        // Return the list item layout so that it can be shown in the ListView
        return listItemView;
    }

    /**
     * Helper function implemented inside of onClick for the ImageViews.  Adds or removes cards from
     * the hand when user clicks cards.
     * @param v The View passed in from the onClick call
     * @param currentCard The Card object passed in from the onClick call
     */
    private void addOrRemoveCardFromHand(View v, Card currentCard){
        ImageView cardImage = (ImageView) v;

        if (!cardImage.isSelected()){
            if (MainActivity.hand.size() == 5){return;}
            cardImage.setSelected(true);
            cardImage.setImageAlpha(61);
            MainActivity.addCardToHand(currentCard);
        } else{
            cardImage.setSelected(false);
            cardImage.setImageAlpha(255);
            MainActivity.removeCardFromHand(currentCard);
        }
    }
}