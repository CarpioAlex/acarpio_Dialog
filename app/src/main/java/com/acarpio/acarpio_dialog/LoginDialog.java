package com.acarpio.acarpio_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginDialog extends DialogFragment {
    TextView target;
    TextView infoTextView;
    EditText password1;
    EditText password2;
    EditText user;
    public LoginDialog(TextView target) {
        this.target = target;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater.
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because it's going in the dialog layout.
        View dialogView = inflater.inflate(R.layout.dialog_signin, null);
        builder.setView(dialogView);
        // Add action buttons
                builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        target.setText("Hello! " + user.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginDialog.this.getDialog().cancel();
                    }
                });
        AlertDialog dialog = builder.create();


        dialog.setOnShowListener(dialogInterface -> {

            password1 = dialogView.findViewById(R.id.password);
            password2 = dialogView.findViewById(R.id.password2);
            user = dialogView.findViewById(R.id.username);
            infoTextView = dialogView.findViewById(R.id.infoTextView);


            Button signInButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);


            HashMap<String, View> views = new HashMap<>();
            views.put("password1", password1);
            views.put("password2", password2);
            views.put("username", user);
            views.put("infoTextView", infoTextView);
            views.put("button", signInButton);


            signInButton.setEnabled(false);


            CharCounter counter = new CharCounter(views);
            password1.addTextChangedListener(counter);
            password2.addTextChangedListener(counter);
        });

        return dialog;
    }
}


