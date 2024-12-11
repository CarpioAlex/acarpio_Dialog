package com.acarpio.acarpio_dialog;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.HashMap;

public class CharCounter implements TextWatcher {
    HashMap<String, View> views;
    private TextView infoTextView;
    private EditText password1;
    private EditText password2;
    private Button button;
    public CharCounter(HashMap<String, View> views) {
        this.views = views;
         infoTextView = (TextView) views.get("infoTextView");
         password1 = (EditText) views.get("password1");
         password2 = (EditText) views.get("password2");
         button = (Button) views.get("button");
    }



    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        infoTextView.setTextColor(ContextCompat.getColor(infoTextView.getContext(), R.color.red));
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (password1.getText().toString().equals(password2.getText().toString())) {
            infoTextView.setText("Passwords match!");
            infoTextView.setTextColor(ContextCompat.getColor(infoTextView.getContext(), R.color.green));
            button.setEnabled(true);
        } else {
            infoTextView.setText("Passwords must match!");
            button.setEnabled(false);
        }
    }


    @Override
    public void afterTextChanged(Editable s) {
        // Not used
    }
}