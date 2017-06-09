package com.rallymonkey911.android.pokertrainer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jeff on 6/9/2017.
 */

public class ChangeBetDialogFragment extends DialogFragment {

    int bet, wallet;
    TextView betTextView;
    Button increaseBet, decreaseBet;
    GameActivity gameActivity;

    static final int MINIMUM_BET = 10;

    /* The activity that creates an instance of this dialog fragment must
    implement this interface in order to receive event callbacks.
    Each method passes the DialogFragment in case the host needs to query it. */
    public interface ChangeBetDialogListener {
        void onDialogPositiveClick(int bet);
        void onDialogNegativeClick(DialogFragment dialogFragment);
    }
    // Use this instance of the interface to deliver action events
    ChangeBetDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the ChangeBetDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (ChangeBetDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        gameActivity = (GameActivity) getActivity();

        bet = gameActivity.bet;
        wallet = gameActivity.wallet;


        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // Inflate and set the layout for the dialog
        View dialogView = inflater.inflate(R.layout.change_bet_layout, null);
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(dialogView)
                .setTitle(R.string.dialog_change_bet)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogPositiveClick(bet);
                    }})
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(ChangeBetDialogFragment.this);
                    }
                });

        betTextView = (TextView) dialogView.findViewById(R.id.bet_change_dialog);
        increaseBet = (Button) dialogView.findViewById(R.id.increase_bet_button);
        decreaseBet = (Button) dialogView.findViewById(R.id.decrease_bet_button);

        betTextView.setText(String.valueOf(bet));

        increaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementBet();
            }
        });
        decreaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementBet();
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }

    public void incrementBet() {
        if (bet < wallet) {
            bet = bet + MINIMUM_BET;
        }
        betTextView.setText(String.valueOf(bet));
    }

    public void decrementBet() {
        if (bet > MINIMUM_BET) {
            bet = bet - MINIMUM_BET;
        }
        betTextView.setText(String.valueOf(bet));
    }
}
