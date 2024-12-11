package com.acarpio.acarpio_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class ListDialog extends DialogFragment {
    TextView target;
    ArrayList<Integer> selectedItems;
    public ListDialog(TextView target) {
        this.target = target;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        selectedItems = new ArrayList();  // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title.
        builder.setTitle("Pick something!")
                // Specify the list array, the items to be selected by default (null for
                // none), and the listener through which to receive callbacks when items
                // are selected.
                .setMultiChoiceItems(R.array.picks, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checks the item, add it to the selected
                                    // items.
                                    selectedItems.add(which);
                                } else if (selectedItems.contains(which)) {
                                    // If the item is already in the array, remove it.
                                    selectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User taps OK, so save the selectedItems results
                        // somewhere or return them to the component that opens the
                        // dialog.
                        String result = "";
                        String[] items = getResources().getStringArray(R.array.picks);
                        for (int item : selectedItems) {

                            result = result + items[item] + " ";
                        }
                        target.setText(result);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}

