package com.ds.projecthelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;

public class MainPage extends AppCompatActivity {
    private ImageButton mainSettingsButton, mainButton, messengerButton, ideasButton, roadmapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        mainSettingsButton = findViewById(R.id.mainSettingsButton);
        mainButton = findViewById(R.id.mainButton);
        messengerButton = findViewById(R.id.messengerButton);
        ideasButton = findViewById(R.id.ideasButton);
        roadmapButton = findViewById(R.id.roadmapButton);

        mainSettingsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainSettingsPage.class));
        });
    }
}
