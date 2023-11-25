package com.ds.projecthelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;

public class InitialSetupThirdActivity extends AppCompatActivity {
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_setup_third);

        nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainPage.class));
        });
    }
}
