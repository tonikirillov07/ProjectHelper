package com.ds.projecthelper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ds.projecthelper.R;

public class InitialSetupFirstActivity extends AppCompatActivity {
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup_first);

        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> {

        });
    }


}