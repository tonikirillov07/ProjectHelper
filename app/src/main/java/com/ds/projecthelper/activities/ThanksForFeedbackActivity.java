package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.dialogs.ErrorDialog;

public class ThanksForFeedbackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.thanks_for_your_feedback);

            Button buttonBack = findViewById(R.id.buttonBack);
            buttonBack.setOnClickListener(v -> finish());
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }
}
