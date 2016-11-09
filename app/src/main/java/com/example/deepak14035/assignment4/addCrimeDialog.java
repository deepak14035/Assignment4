package com.example.deepak14035.assignment4;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by deepak14035 on 09/11/2016.
 */
public class addCrimeDialog extends DialogFragment {
    public static final String TITLE_TAG="CRIME TITLE", DATE_TAG="CRIME DATE";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View textEntryView = inflater.inflate(R.layout.add_crime, null);

        builder.setView(textEntryView)
                // Add action buttons
                .setPositiveButton(R.string.addCrime, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        Crime cr = new Crime();
                        EditText dateText=(EditText)textEntryView.findViewById(R.id.addDate);
                        EditText titleText=(EditText)textEntryView.findViewById(R.id.addTitle);

                        cr.setDate(dateText.getText().toString());
                        cr.setTitle(titleText.getText().toString());
                        cr.setId(UUID.randomUUID());
                        CrimeListFragment.mAdapter.mCrimes.add(cr);
                    }
                })
                .setNegativeButton(R.string.cancelCrime, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

}
