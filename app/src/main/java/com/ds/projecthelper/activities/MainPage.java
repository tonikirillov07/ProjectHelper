package com.ds.projecthelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;
import com.ds.projecthelper.user.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainPage extends AppCompatActivity {
    private ImageButton mainSettingsButton, mainButton, messengerButton, ideasButton, roadmapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_page);

            mainSettingsButton = findViewById(R.id.mainSettingsButton);
            mainButton = findViewById(R.id.mainButton);
            messengerButton = findViewById(R.id.messengerButton);
            ideasButton = findViewById(R.id.ideasButton);
            roadmapButton = findViewById(R.id.roadmapButton);

            mainSettingsButton.setOnClickListener(v -> startActivity(new Intent(this, MainSettingsPage.class)));
        }catch (Exception e){
            ShowAlerts.showDialog(this, e, true);
        }
    }
}
